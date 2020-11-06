package com.ihaveaname.tinyalgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberTheroy {
    public static int aliquotSum(int number) {
        int sum = 0;
        for (int i = 1, limit = number / 2; i <= limit; ++i) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static List<Pair<Integer, Integer>> amicableNumbers(int left, int right) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        for (int i = left; i < right; i++)
            for (int j = i + 1; j <= right; j++) {
                if ((i == aliquotSum(j)) && (j == aliquotSum(i))) {
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    result.add(p);
                }
            }

        return result;
    }

    public static List<Pair<Integer, Integer>> amicableNumbers_recursive(int left, int right) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        for (int i = left; i < right; i++)
            for (int j = i + 1; j <= right; j++) {
                if ((i == recursiveCalcOfDividerSum(j, j)) && (j == recursiveCalcOfDividerSum(i, i))) {
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    result.add(p);
                }
            }

        return result;
    }

    static int recursiveCalcOfDividerSum(int number, int div) {

        if (div == 1) {
            return 0;
        } else if (number % --div == 0) {
            return recursiveCalcOfDividerSum(number, div) + div;
        } else {
            return recursiveCalcOfDividerSum(number, div);
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        List result = amicableNumbers(1, 3000);
        long end = System.nanoTime();
        long taken = (end - start) / 1000000;
        System.out.println("[" + String.valueOf(taken) + " ms] Result: " + Arrays.toString(result.toArray()));

        start = System.nanoTime();
        result = amicableNumbers_recursive(1, 3000);
        end = System.nanoTime();
        taken = (end - start) / 1000000;
        System.out.println("[" + String.valueOf(taken) + " ms] Result: " + Arrays.toString(result.toArray()));
    }
}
