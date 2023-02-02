package me.diablo.dineron.drop.init;

import me.diablo.dineron.drop.data.Config;
import me.diablo.dineron.drop.object.ItemDrop;
import me.diablo.dineron.drop.object.User;
import me.diablo.dineron.drop.object.util.ItemDropUtil;
import me.diablo.dineron.drop.util.ItemBuilder;
import me.diablo.dineron.drop.util.RandomUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class GuiDrop {

    private User user;
    private Config config;

    public Inventory create(User user) {

        this.user = user;
        this.config = Config.getInstance();

        List<ItemDrop> items = ItemDropUtil.getItems();

        //int size = ((items.size() / 9) + 1) + 2;
        Inventory inv = Bukkit.createInventory(null, 9*4, "DROP");

        ItemStack allOn = ItemBuilder.build(Material.STAINED_GLASS_PANE, "&cWyłącz wszystko", 14, "&7Naciśnij, aby wyłączyć każdy item.");
        ItemStack allOff = ItemBuilder.build(Material.STAINED_GLASS_PANE, "&aWłącz wszystko", 5, "&7Naciśnij, aby włączyć każdy item.");
        ItemStack allGuild = ItemBuilder.build(Material.STAINED_GLASS_PANE, "&eWłącz tylko itemy na gildie", 4, "&7Naciśnij, aby włączyć.");
        ItemStack turboDrop = ItemBuilder.build(Material.DIAMOND_PICKAXE, "&cTurboDrop", "&7Tutaj będą się wyświetlać informacje o turbodropie");

        for (int i = 0; i < items.size(); i++) {

            ItemDrop itemDrop = ItemDropUtil.getItems().get(i);

            int slot = itemDrop.getMaterial() == Material.COBBLESTONE ? 35 : i;
            itemDrop.setSlot(slot);

            inv.setItem(slot, ItemBuilder.build(itemDrop.getMaterial(), "", lore(itemDrop, user), user.enableItem(itemDrop) ? Enchantment.DURABILITY : null));
        }

        inv.setItem(27, allOff);
        inv.setItem(28, allOn);
        inv.setItem(29, allGuild);
        inv.setItem(34, turboDrop);

        return inv;
    }

    private List<String> lore(ItemDrop itemDrop, User user) {
        return Arrays.asList(
                "&7Szansa&8: &c" + itemDrop.getChance() + "%",
                "&7Ilosc&8: &7min &c" + itemDrop.getMin() + "x &7max &c" + itemDrop.getMax() + "x",
                "",
                "&7Informacje - Fortuna&8:",
                "&7Fortuna &cI&8: &a+ &c" + String.format("%.2f", Config.getInstance().fortune[0]) + "%",
                "&7Fortuna &cII&8: &a+ &c" + String.format("%.2f", Config.getInstance().fortune[1]) + "%" ,
                "&7Fortuna &cIII&8: &a+ &c" + String.format("%.2f", Config.getInstance().fortune[2]) + "%",
                "",
                String.format("&7Suma&8: &c%.2f%%", (user.getFortune() < 0 ? 0 : RandomUtil.percentage(this.config.fortune[user.getFortune()], itemDrop.getChance())) + itemDrop.getChance()),
                "",
                "&7Status&8: " + (this.user.enableItem(itemDrop) ? "&aAktualnie włączony" : "&cAktualnie wyłączony")
        );
    }
}
