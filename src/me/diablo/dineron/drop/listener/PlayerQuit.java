package me.diablo.dineron.drop.listener;

import me.diablo.dineron.drop.object.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        User user = User.getByName(player.getName());

        if (user != null) {
            user.delete();
        }
    }
}