package com.ihaveaname.java.leetcode.graph;

public class NumberOfOperationsToMakeNetworkConnected_1319 {
  class Solution {
    public int makeConnected(int n, int[][] connections) {
      return 0;
    }
  }

  public static void main(String[] args) {
    NumberOfOperationsToMakeNetworkConnected_1319 numberOfOperationsToMakeNetworkConnected_1319 =
        new NumberOfOperationsToMakeNetworkConnected_1319();
    Solution solution = numberOfOperationsToMakeNetworkConnected_1319.new Solution();

    int n = 6;
    int[][] connected = new int[][] {{0, 1}, {0, 2}, {1, 2}};
    System.out.println(solution.makeConnected(n, connected));
  }
}
