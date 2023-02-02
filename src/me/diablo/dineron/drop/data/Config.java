package me.diablo.dineron.drop.data;

import me.diablo.dineron.drop.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static Config instance;

    public double[] fortune;

    public Config() {
        instance = this;
    }

    public void load(Main plugin) {

        plugin.saveDefaultConfig();

        FileConfiguration config = plugin.getConfig();

        this.fortune = new double[3];

        ConfigurationSection fortune = config.getConfigurationSection("fortune");

        this.fortune[0] = fortune.getDouble("1");
        this.fortune[1] = fortune.getDouble("2");
        this.fortune[2] = fortune.getDouble("3");

    }

    public static Config getInstance() {
        if (instance == null) {
            new Config();
        }

        return instance;
    }

}
