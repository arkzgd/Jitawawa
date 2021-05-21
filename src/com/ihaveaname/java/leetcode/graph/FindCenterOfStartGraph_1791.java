package com.ihaveaname.java.leetcode.graph;

public class FindCenterOfStartGraph_1791 {
  class Solution {
    public int findCenter(int[][] edges) {
      int n = edges.length + 1;
      int[] involved = new int[n + 1];

      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        involved[u]++;
        involved[v]++;
      }

      int center = 0;
      for (int i = 0; i < n + 1; i++) {
        if (involved[i] == n - 1) center = i;
      }

      return center;
    }
  }

  public static void main(String[] args) {
    FindCenterOfStartGraph_1791 findCenterOfStartGraph_1791 = new FindCenterOfStartGraph_1791();
    Solution solution = findCenterOfStartGraph_1791.new Solution();

    int[][] edges = new int[][] {{1, 2}, {2, 3}, {4, 2}};
    System.out.println(solution.findCenter(edges));

    edges = new int[][] {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
    System.out.println(solution.findCenter(edges));
  }
}
