package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String firstElO1 = o1.split("/")[0];
        String firstElO2 = o2.split("/")[0];
        int result = firstElO2.compareTo(firstElO1);
        return result == 0 ? o1.compareTo(o2) : result;
    }
}