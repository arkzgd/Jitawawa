package com.ihaveaname.java.leetcode;

public class RedundantConnection {
  class Solution {

    public int[] findRedundantConnection(int[][] edges) {
      int N = edges.length;
      int[] graph = new int[N + 1];
      for (int i = 0; i < N + 1; i++) graph[i] = 0;

      for (int[] edge : edges) {
        int u = edge[0];
        int up = u;
        while (up > 0 && graph[up] > 0) up = graph[up];
        int v = edge[1];
        int vp = v;
        while (vp > 0 && graph[vp] > 0) vp = graph[vp];

        if (up == vp) {
          return edge;
        } else {
          graph[vp] = up;
        }
      }

      return null;
    }
  }

  public static void main(String[] args) {
    RedundantConnection redundantConnection = new RedundantConnection();
    Solution solution = redundantConnection.new Solution();

    int[][] input = new int[][] {{1, 2}, {1, 3}, {2, 3}};
    System.out.println(solution.findRedundantConnection(input));

    input = new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
    System.out.println(solution.findRedundantConnection(input));

    input =
        new int[][] {
          {9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}
        };
    System.out.println(solution.findRedundantConnection(input));

    input = new int[][] {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
    System.out.println(solution.findRedundantConnection(input));
  }
}
