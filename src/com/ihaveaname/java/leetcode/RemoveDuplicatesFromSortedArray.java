package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int slow = 0;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[slow]) nums[++slow] = nums[fast];
    }

    return slow + 1;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();

    int[] inputs = new int[] {1, 1, 2};
    int length = rdfsa.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 2;

    inputs = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    length = rdfsa.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 5;
  }
}
