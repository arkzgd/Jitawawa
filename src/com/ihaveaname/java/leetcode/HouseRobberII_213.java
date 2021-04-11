package com.ihaveaname.java.leetcode;

public class HouseRobberII_213 {
  class Solution {
    private int[] calcDp(int[] nums) {
      int[] dp = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        if (i == 0) dp[0] = nums[0];
        else if (i == 1) dp[1] = Math.max(nums[0], nums[1]);
        else dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
      }

      return dp;
    }

    public int rob(int[] nums) {
      int[] dp = calcDp(nums);
      int[] newDp = new int[nums.length];
      for (int i = 0; i < newDp.length; i++) {
        int prev = (i - 1 + dp.length) % dp.length;
        int prevOfPrev = (i - 2 + dp.length) % dp.length;
        newDp[i] =
            Math.max(
                (newDp[prevOfPrev] != 0 ? newDp[prevOfPrev] : dp[prevOfPrev]),
                newDp[prev] != 0 ? newDp[prev] : dp[prev]);
      }
      return newDp[newDp.length - 1];
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
  }
}
