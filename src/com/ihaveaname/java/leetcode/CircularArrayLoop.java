package com.ihaveaname.java.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {
  private int next(int i, int[] nums, int length) {
    if (i + nums[i] > 0) {
      System.out.format("%d + %d -> %d\n", i, nums[i], (i + nums[i]) % length);
      return (i + nums[i]) % length;
    } else if (i + nums[i] < 0) {
      System.out.format("%d + %d -> %d\n", i, nums[i], (length - i - nums[i]) % length);
      return (length - i - nums[i]) % length;
    } else {
      System.out.format("%d + %d -> %d\n", i, nums[i], 0);
      return 0;
    }
  }

  private boolean sameDir(int i, int j, int[] nums) {
    return nums[i] > 0 && nums[j] > 0 || nums[i] < 0 && nums[j] < 0;
  }

  // Can I say there must be a loop in the array, given the array is circular and its elements can't
  // be zero?
  public boolean circularArrayLoop(int[] nums) {
    if (nums.length == 0) return false;

    Set<Integer> set = new HashSet<>();
    int n = nums.length;
    int i = 0;

    do {
      if (set.contains(i)) {
        int start = i;
        int jumps = 0;
        do {
          if (!sameDir(i, next(i, nums, n), nums)) return false;
          i = next(i, nums, n);
          jumps++;
        } while (i != start);
        if (jumps == 1) return false;
        return true;
      }
      set.add(i);
      i = next(i, nums, n);
    } while (true);
  }

  public static void main(String[] args) {
    CircularArrayLoop cal = new CircularArrayLoop();

    int[] inputs = new int[] {2, -1, 1, 2, 2};
    System.out.println(cal.circularArrayLoop(inputs));

    inputs = new int[] {-1, 2};
    System.out.println(cal.circularArrayLoop(inputs));

    inputs = new int[] {-2, 1, -1, -2, -2};
    System.out.println(cal.circularArrayLoop(inputs));

    inputs = new int[] {3, 1, 2};
    System.out.println(cal.circularArrayLoop(inputs));
  }
}
