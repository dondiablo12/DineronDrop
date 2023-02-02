package me.diablo.dineron.drop.command;

import me.diablo.dineron.drop.init.GuiDrop;
import me.diablo.dineron.drop.init.GuiMainDrop;
import me.diablo.dineron.drop.object.User;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class CommandDrop extends BukkitCommand {

    public CommandDrop(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {

        if(!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        User user = User.getByName(player.getName());

        if (user == null) {
            return true;
        }

        player.openInventory(new GuiMainDrop().create());

        return false;
    }
}
