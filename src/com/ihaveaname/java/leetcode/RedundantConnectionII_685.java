package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class RedundantConnectionII_685 {
  class Solution {
    // Return the edge occurs last in edges,
    // which change the graph from a rooted tree to a cyclic graph

    private boolean isRootedTree(int[][] edges, int excludedEdgeIndex) {
      int N = edges.length;
      int[] graph = new int[N + 1];
      boolean[] accessed = new boolean[N + 1];

      for (int i = 0; i < edges.length; i++) {
        if (i == excludedEdgeIndex) continue;
        int[] edge = edges[i];
        int u = edge[0];
        int up = u;
        while (graph[up] != 0) {
          up = graph[up];
        }

        int v = edge[1];
        accessed[v] = true;
        int vp = v;
        while (graph[vp] != 0) {
          vp = graph[vp];
        }

        if (up == vp) {
          return false;
        } else {
          while (graph[v] != 0) v = graph[v];
          graph[v] = u;
        }
      }

      int accessedCounts = 0;
      for (int i = 1; i < N + 1; i++) if (!accessed[i]) accessedCounts++;
      return accessedCounts == 1;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
      for (int i = edges.length - 1; i >= 0; i--) {
        if (isRootedTree(edges, i)) return edges[i];
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
