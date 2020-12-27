package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class Utils {
  public static Integer[] sort(Integer[] input) {
    Arrays.sort(input, Integer::compareTo);

    return input;
  }

  public static Integer sum(Integer[] input, int fixed, int left, int right) {
    return input[fixed] + input[left] + input[right];
  }

  public static Integer sum(int[] input, int fixed, int left, int right) {
    return input[fixed] + input[left] + input[right];
  }
}
