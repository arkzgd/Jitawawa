package com.ihaveaname.java.tinyalgos;

import java.util.*;

public class NumberTheroy {
  // 一个正整数的约数必然不会大于其值的一半（其自身除外）
  public static int aliquotSum(int number) {
    int sum = 0;
    for (int i = 1; i <= number / 2; ++i) {
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

  // 一个正整数的约数必然不会大于其值的一半（其自身除外）
  static List<Integer> divisors(int number) {
    List<Integer> result = new LinkedList<>();

    for (int i = 1; i < number / 2; i++) {
      if (number % i == 0) result.add(i);
    }

    return result;
  }

  public static boolean isPrimeNumber(int number) {
    if (number == 2) return true;
    if (number < 2 || number % 2 == 0) return false;

    for (int i = 3; i <= Math.sqrt(number); i += 2) {
      if (number % i == 0) return false;
    }

    return true;
  }

  public static List<Integer> primeFactorize(int number) {
    Set<Integer> result = new LinkedHashSet<>();
    int origin = number;

    while (number % 2 == 0) {
      number /= 2;
    }
    if (number < origin) result.add(2);

    for (int i = 3; i <= Math.sqrt(number); i += 2) {
      while (number % i == 0) {
        result.add(i);
        number /= i;
      }
    }

    if (number > 2) result.add(number);

    return new ArrayList<Integer>(result);
  }

  public static void main(String[] args) {
    System.out.print("Prime numbers less than 100: ");
    for (int i = 0; i <= 100; i++) if (isPrimeNumber(i)) System.out.print(i + " ");
    System.out.println();

    List r = primeFactorize(100);
    System.out.println("Prime factors of 100: " + Arrays.toString(r.toArray()));

    long start = System.nanoTime();
    List result = amicableNumbers(1, 3000);
    long end = System.nanoTime();
    long taken = (end - start) / 1000000;
    System.out.println("[" + taken + " ms] Result: " + Arrays.toString(result.toArray()));

    start = System.nanoTime();
    result = amicableNumbers_recursive(1, 3000);
    end = System.nanoTime();
    taken = (end - start) / 1000000;
    System.out.println("[" + taken + " ms] Result: " + Arrays.toString(result.toArray()));

    result = divisors(3000);
    System.out.println(Arrays.toString(result.toArray()));
  }
}
