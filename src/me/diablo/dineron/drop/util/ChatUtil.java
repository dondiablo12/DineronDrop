package me.diablo.dineron.drop.util;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;

import java.util.List;

public class ChatUtil {

    public static String colored(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> coloredList(List<String> list) {

        List<String> arrayList = Lists.newArrayList();

        for(String string : list) {
            arrayList.add(colored(string));
        }

        return arrayList;
    }
}