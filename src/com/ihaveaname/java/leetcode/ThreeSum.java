package com.ihaveaname.java.leetcode;

import java.util.*;

import static com.ihaveaname.java.leetcode.Utils.sort;
import static com.ihaveaname.java.leetcode.Utils.sum;

public class ThreeSum {
  public static List<List<Integer>> solution(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    int length = nums.length;
    int fixed = 0;
    int left = fixed + 1;
    int right = length - 1;

    for (fixed = 0; fixed <= length - 2 && left < right && nums[fixed] <= target;) {
      int s = sum(nums, fixed, left, right);
      if (s == target) {
        List<Integer> l = new ArrayList<>(3);
        l.add(nums[fixed]);
        l.add(nums[left]);
        l.add(nums[right]);
        result.add(l);

        while (left < length - 1 && nums[left] == nums[left + 1]) left++;
        left++;
        while (right - 1 >= 0 && nums[right] == nums[right - 1]) right--;
        right--;
      } else if (s < target) {
        while (left + 1 <= length - 1 && nums[left] == nums[left + 1]) left++;
        left++;
      } else if (s > target) {
        while (right - 1 >= 0 && nums[right] == nums[right - 1]) right--;
        right--;
      }

      if (left >= right) {
        while (fixed + 1 <= length - 1 && nums[fixed] == nums[fixed + 1]) fixed++;
        fixed++;
        left = fixed + 1;
        right = length - 1;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] array = {-1, 0, 1, 2, -1, -4, -9, 9, 8, -2, 3, 6};
    for (int i = 4; i > -5; i--) {
      System.out.println(i + "-> " + solution(array, i));
    }

    int[] input = {-1, 0, 1, 2, -1, -4};
    System.out.println(solution(input, 0));

    input = new int[] {-2, -3, 0, 0, -2};
    System.out.println(solution(input, 0));

    input = new int[] {0, 0};
    System.out.println(solution(input, 0));
  }
}
