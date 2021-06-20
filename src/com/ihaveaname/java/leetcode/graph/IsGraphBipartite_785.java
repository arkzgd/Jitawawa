package com.ihaveaname.java.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {
  class Solution {
    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      int[] colors = new int[n];
      int color = -1;
      Queue<Integer> queue = new LinkedList<>();
      colors[0] = color;
      queue.offer(0);
      color = -color;
      while (!queue.isEmpty()) {
        int i = queue.poll();
        for (int j : graph[i]) {
          if (colors[j] == 0) {
            colors[j] = color;
            queue.offer(j);
          }
        }
        color = -color;
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
