package com.ihaveaname.java.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {
  class Solution {
    private boolean dfs(int i, int[][] graph, boolean[] visited, int[] colors, int targetColor) {
      if (!visited[i]) {
        visited[i] = true;
        if (colors[i] == targetColor) return true;
        else {
          for (int n : graph[i]) {
            if (dfs(n, graph, visited, colors, targetColor)) return true;
          }
        }
      }

      return false;
    }

    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      int[] colors = new int[n];
      int color = 1;
      Queue<Integer> queue = new LinkedList<>();
      colors[0] = color;
      queue.offer(0);
      color++;
      while (!queue.isEmpty()) {
        int i = queue.poll();
        for (int j : graph[i]) {
          if (colors[j] == 0) {
            colors[j] = color;
            queue.offer(j);
          }
          else {

          }
        }
        color++;
      }

      return false;
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
