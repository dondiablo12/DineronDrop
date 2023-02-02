package me.diablo.dineron.drop.command;

import me.diablo.dineron.drop.Main;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;

public class RegisterCommand {

    public RegisterCommand(Main plugin) {

        CraftServer craftServer = ((CraftServer)plugin.getServer());

        craftServer.getCommandMap().register("dineronDrop", new CommandDrop("drop"));
    }
}