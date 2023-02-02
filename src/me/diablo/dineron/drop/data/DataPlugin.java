package me.diablo.dineron.drop.data;

import me.diablo.dineron.drop.Main;

public class DataPlugin {

    public void load(Main plugin) {

        ConfigDrop configDrop = new ConfigDrop(plugin);
        configDrop.load();

        Config config = new Config();
        config.load(plugin);

    }
}