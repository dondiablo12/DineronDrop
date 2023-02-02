package me.diablo.dineron.drop.listener;

import me.diablo.dineron.drop.init.GuiDrop;
import me.diablo.dineron.drop.object.ItemDrop;
import me.diablo.dineron.drop.object.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Inventory inv = event.getInventory();

        ItemStack clickedItem = event.getCurrentItem();

        if(clickedItem == null || clickedItem.getType() == Material.AIR) {
            return;
        }

        if (inv == null)  {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        User user = User.getByName(player.getName());

        if(inv.getTitle().equals("DROPY")) {

            event.setCancelled(true);

            switch(clickedItem.getType()) {

                case STONE: {
                    player.openInventory(new GuiDrop().create(user));

                    break;
                }

                case CHEST: {
                    player.openInventory(new me.diablo.dineron.premiumcase.init.GuiDrop().create());

                    break;
                }

                case MOSSY_COBBLESTONE: {
                    player.openInventory(new net.diablo.dineron.cobblex.init.GuiDrop().create());
                }
            }

            return;
        }

        if(!inv.getTitle().equals("DROP")) {
            return;
        }

        event.setCancelled(true);

        int rawSlot = event.getRawSlot();

        if (rawSlot >= inv.getSize()) {
            return;
        }

        if(clickedItem.getType() == Material.STAINED_GLASS_PANE) {

            short data = clickedItem.getDurability();

            switch(data) {

                case 5: {
                    user.enabled(true);
                    break;
                }

                case 14: {
                    user.enabled(false);
                }
            }

            player.openInventory(new GuiDrop().create(user));
            return;
        }

        ItemDrop itemDrop = ItemDrop.getBySlot(rawSlot);

        if (itemDrop == null) {
            return;
        }

        user.setEnabled(itemDrop);

        player.openInventory(new GuiDrop().create(user));

    }
}
