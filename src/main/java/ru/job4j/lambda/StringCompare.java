package ru.job4j.lambda;

import java.util.Comparator;

public class StringCompare {
    private Comparator<String> cmpText = (left, right) -> left.compareTo(right);

    private Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("compare - " + right.length() + " : " + left.length());
        return Integer.compare(right.length(), left.length());
    };

    public Comparator<String> getCmpText() {
        return cmpText;
    }

    public Comparator<String> getCmpDescSize() {
        return cmpDescSize;
    }
}
