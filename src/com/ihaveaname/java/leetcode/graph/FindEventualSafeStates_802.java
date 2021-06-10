package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {
  class Solution {
    private boolean dfs(int node, int[][] graph, boolean[] visited) {
      if (visited[node]) return false;
      visited[node] = true;
      for (int neighbor : graph[node]) {
        if (!dfs(neighbor, graph, visited)) {
          return false;
        }
      }

      // The slowness comes from here
      // after each step, the flag for current node and all its neighbors has to be reset
      for (int neighbor : graph[node]) visited[neighbor] = false;
      visited[node] = false;

      return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        boolean[] visited = new boolean[graph.length];
        if (dfs(i, graph, visited)) result.add(i);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    FindEventualSafeStates_802 findEventualSafeStates_802 = new FindEventualSafeStates_802();
    Solution solution = findEventualSafeStates_802.new Solution();

    int[][] graph = new int[][] {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    System.out.println(solution.eventualSafeNodes(graph));

    graph = new int[][] {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
    System.out.println(solution.eventualSafeNodes(graph));

    graph = new int[][] {{}, {0, 2, 3, 4}, {3}, {4}, {}};
    System.out.println(solution.eventualSafeNodes(graph));

    graph = new int[][] {{1, 3, 4, 5}, {}, {}, {}, {}, {2, 4}};
    System.out.println(solution.eventualSafeNodes(graph));
  }
}
