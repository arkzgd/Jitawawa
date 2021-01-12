package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class NextPermutation {
  public void nextPermutation(int[] nums) {
    // Leetcode tests including duplicated numbers, like [1, 5, 1]
    int length = nums.length;

    int i;
    for (i = length - 2; i >= 0 && nums[i] >= nums[i + 1]; i--);
    if (i == -1) {
      Arrays.sort(nums);
      return;
    }

    int j;
    for (j = length - 1; j > i && nums[j] <= nums[i]; j--);

    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;

    Arrays.sort(nums, i + 1, length);
  }

  public static void main(String[] args) {
    NextPermutation np = new NextPermutation();

    int[] input = new int[]{1, 2, 3};
    np.nextPermutation(input);
    System.out.println(Arrays.toString(input));

    input = new int[]{1, 1, 5};
    np.nextPermutation(input);
    System.out.println(Arrays.toString(input));
  }
}
