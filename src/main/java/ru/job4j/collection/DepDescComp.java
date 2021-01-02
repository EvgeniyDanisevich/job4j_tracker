package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String firstElO1 = o1.split("/")[0];
        String firstElO2 = o2.split("/")[0];
        int result = firstElO2.compareTo(firstElO1);
        if (result == 0) {
            int length = Math.min(o1.length(), o2.length());
            for (int i = 0; i < length; i++) {
                result = Character.compare(o1.charAt(i), o2.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
            return Integer.compare(o1.length(), o2.length());
        }
        return result;
    }
}