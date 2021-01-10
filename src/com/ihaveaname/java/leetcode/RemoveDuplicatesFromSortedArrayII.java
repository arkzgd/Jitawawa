package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int slow = 0;
    int count = 1;
    for (int fast = 1; fast < nums.length; fast++) {
      if (nums[fast] == nums[slow] && count < 2 ) {
        nums[++slow] = nums[fast];
        count++;
      }
      else if (nums[fast] != nums[slow]) {
        nums[++slow] = nums[fast];
        count = 1;
      }
    }

    return slow + 1;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArrayII rdfsaii = new RemoveDuplicatesFromSortedArrayII();

    int[] inputs = new int[]{1,1,1,2,2,3};
    int length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 5;

    inputs = new int[]{0,0,1,1,1,1,2,3,3};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 7;

    inputs = new int[]{1, 2};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 2;

    inputs = new int[]{1,1,1,2,2,2,3,3};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 6;

    inputs = new int[]{1, 2, 2, 2};
    length = rdfsaii.removeDuplicates(inputs);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
    assert length == 3;
  }
}
