package com.ihaveaname.java.leetcode;

public class MinimumCostTreeFromLeafValues {
  class Solution {
    private int sum;
    private boolean[] valid;

    private int hasValid() {
      int count = 0;
      for (boolean e : valid) if (e) count++;
      return count;
    }

    private void helper(int[] arr) {
      if (hasValid() > 1) {
        int i, j;
        int min = Integer.MAX_VALUE, min_i = -1, min_j = -1;

        i = 0;
        while (i < valid.length) {
          while (i < valid.length && !valid[i]) i++;
          j = i + 1;
          while (j < valid.length && !valid[j]) j++;

          if (i < valid.length && j < valid.length) {
            if (arr[i] * arr[j] < min) {
              min_i = i;
              min_j = j;
              min = arr[i] * arr[j];
            }
          }
          i++;
        }

        if (min != Integer.MAX_VALUE) {
          sum += min;
          if (arr[min_i] >= arr[min_j]) valid[min_j] = false;
          else valid[min_i] = false;
        }
        helper(arr);
      }
    }

    public int mctFromLeafValues(int[] arr) {
      sum = 0;
      valid = new boolean[arr.length];
      for (int i = 0; i < arr.length; i++) valid[i] = true;

      helper(arr);
      return sum;
    }
  }

  public static void main(String[] args) {
    MinimumCostTreeFromLeafValues minimumCostTreeFromLeafValues =
        new MinimumCostTreeFromLeafValues();
    Solution solution = minimumCostTreeFromLeafValues.new Solution();

    int[] arr = new int[] {6, 2, 4};
    System.out.println(solution.mctFromLeafValues(arr));

    arr = new int[] {6, 2, 4, 8};
    System.out.println(solution.mctFromLeafValues(arr));
  }
}
