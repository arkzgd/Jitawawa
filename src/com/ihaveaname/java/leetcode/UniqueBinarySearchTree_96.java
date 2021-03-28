package com.ihaveaname.java.leetcode;

public class UniqueBinarySearchTree_96 {
  class Solution {
    private int[] dp = new int[20];

    private int calc(int n) {
      if (dp[n] == 0) {
        for (int i = 0; i < n; i++) dp[n] += (calc(i) * calc(n - 1 - i));
      }

      return dp[n];
    }

    public int numTrees(int n) {
      dp[0] = 1;
      dp[1] = 1;

      return calc(n);
    }
  }

  public static void main(String[] args) {
    UniqueBinarySearchTree_96 uniqueBinarySearchTree_96 = new UniqueBinarySearchTree_96();
    Solution solution = uniqueBinarySearchTree_96.new Solution();

    System.out.println(solution.numTrees(3));
    System.out.println(solution.numTrees(4));
    System.out.println(solution.numTrees(5));
    System.out.println(solution.numTrees(6));
    System.out.println(solution.numTrees(7));
    System.out.println(solution.numTrees(19));
  }
}
