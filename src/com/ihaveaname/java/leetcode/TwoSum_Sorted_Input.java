package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class TwoSum_Sorted_Input {
  int[] result = new int[2];
  int i, j;

  public int[] twoSum(int[] numbers, int target) {
    for (i = 0; i < numbers.length - 1; i++) {
      j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
      if (j > -1) break;
    }

    result[0] = i + 1;
    result[1] = j + 1;
    return result;
  }

  public static void main(String[] args) {
    TwoSum_Sorted_Input tsi = new TwoSum_Sorted_Input();
    int[] input = {2, 7, 11, 15};
    System.out.println(Arrays.toString(tsi.twoSum(input, 9)));

    int[] input2 = {5, 25, 75};
    System.out.println(Arrays.toString(tsi.twoSum(input2, 100)));

    int[] input3 = {3, 24, 50, 79, 88, 150, 345};
    System.out.println(Arrays.toString(tsi.twoSum(input3, 200)));
  }
}
