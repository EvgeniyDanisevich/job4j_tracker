package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int value = Math.min(left.length(), right.length());
        for (int i = 0; i < value; i++) {
            if (left.charAt(i) > right.charAt(i)) {
                return 1;
            } else if (left.charAt(i) < right.charAt(i)) {
                return -1;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}