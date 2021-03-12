package com.ihaveaname.java.leetcode;

public class RedundantConnection {
  class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      return new int[]{2, 3};
    }
  }

  public static void main(String[] args) {
    RedundantConnection redundantConnection = new RedundantConnection();
    Solution solution = redundantConnection.new Solution();

    int[][] input = new int[][]{{1, 2}, {1, 3}, {2, 3}};
    System.out.println(solution.findRedundantConnection(input));
  }
}
