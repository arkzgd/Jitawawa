package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {
  class Solution {
    private boolean dfs(int[] neighbors, int[][] graph, boolean[] visited) {
      for (int neighbor : neighbors) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          if (graph[neighbor].length == 0) return true;
          else if (dfs(graph[neighbor], graph, visited)) return true;
        }
      }

      return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        boolean[] visited = new boolean[graph.length];
        if (dfs(graph[i], graph, visited)) result.add(i);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    FindEventualSafeStates_802 findEventualSafeStates_802 = new FindEventualSafeStates_802();
    Solution solution = findEventualSafeStates_802.new Solution();

    int[][] graph = new int[][] {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    System.out.println(solution.eventualSafeNodes(graph));
  }
}
