package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {
  class Solution {
    private boolean dfs(int node, int[][] graph, int[] visited) {
      if (visited[node] > 0) return visited[node] == 2;

      visited[node] = 1;
      for (int neighbor : graph[node]) {
        if (visited[neighbor] == 1 || !dfs(neighbor, graph, visited)) {
          return false;
        }
      }

      visited[node] = 2;
      return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int[] visited = new int[graph.length];
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
