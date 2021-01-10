package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int slow = 0, fast = 0;
    int length = nums.length;
    while (slow < length && fast < length) {
      while (fast < length && nums[slow] == nums[fast])
        fast++;

      if (fast - slow > 2) {
        int i = slow + 2;
        int j = fast;
        while (i < j && j < length) {
          nums[i++] = nums[j++];
        }
        length = fast - slow - 2 > 0 ? length - (fast - slow - 2) : length;
        slow = slow + 2;
        fast = slow;
      }
      else {
        slow = fast;
        fast = slow;
      }
    }

    return length;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArrayII rdfsaii = new RemoveDuplicatesFromSortedArrayII();

    int[] inputs = new int[]{1,1,1,2,2,3};
    int length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{0,0,1,1,1,1,2,3,3};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1, 2};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1,1,1,2,2,2,3,3};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1, 2, 2, 2};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
  }
}
