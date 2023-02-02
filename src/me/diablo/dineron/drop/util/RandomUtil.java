package me.diablo.dineron.drop.util;

import java.util.Random;

public class RandomUtil {

    public static boolean random(double chance) {
        Random random = new Random();
        return (random.nextDouble() * 100D) < chance;
    }

    public static int randomAmount(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static double percentage(double obtained, double total) {
        return (obtained < 0 ? 1 : obtained * total) / 100.0D;
    }
}