package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEvenOdd {
  private static List<Integer> solutionSortEvenOdd(ArrayList<Integer> input) {
    int left = 0;
    int right = input.size() - 1;

    while (left < right) {
      while (left < input.size() && input.get(left) % 2 == 0) left++;
      while (right >= 0 && input.get(right) % 2 == 1) right--;
      if (left < right) {
        Integer v = input.get(left);
        input.set(left, input.get(right));
        input.set(right, v);
      }
    }

    return input;
  }

  private static boolean validate(ArrayList<Integer> result) {
    System.out.println(result);
    boolean flip = false;
    for (Integer e : result) {
      if (e % 2 == 1) flip = true;
      if (flip && (e % 2 == 0)) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    ArrayList<Integer> input = new ArrayList<>();
    int numberOfValues = 10000;
    for (int i = 0; i < numberOfValues; i++) for (int j = 0; j < i / 100; j++) input.add(i);
    Collections.shuffle(input);

    System.out.println(solutionSortEvenOdd(input));
    assert validate(input);
  }
}
