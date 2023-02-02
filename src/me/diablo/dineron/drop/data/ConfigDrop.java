package me.diablo.dineron.drop.data;

import me.diablo.dineron.drop.Main;
import me.diablo.dineron.drop.object.ItemDrop;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigDrop {

    private Main plugin;

    public ConfigDrop(Main plugin) {
        this.plugin = plugin;
    }

    public void load() {

        File file = new File(this.plugin.getDataFolder(), "drop.yml");

        if(!file.exists()) {
            this.plugin.saveResource("drop.yml", true);
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        for(String string : config.getKeys(false)) {

            ConfigurationSection section = config.getConfigurationSection(string);

            Material material = Material.getMaterial(section.getString("item"));
            double chance = section.getDouble("chance");
            int max, min;

            max = section.getInt("max");
            min = section.getInt("min");

            new ItemDrop(material, max, min, chance);
        }
    }
}