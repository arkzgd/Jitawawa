package com.ihaveaname.java.tinyalgos;

import java.util.Arrays;

public class Numbers {
    public static <V extends Comparable<V>> V findMax(V[] values) {
        if (values.length == 0) return null;
        if (values.length == 1) return values[0];
        V m = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i].compareTo(m) > 0) m = values[i];
        }

        return m;
    }

    public static <V extends Comparable<V>> V findMax_binary(V[] values) {
        if (values.length == 0) return null;
        if (values.length == 1) return values[0];

        int left = 0;
        int right = values.length;
        int mid = (right - left) >>> 1;
        return max(
                findMax_binary(Arrays.copyOfRange(values, left, mid)),
                findMax_binary(Arrays.copyOfRange(values, mid, right)));
    }

    private static <V extends Comparable<V>> V max(V left, V right) {
        return left.compareTo(right) > 0 ? left : right;
    }

    public static <V extends Comparable<V>> V findMin(V[] values) {
        if (values.length == 0) return null;
        if (values.length == 1) return values[0];
        V m = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i].compareTo(m) < 0) m = values[i];
        }

        return m;
    }

    public static <V extends Comparable<V>> V findMin_binary(V[] values) {
        if (values.length == 0) return null;
        if (values.length == 1) return values[0];

        int left = 0;
        int right = values.length;
        int mid = (right - left) >>> 1;
        return min(
                findMin_binary(Arrays.copyOfRange(values, left, mid)),
                findMin_binary(Arrays.copyOfRange(values, mid, right)));
    }

    private static <V extends Comparable<V>> V min(V left, V right) {
        return left.compareTo(right) < 0 ? left : right;
    }
}
