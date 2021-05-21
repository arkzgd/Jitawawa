package com.ihaveaname.java.leetcode.tree;

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

  // This only works when the duplicated number only appears ONCE
  public int findDuplicate(int[] nums) {
    return sum(nums) - sum(nums.length - 1);
  }

  // Slow and typical solution
  public int findDuplicate_sort_and_search(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) return nums[i];
    }

    return 0;
  }

  // Look for the duplicated array index, same idea as detecting loops in linked list
  public int findDuplicate_cycle_detect(int[] nums) {
    int slow = 0;
    int fast = 0;

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }

  public static void main(String[] args) {
    DuplicatedNumber dn = new DuplicatedNumber();

    int[] nums = new int[]{1, 3, 4, 2, 2};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_cycle_detect(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));

    nums = new int[]{3,1,3,4,2};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_cycle_detect(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));

    nums = new int[]{1, 1};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_cycle_detect(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));

    nums = new int[]{1, 1, 2};
    System.out.println(dn.findDuplicate(nums));
    System.out.println(dn.findDuplicate_cycle_detect(nums));
    System.out.println(dn.findDuplicate_sort_and_search(nums));
  }
}
