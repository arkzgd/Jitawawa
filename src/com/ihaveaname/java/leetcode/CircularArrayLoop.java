package com.ihaveaname.java.leetcode;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {

  // Return next index of i, if i to next index is of the same direction as
  // currentDir (true: forward / nums[i] > 0; false: backward / nums[i] < 0);
  // Otherwise, return -1 indicating error conditions
  private int next(int i, int[] nums, int length) {
    if (i == -1) return -1;

    boolean currentDir = nums[i] > 0;
    int nexti;
    boolean nextDir;
    if (i + nums[i] > 0) {
      nexti = (i + nums[i]) % length;
    } else if (i + nums[i] < 0) {
      nexti = length + ((i + nums[i]) % length);
    } else {
      nexti = 0;
    }
    nextDir = nums[nexti] > 0;

    if (nextDir == currentDir) return nexti;
    else return -1;
  }

  private boolean sameDir(int i, int j, int[] nums) {
    if (i == -1 || j == -1) return false;
    return nums[i] > 0 && nums[j] > 0 || nums[i] < 0 && nums[j] < 0;
  }

  private final Set<Integer> set = new HashSet<>();

  private boolean detectLoop_sf_pointer(int[] nums, int s) {
    int slow = s;
    int fast = s;

    do {
      slow = next(slow, nums, nums.length);
      fast = next(next(fast, nums, nums.length), nums, nums.length);
    } while (slow != -1 && fast != -1 && slow != fast);

    if (slow == -1 || fast == -1) return false;
    return slow != next(slow, nums, nums.length);
  }

  // There must be a loop in the array, given the array is circular and its elements can't be zero
  private boolean detectLoop(int[] nums, int s) {
    set.clear();
    int n = nums.length;
    int i = s;

    do {
      if (set.contains(i)) {
        int start = i;
        int jumps = 0;
        do {
          if (!sameDir(i, next(i, nums, n), nums)) return false;
          i = next(i, nums, n);
          jumps++;
        } while (i != start);
        return jumps != 1;
      }
      set.add(i);
      i = next(i, nums, n);
    } while (true);
  }

  public boolean circularArrayLoop(int[] nums) {
    if (nums.length <= 1) return false;

    for (int i = 0; i < nums.length; i++) {
      if (set.contains(i)) continue;
      if (detectLoop(nums, i)) return true;
    }

    return false;
  }

  public boolean circularArrayLoop_sf_pointer(int[] nums) {
    if (nums.length <= 1) return false;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == -2000) continue;
      if (detectLoop_sf_pointer(nums, i)) return true;
    }

    return false;
  }

  public static void main(String[] args) throws IOException {
    CircularArrayLoop cal = new CircularArrayLoop();

    int[] inputs = new int[] {2, -1, 1, 2, 2};
    System.out.println(cal.circularArrayLoop(inputs));
    assert cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {-1, 2};
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {-2, 1, -1, -2, -2};
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {3, 1, 2};
    System.out.println(cal.circularArrayLoop(inputs));
    assert cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {-1, -1, -3};
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {-1};
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {-2, -3, -9};
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);

    inputs = Utils.readNumbersFromTxtFile("src/com/ihaveaname/java/leetcode/numbers_3.txt");
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);

    inputs = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, -5};
    System.out.println(cal.circularArrayLoop(inputs));
    assert !cal.circularArrayLoop(inputs);
    System.out.println(cal.circularArrayLoop_sf_pointer(inputs));
    assert !cal.circularArrayLoop_sf_pointer(inputs);
  }
}
