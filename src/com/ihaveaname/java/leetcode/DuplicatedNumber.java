package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class DuplicatedNumber {
  int sum(int n) {
    return (1 + n) * n / 2;
  }

  int sum(int[] nums) {
    int s = 0;
    for (int i : nums) s += i;

    return s;
  }

  public int findDuplicate(int[] nums) {
    return sum(nums) - sum(nums.length - 1);
  }

  public int findDuplicate_sort_and_search(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) return nums[i];
    }

    return 0;
  }

  public static void main(String[] args) {
    DuplicatedNumber dn = new DuplicatedNumber();

    int[] nums = new int[]{1, 3, 4, 2, 2};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));

    nums = new int[]{3,1,3,4,2};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));

    nums = new int[]{1, 1};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));

    nums = new int[]{1, 1, 2};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));
  }
}
