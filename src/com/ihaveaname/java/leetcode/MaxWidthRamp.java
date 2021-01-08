package com.ihaveaname.java.leetcode;

public class MaxWidthRamp {
  public int maxWidthRamp(int[] A) {
    boolean found = false;
    int step_low = 1;
    int step_high = A.length;
    int step = A.length - 1;
    int previousStep = 0;
    while (step_low < step_high) {
      for (int i = 0; i + step < A.length && !found; i++) {
        if (A[i] <= A[i + step]) found = true;
      }

      if (!found) {
        step_high = step;
      } else {
        found = false;
        previousStep = step;
        step_low = step + 1;
        step_high = A.length;
      }
      step = step_low + (step_high - step_low) / 2;
    }

    return previousStep;
  }

  public static void main(String[] args) {
    MaxWidthRamp mwr = new MaxWidthRamp();

    int[] input = new int[] {6, 0, 8, 2, 1, 5};
    System.out.println(mwr.maxWidthRamp(input));

    input = new int[] {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
    System.out.println(mwr.maxWidthRamp(input));

    input = new int[] {0, 1};
    System.out.println(mwr.maxWidthRamp(input));

    input = new int[] {2, 4, 1, 3};
    System.out.println(mwr.maxWidthRamp(input));

    input = new int[] {9, 9, 3, 5, 4, 0, 2, 0, 4, 1};
    System.out.println(mwr.maxWidthRamp(input));

    input = new int[] {29,28,28,26,25,24,9,23,21,9,18,17,14,12,3,11,10,8,8,10,22,6,5,20,5,2,1,1,1,0};
    System.out.println(mwr.maxWidthRamp(input));
  }
}
