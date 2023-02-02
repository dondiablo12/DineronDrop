package me.diablo.dineron.drop.object;

import com.google.common.collect.Sets;
import me.diablo.dineron.drop.object.util.ItemDropUtil;
import me.diablo.dineron.drop.object.util.UserUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class User extends UserUtil {

    private String name;
    private Set<ItemDrop> itemDrops;

    public User(String name) {
        this.name = name;
        this.itemDrops = Sets.newConcurrentHashSet();

        this.addUser(this);
    }

    public void delete() {
        UserUtil.getUsers().remove(this);
    }

    public int getFortune() {

        Player player = Bukkit.getPlayer(this.name);
        ItemStack itemInHand = player.getItemInHand();

        if(itemInHand == null || itemInHand.getType() == Material.AIR) {
            return -1;
        }

        if(!itemInHand.getType().name().contains("PICKAXE")) {
            return -1;
        }

        return itemInHand.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) - 1;
    }

    public boolean enableItem(ItemDrop itemDrop) {
        return itemDrops.contains(itemDrop);
    }

    public void enabled(boolean all) {
        if(all) {
            itemDrops.addAll(ItemDropUtil.getItems());
        } else {
            itemDrops.clear();
        }
    }

    public void setEnabled(ItemDrop itemDrop) {
        if(itemDrops.contains(itemDrop)) {
            itemDrops.remove(itemDrop);
        } else {
            itemDrops.add(itemDrop);
        }
    }

    public static User getByName(String name) {
        return UserUtil.getUsers().stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }

    public String getName() {
        return name;
    }

    public Set<ItemDrop> getItemDrops() {
        return itemDrops;
    }
}