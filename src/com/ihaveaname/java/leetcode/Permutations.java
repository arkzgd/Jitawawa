package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> clone = new ArrayList<>(nums.length);
    for (int e : nums) clone.add(e);
    result.add(clone);

    boolean ind;
    do {
      ind = nextPermutation(nums);
      if (!ind) {
        clone = new ArrayList<>(nums.length);
        for (int e : nums) clone.add(e);
        result.add(clone);
      }
    } while (!ind);

    return result;
  }

  private boolean nextPermutation(int[] nums) {
    int left;
    for (left = nums.length - 2; left >= 0 && nums[left] > nums[left + 1]; left--)
      ;
    if (left < 0) return true; // Already the highest ordered permutation

    int right;
    for (right = nums.length - 1; right > left && nums[right] < nums[left]; right--)
      ;

    swap(nums, left, right);
    reverse(nums, left + 1, nums.length - 1);

    return false; // Not yet the highest ordered permutation
  }

  private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  private void reverse(int[] nums, int start, int end) {
    int low = start;
    int high = end;
    while (low < high) swap(nums, low++, high--);
  }

  public static void main(String[] args) {
    Permutations permutations = new Permutations();
    int[] input = new int[] {0};
    System.out.println(permutations.permute(input));

    input = new int[] {0, 1};
    System.out.println(permutations.permute(input));

    input = new int[] {0, 1, 2};
    System.out.println(permutations.permute(input));

    input = new int[] {0, 1, 3, 2};
    System.out.println(permutations.permute(input));
  }
}
