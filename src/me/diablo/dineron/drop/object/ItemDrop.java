package me.diablo.dineron.drop.object;

import me.diablo.dineron.drop.object.util.ItemDropUtil;
import org.bukkit.Material;

public class ItemDrop extends ItemDropUtil {

    private Material material;
    private double chance;
    private int max, min;
    private int slot;

    public ItemDrop(Material material, int max, int min, double chance) {
        this.material = material;
        this.max = max;
        this.min = min;
        this.chance = chance;

        this.addItemDrop(this);
    }

    public static ItemDrop getBySlot(int slot) {
        return ItemDropUtil.getItems().stream().filter(itemDrop -> itemDrop.getSlot() == slot).findAny().orElse(null);
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return slot;
    }

    public double getChance() {
        return chance;
    }

    public Material getMaterial() {
        return material;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}