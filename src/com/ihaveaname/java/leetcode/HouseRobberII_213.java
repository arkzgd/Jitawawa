package com.ihaveaname.java.leetcode;

public class HouseRobberII_213 {
  class Solution {
    private int dp(int[] nums, int s, int e) {
      int[] sum = new int[e - s + 1];
      for (int i = s; i <= e; i++) {
        if (i - s == 0) sum[i - s] = nums[s];
        else if (i - s == 1) sum[i - s] = Math.max(nums[s], nums[s + 1]);
        else sum[i - s] = Math.max(nums[i] + sum[i - s - 2], sum[i - s - 1]);
      }

      return sum[e - s];
    }

    public int rob(int[] nums) {
      int length = nums.length;

      if (length == 1) return nums[0];
      if (length == 2) return Math.max(nums[0], nums[1]);

      return Math.max(dp(nums, 0, length - 2), dp(nums, 1, length - 1));
    }
  }

  public static void main(String[] args) {
    HouseRobberII_213 houseRobberII_213 = new HouseRobberII_213();
    Solution solution = houseRobberII_213.new Solution();

    int[] nums = new int[] {2, 3, 2};
    System.out.println(solution.rob(nums));

    nums = new int[] {1, 2, 3, 1};
    System.out.println(solution.rob(nums));

    nums = new int[] {0};
    System.out.println(solution.rob(nums));

    nums = new int[] {1, 2, 1, 1};
    System.out.println(solution.rob(nums));

    nums = new int[] {200, 3, 140, 20, 10};
    System.out.println(solution.rob(nums));

    nums = new int[] {2, 7, 9, 3, 1};
    System.out.println(solution.rob(nums));
  }
}
