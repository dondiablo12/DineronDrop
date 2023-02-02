package me.diablo.dineron.drop.init;

import me.diablo.dineron.drop.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiMainDrop {

    public Inventory create() {

        Inventory inv = Bukkit.createInventory(null, 9 * 3, "DROPY");

        ItemStack glass = ItemBuilder.build(Material.STAINED_GLASS_PANE, 15);

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, glass);
        }

        inv.setItem(11, ItemBuilder.build(Material.STONE, "&cDROP Z KAMIENIA", "&7Nacisnij, aby przejsc"));
        inv.setItem(13, ItemBuilder.build(Material.CHEST, "&cDROP Z MAGICZNYCH SKRZYN", "&7Nacisnij, aby przejsc"));

        inv.setItem(15, ItemBuilder.build(Material.MOSSY_COBBLESTONE, "&cDROP Z COBBLEXOW", "&7Nacisnij, aby przejsc"));
        return inv;
    }
}