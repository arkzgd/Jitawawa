package com.ihaveaname.tinyalgos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;

public class Numbers {
    public static <V extends Comparable<V>> V findMax(V[] values) {
        if (values.length == 0) return null;
        if (values.length == 1) return values[0];
        V m = values[0];
        for (int i=0;i<values.length;i++) {
            if (values[i].compareTo(m) > 0) m = values[i];
        }

        return m;
    }

    public static void main(String[] args) throws Throwable {
        Integer[] values = new Integer[100];
        Random rand = new Random();

        for (int i=0;i<100;i++) {
            values[i] = rand.nextInt(100) + 1;
        }

        Integer v = Arrays.stream(values).max(Comparator.comparingInt(Integer::intValue)).orElseThrow(
                (Supplier<Throwable>) () -> new IllegalArgumentException("No max element found."));
        int i = (int) findMax(values);
        System.out.println("findMax() -> " + i + " equals " + v);
    }
}
