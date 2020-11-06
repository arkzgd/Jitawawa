package com.ihaveaname.tinyalgos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;

import static com.ihaveaname.tinyalgos.Numbers.*;

public class AppNumbers {
    public static void main(String[] args) throws Throwable {
        Integer[] values = new Integer[99];
        Random rand = new Random();

        for (int i = 0; i < 99; i++) {
            values[i] = rand.nextInt(99) + 1;
        }

        Integer v = Arrays.stream(values).max(Comparator.comparingInt(Integer::intValue)).orElseThrow(
                (Supplier<Throwable>) () -> new IllegalArgumentException("No max element found."));
        Integer i = findMax(values);
        System.out.println("findMax() -> " + i + " equals " + v);

        Integer j = findMax_binary(values);
        System.out.println("findMax_binary() -> " + j + " equals " + v);

        v = Arrays.stream(values).min(Comparator.comparingInt(Integer::intValue)).orElseThrow(
                (Supplier<Throwable>) () -> new IllegalArgumentException("No min element found."));

        i = findMin(values);
        System.out.println("findMin() -> " + i + " equals " + v);

        j = findMin_binary(values);
        System.out.println("findMin_binary() -> " + j + " equals " + v);
    }
}
