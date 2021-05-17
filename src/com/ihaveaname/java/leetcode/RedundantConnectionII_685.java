package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnectionII_685 {
  class Solution {
    // Return the edge occurs last in edges, which makes the graph cyclic
    public int[] findRedundantDirectedConnection(int[][] edges) {
      List<Integer[]> result = new ArrayList<>();

      int N = edges.length;
      int[] graph = new int[N + 1];
      for (int i = 0; i < N + 1; i++) graph[i] = -1;

      for (int[] edge : edges) {
        int u = edge[0];
        int up = graph[u];
        while (up != -1) {
          up = graph[up];
        }
        int v = edge[1];
        int vp = graph[v];
        while (vp != -1) {
          vp = graph[vp];
        }
        if (up == vp) result.add(new Integer[] {u, v});
      }

      return new int[] {result.get(result.size() - 1)[0], result.get(result.size() - 1)[1]};
    }
  }

  public static void main(String[] args) {
    RedundantConnectionII_685 redundantConnectionII_685 = new RedundantConnectionII_685();
    Solution solution = redundantConnectionII_685.new Solution();

    int[][] edges = new int[][] {{1, 2}, {1, 3}, {2, 3}};
    int[] r = solution.findRedundantDirectedConnection(edges);
    System.out.println(r[0] + " " + r[1]);
  }
}
