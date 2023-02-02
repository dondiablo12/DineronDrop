package me.diablo.dineron.drop.listener;

import me.diablo.dineron.drop.Main;

public class RegisterListener {

    public RegisterListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoin(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InventoryClick(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerQuit(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockBreak(), plugin);
    }
}