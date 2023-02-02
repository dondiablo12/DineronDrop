package me.diablo.dineron.drop;

import me.diablo.dineron.drop.command.RegisterCommand;
import me.diablo.dineron.drop.data.DataPlugin;
import me.diablo.dineron.drop.listener.RegisterListener;
import me.diablo.dineron.drop.object.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onLoad() {

        DataPlugin dataPlugin = new DataPlugin();
        dataPlugin.load(this);

        super.onLoad();
    }

    @Override
    public void onEnable() {

        new RegisterListener(this);
        new RegisterCommand(this);

        for(Player player : Bukkit.getOnlinePlayers()) {
            new User(player.getName());
        }

        super.onEnable();
    }
}