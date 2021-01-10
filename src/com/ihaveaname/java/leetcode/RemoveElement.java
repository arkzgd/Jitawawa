package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int right = nums.length - 1;
    for (int left = 0; left <= right; left++) {
      if (nums[left] == val) {
        while (right >= left && nums[right] == val) right--;
        if (right > left) {
          nums[left] = nums[right];
          right--;
        }
      }
    }

    return right + 1;
  }

  public static void main(String[] args) {
    RemoveElement re = new RemoveElement();

    int[] inputs = new int[]{3, 2, 2, 3};
    int length = re.removeElement(inputs, 3);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{0,1,2,2,3,0,4,2};
    length = re.removeElement(inputs, 2);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1};
    length = re.removeElement(inputs, 1);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1, 1, 1, 1};
    length = re.removeElement(inputs, 1);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1, 2, 1, 2, 1, 2, 1};
    length = re.removeElement(inputs, 1);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1, 1, 1, 1};
    length = re.removeElement(inputs, 2);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{1, 2, 1, 2, 1, 2, 1};
    length = re.removeElement(inputs, 2);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));

    inputs = new int[]{};
    length = re.removeElement(inputs, 2);
    System.out.println(length);
    System.out.println(Arrays.toString(Arrays.copyOf(inputs, length)));
  }
}
