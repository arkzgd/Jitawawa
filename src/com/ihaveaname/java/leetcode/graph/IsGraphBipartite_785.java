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
      for (int i = 0; i < n; i++) {
        if (colors[i] == 0) {
          colors[i] = color;
          color = -color;

        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    IsGraphBipartite_785 isGraphBipartite_785 = new IsGraphBipartite_785();
    Solution solution = isGraphBipartite_785.new Solution();

    int[][] graph = new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    System.out.println(solution.isBipartite(graph));
  }
}
