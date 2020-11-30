package com.ihaveaname.java.tinyalgos.leetcode;

import java.util.*;

public class ThreeSum {
  public static List<List<Integer>> solution(Integer[] input, Integer target) {
    List<List<Integer>> result = new ArrayList<>();

    int length = input.length;
    int fixed = 0;
    int left = fixed + 1;
    int right = length - 1;

    while (fixed <= length - 2 && input[fixed] < target) {
      Integer s = sum(input, fixed, left, right);
      if (s == target) {
        List<Integer> l = new ArrayList<>(3);
        l.add(input[fixed]);
        l.add(input[left]);
        l.add(input[right]);
        result.add(l);

        while (left < length - 1 && input[left] == input[left + 1]) left++;
        left++;
        while (input[right] == input[right - 1]) right--;
        right--;
      } else if (s < target) {
        while (input[left] == input[left + 1]) left++;
        left++;
      } else if (s > target) {
        while (input[right] == input[right - 1]) right--;
        right--;
      }

      if (left >= right) {
        while (fixed < length - 2 && input[fixed] == input[fixed + 1]) fixed++;
        fixed++;
        left = fixed + 1;
        right = length - 1;
      }
    }

    return result;
  }

  private static Integer sum(Integer[] input, int fixed, int left, int right) {
    return input[fixed] + input[left] + input[right];
  }

  private static Integer[] sort(Integer[] input) {
    Arrays.sort(input, Integer::compareTo);

    return input;
  }

  public static void main(String[] args) {
    Integer[] array = {-1, 0, 1, 2, -1, -4};

    for (int i = 4; i > -5; i--) {
      System.out.println(i + "-> " + solution(sort(array), i));
    }
  }
}
