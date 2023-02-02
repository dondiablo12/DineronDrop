package me.diablo.dineron.drop.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    public static ItemStack build(Material material, String displayName, Enchantment enchantment, String... lore) {

        ItemStack itemStack = new ItemStack(material);

        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatUtil.colored(displayName));
        meta.setLore(ChatUtil.coloredList(Arrays.asList(lore)));

        if (enchantment != null) {
            meta.addEnchant(enchantment, 1, true);
        }

        itemStack.setItemMeta(meta);

        return itemStack;

    }

    public static ItemStack build(Material material, String displayName, List<String> lore) {
        return build(material, displayName, null, lore.toArray(new String[0]));
    }

    public static ItemStack build(Material material, String displayName, String... lore) {
        return build(material, displayName, null, lore);
    }

    public static ItemStack build(Material material, String displayName, List<String> lore, Enchantment enchantment) {
        return build(material, displayName, enchantment, lore.toArray(new String[0]));
    }

    public static ItemStack build(Material material, String displayName, int data, String... lore) {

        ItemStack itemStack = new ItemStack(material, 1, (short) data);

        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatUtil.colored(displayName));
        meta.setLore(ChatUtil.coloredList(Arrays.asList(lore)));

        itemStack.setItemMeta(meta);

        return itemStack;

    }


    public static ItemStack build(Material material, int data) {
        return new ItemStack(material, 1, (short) data);
    }
}