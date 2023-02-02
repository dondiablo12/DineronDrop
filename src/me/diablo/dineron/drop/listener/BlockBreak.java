package me.diablo.dineron.drop.listener;

import me.diablo.dineron.drop.data.Config;
import me.diablo.dineron.drop.object.ItemDrop;
import me.diablo.dineron.drop.object.User;
import me.diablo.dineron.drop.object.util.ItemDropUtil;
import me.diablo.dineron.drop.util.RandomUtil;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreak implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBreak(BlockBreakEvent event) {

        if (event.isCancelled()) {
            event.setCancelled(true);

            return;
        }

        Block block = event.getBlock();

        if(block.getType() != Material.STONE) {
            return;
        }

        Player player = event.getPlayer();

        if (player.getGameMode() != GameMode.SURVIVAL) {
            return;
        }

        player.giveExp(3);

        User user = User.getByName(player.getName());
        Config config = Config.getInstance();
        block.setType(Material.AIR);

        double y = player.getLocation().getY();

        for(ItemDrop itemDrop : ItemDropUtil.getItems()) {

            if(!user.enableItem(itemDrop)) continue;

            double chance = (user.getFortune() < 0 ? 0 : RandomUtil.percentage(config.fortune[user.getFortune()], itemDrop.getChance())) + itemDrop.getChance();

            if(RandomUtil.random(chance)) {

                int amount = RandomUtil.randomAmount(itemDrop.getMax(), itemDrop.getMin());

                ItemStack item = new ItemStack(itemDrop.getMaterial(), amount);
                player.getInventory().addItem(item);

            }
        }
    }
}
