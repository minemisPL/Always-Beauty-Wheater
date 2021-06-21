package me.minemis.alwaysbeautyweather.utils;

import java.util.List;

public class ChatUtils {

    private ChatUtils() {}

    public static boolean compare(List<String> list, String toCompare) {
        for (String s : list) {
            if (s.equalsIgnoreCase(toCompare)) {
                return true;
            }
        }

        return false;
    }

}
