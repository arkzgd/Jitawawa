package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class TwoSum_Sorted_Input {
  public int[] twoSum(int[] numbers, int target) {
    int numTarget;
    for (int i = 0; i < numbers.length; i++) {
      numTarget = target - numbers[i];
      int j;
      if ((j = Arrays.binarySearch(numbers, 0, i, numTarget)) > -1) {
        int[] result = new int[2];
        result[0] = j + 1;
        result[1] = i + 1;
        return result;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    TwoSum_Sorted_Input tsi = new TwoSum_Sorted_Input();
    int[] input = {2, 7, 11, 15};
    System.out.println(Arrays.toString(tsi.twoSum(input, 9)));
  }
}
