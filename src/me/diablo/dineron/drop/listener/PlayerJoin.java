package me.diablo.dineron.drop.listener;

import me.diablo.dineron.drop.object.ItemDrop;
import me.diablo.dineron.drop.object.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        User user = new User(player.getName());

        for(ItemDrop itemDrop : ItemDrop.getItems()) {
            user.setEnabled(itemDrop);
        }
    }
}
