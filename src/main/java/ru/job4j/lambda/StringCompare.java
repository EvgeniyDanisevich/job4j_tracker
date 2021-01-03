package ru.job4j.lambda;

import java.util.Comparator;

public class StringCompare {
    Comparator<String> cmpText = (left, right) -> left.compareTo(right);

    Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("compare - " + right.length() + " : " + left.length());
        return Integer.compare(right.length(), left.length());
    };
}
