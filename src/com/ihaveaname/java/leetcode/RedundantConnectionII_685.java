package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnectionII_685 {
  class Solution {
    // Return the edge occurs last in edges, which makes the graph cyclic
    public int[] findRedundantDirectedConnection(int[][] edges) {
      int N = edges.length;
      int[] graph = new int[N + 1];
      for (int i = 0; i < N + 1; i++) graph[i] = -1;

      for (int[] edge : edges) {
        int u = edge[0];
        int up = u;
        while (up != -1 && graph[up] != -1) {
          up = graph[up];
        }
        int v = edge[1];
        int vp = v;
        while (vp != -1 && graph[vp] != -1) {
          vp = graph[vp];
        }
        if (up == vp) return edge;
        graph[v] = u;
      }

      return null;
    }
  }

  public static void main(String[] args) {
    RedundantConnectionII_685 redundantConnectionII_685 = new RedundantConnectionII_685();
    Solution solution = redundantConnectionII_685.new Solution();

    int[][] edges = new int[][] {{1, 2}, {1, 3}, {2, 3}};
    int[] r = solution.findRedundantDirectedConnection(edges);
    System.out.println(Arrays.toString(r));

    edges = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
    r = solution.findRedundantDirectedConnection(edges);
    System.out.println(Arrays.toString(r));

    edges = new int[][] {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
    r = solution.findRedundantDirectedConnection(edges);
    System.out.println(Arrays.toString(r));
  }
}
