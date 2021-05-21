package com.ihaveaname.java.leetcode.graph;

public class FindCenterOfStarGraph_1791 {
  class Solution {
    public int findCenter(int[][] edges) {
      int n = edges.length + 1;
      int[] involved = new int[n + 1];
      int center = 0;

      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        involved[u]++;
        involved[v]++;

        if (involved[u] == n - 1) { center = u; break;}
        if (involved[v] == n - 1) { center = v; break;}
      }

      return center;
    }
  }

  public static void main(String[] args) {
    FindCenterOfStarGraph_1791 findCenterOfStarGraph_1791 = new FindCenterOfStarGraph_1791();
    Solution solution = findCenterOfStarGraph_1791.new Solution();

    int[][] edges = new int[][] {{1, 2}, {2, 3}, {4, 2}};
    System.out.println(solution.findCenter(edges));

    edges = new int[][] {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
    System.out.println(solution.findCenter(edges));
  }
}
