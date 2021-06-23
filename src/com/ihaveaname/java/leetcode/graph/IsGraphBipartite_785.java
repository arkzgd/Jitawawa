package com.ihaveaname.java.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {
  class Solution {
    private boolean dfs(
        int i, int[][] graph, boolean[] visited, int[] colors, final int targetColor) {
      if (!visited[i]) {
        visited[i] = true;
        if (colors[i] == targetColor) {
          return true;
        }
        for (int neighbor : graph[i]) {
          if (dfs(neighbor, graph, visited, colors, targetColor)) return true;
        }
        return false;
      }

      return colors[i] == targetColor;
    }

    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      int[] colors = new int[n];
      int color = 1;
      Queue<Integer> queue = new LinkedList<>();
      colors[0] = color;
      queue.offer(0);
      color = -color;
      while (!queue.isEmpty()) {
        int len = queue.size();
        for (int c = 0; c < len; c++) {
          int i = queue.poll();
          for (int neighbor : graph[i]) {
            if (colors[neighbor] == 0) {
              colors[neighbor] = color;
              queue.offer(neighbor);
            }
          }
        }
        color = -color;
      }

      for (int v = 0; v < n; v++) {
        for (int neighbor : graph[v]) {
          if (dfs(neighbor, graph, new boolean[n], colors, colors[v])) return false;
        }
      }

      return true;
    }
  }

  public static void main(String[] args) {
    IsGraphBipartite_785 isGraphBipartite_785 = new IsGraphBipartite_785();
    Solution solution = isGraphBipartite_785.new Solution();

    int[][] graph = new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    System.out.println(solution.isBipartite(graph));

    graph = new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    System.out.println(solution.isBipartite(graph));
  }
}
