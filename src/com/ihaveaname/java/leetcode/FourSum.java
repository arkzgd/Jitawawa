package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  public static List<List<Integer>> solution(int[] nums, Integer target) {
    Arrays.parallelSort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int length = nums.length;
    int fixed = 0;

    while (fixed < length - 3) {
      Integer targetOfThree = target - nums[fixed];
      List<List<Integer>> resultsOfThree =
          ThreeSum.threeSum(nums, fixed + 1, length, targetOfThree);
      if (resultsOfThree.size() > 0) {
        for (int l = 0; l < resultsOfThree.size(); l++) {
          List<Integer> ll = resultsOfThree.get(l);
          List<Integer> nl = new ArrayList<>(1);
          nl.add(nums[fixed]);
          nl.addAll(ll);
          result.add(nl);
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
      System.out.println(i + "-> " + solution(array, i));
    }

    array = new int[]{1,0,-1,0,-2,2};
    System.out.println(solution(array, 0));

    array = new int[]{0, 0, 0, 0};
    System.out.println(solution(array, 0));

    array = new int[]{1,-2,-5,-4,-3,3,3,5};
    System.out.println(solution(array, -11));
  }
}
