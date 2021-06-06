package com.ihaveaname.java.leetcode.graph;

public class MaximalNetworkRank_1615 {
  class Solution {
    static class Statistic {
      Statistic(int[] degrees, int[][] connected) {
        this.degrees = degrees;
        this.connected = connected;
      }

      int[] degrees;
      int[][] connected;
    }

    private Statistic toNodeDegrees(int n, int[][] roads) {
      int[] degrees = new int[n];
      int[][] connected = new int[n][n];
      for (int[] road : roads) {
        degrees[road[0]]++;
        degrees[road[1]]++;
        connected[road[0]][road[1]] = 1;
        connected[road[1]][road[0]] = 1;
      }

      return new Statistic(degrees, connected);
    }

    public int maximalNetworkRank(int n, int[][] roads) {
      int count = 0;
      Statistic statistic = toNodeDegrees(n, roads);
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          int sum = statistic.degrees[i] + statistic.degrees[j] - statistic.connected[i][j];
          count = Math.max(count, sum);
        }
      }
      return count;
    }
  }

  public static void main(String[] args) {
    MaximalNetworkRank_1615 maximalNetworkRank_1615 = new MaximalNetworkRank_1615();
    Solution solution = maximalNetworkRank_1615.new Solution();

    int n = 4;
    int[][] roads = new int[][] {{0, 1}, {0, 3}, {1, 2}, {1, 3}};
    System.out.println(solution.maximalNetworkRank(n, roads));

    n = 5;
    roads = new int[][] {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
    System.out.println(solution.maximalNetworkRank(n, roads));

    n = 8;
    roads = new int[][] {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
    System.out.println(solution.maximalNetworkRank(n, roads));
  }
}
