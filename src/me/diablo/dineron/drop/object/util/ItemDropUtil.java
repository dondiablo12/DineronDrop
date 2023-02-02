package me.diablo.dineron.drop.object.util;

import com.google.common.collect.Lists;
import me.diablo.dineron.drop.object.ItemDrop;

import java.util.List;

public class ItemDropUtil {

    private static final List<ItemDrop> ITEMS = Lists.newArrayList();

    public static List<ItemDrop> getItems() {
        return ITEMS;
    }

    protected void addItemDrop(ItemDrop itemDrop) {
        ITEMS.add(itemDrop);
    }
}