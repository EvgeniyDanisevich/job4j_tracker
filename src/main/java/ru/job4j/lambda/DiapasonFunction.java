package ru.job4j.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class DiapasonFunction {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new LinkedList<>();
        for (; start < end; start++) {
            list.add(func.apply((double) start));
        }
        return list;
    }
}
