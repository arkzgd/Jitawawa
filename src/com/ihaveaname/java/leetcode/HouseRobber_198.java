package com.ihaveaname.java.leetcode;

public class HouseRobber_198 {
  class Solution {
    public int rob(int[] nums) {
      int[] dp = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
        if (i == 0) dp[0] = nums[0];
        else if (i == 1) dp[1] = Math.max(nums[0], nums[1]);
        else dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
      }

      return dp[nums.length - 1];
    }
  }

  public static void main(String[] args) {
    HouseRobber_198 houseRobber_198 = new HouseRobber_198();
    Solution solution = houseRobber_198.new Solution();

    int[] nums = new int[] {1, 2, 3, 1};
    System.out.println(solution.rob(nums));

    nums = new int[] {2, 7, 9, 3, 1};
    System.out.println(solution.rob(nums));
  }
}
