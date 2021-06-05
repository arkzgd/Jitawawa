package com.ihaveaname.java.leetcode.graph;

import java.util.*;

public class MaximalNetworkRank_1615 {
  class Solution {
    private List<Set<Integer>> toGraph(int n, int[][] roads) {
      List<Set<Integer>> result = new ArrayList<>(n);
      for (int i = 0; i < n; i++) result.add(new HashSet<>());
      for (int[] pair : roads) {
        int u = pair[0];
        int v = pair[1];
        result.get(u).add(v);
        result.get(v).add(u);
      }

      return result;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
      int count = 0;
      List<Set<Integer>> graph = toGraph(n, roads);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j) {
            int sum = graph.get(i).size() + graph.get(j).size();
            if (graph.get(i).contains(j) || graph.get(j).contains(i)) sum--;
            count = Math.max(count, sum);
          }
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
