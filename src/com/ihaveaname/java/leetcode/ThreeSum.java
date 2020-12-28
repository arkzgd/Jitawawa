package com.ihaveaname.java.leetcode;

import java.util.*;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums, int target) {
    return threeSum(nums, 0, nums.length, target);
  }

  public static List<List<Integer>> threeSum(int[] nums, int start, int end, int target) {
    Arrays.parallelSort(nums, start, end);
    List<List<Integer>> result = new ArrayList<>();

    int length = end - start;

    for (int fixed = start; fixed < length - 2 && nums[fixed] <= target; ) {
      int left = fixed + 1;
      int right = length - 1;

      while (left < right) {
        int s = nums[fixed] + nums[left] + nums[right];
        if (s == target) {
          result.add(Arrays.asList(nums[fixed], nums[left], nums[right]));

          while (left + 1 < length && nums[left] == nums[left + 1]) left++;
          left++;
          while (right - 1 >= 0 && nums[right] == nums[right - 1]) right--;
          right--;
        } else if (s < target) {
          while (left + 1 < length && nums[left] == nums[left + 1]) left++;
          left++;
        } else if (s > target) {
          while (right - 1 >= 0 && nums[right] == nums[right - 1]) right--;
          right--;
        }
      }

      while (fixed + 1 < length && nums[fixed] == nums[fixed + 1]) fixed++;
      fixed++;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] array = {-1, 0, 1, 2, -1, -4, -9, 9, 8, -2, 3, 6};
    for (int i = 4; i > -5; i--) {
      System.out.println(i + "-> " + threeSum(array, i));
    }

    int[] input = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(input, 0));

    input = new int[] {-2, -3, 0, 0, -2};
    System.out.println(threeSum(input, 0));

    input = new int[] {0, 0};
    System.out.println(threeSum(input, 0));
  }
}
