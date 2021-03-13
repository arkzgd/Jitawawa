package com.ihaveaname.java.leetcode;

import java.util.*;

public class RedundantConnection {
  class Solution {
    Set<Integer> seen = new HashSet();
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
      ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
      for (int i = 0; i <= MAX_EDGE_VAL; i++) {
        graph[i] = new ArrayList();
      }

      for (int[] edge : edges) {
        seen.clear();
        if (!graph[edge[0]].isEmpty()
            && !graph[edge[1]].isEmpty()
            && dfs(graph, edge[0], edge[1])) {
          return edge;
        }
        graph[edge[0]].add(edge[1]);
        graph[edge[1]].add(edge[0]);
      }
      throw new AssertionError();
    }

    public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
      if (!seen.contains(source)) {
        seen.add(source);
        if (source == target) return true;
        for (int nei : graph[source]) {
          if (dfs(graph, nei, target)) return true;
        }
      }
      return false;
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
  }
}
