package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;

public class NumberOfProvinces_547 {
  class Solution {
    private ArrayList<ArrayList<Integer>> toGraph(int[][] isConnnected, int n) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        result.add(new ArrayList<>());
      }
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (isConnnected[i][j] == 1) {
            result.get(i).add(j);
            result.get(j).add(i);
          }
        }
      }

      return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int i, final int color, int[] colors) {
      if (colors[i] == 0) {
        colors[i] = color;
        for (int n : graph.get(i)) {
          dfs(graph, n, color, colors);
        }
      }
    }

    public int findCircleNum(int[][] isConnected) {
      int n = isConnected.length;
      ArrayList<ArrayList<Integer>> graph = toGraph(isConnected, n);
      int[] colors = new int[n];
      int color = 0;
      for (int i = 0; i < n; i++) {
        if (colors[i] == 0) dfs(graph, i, ++color, colors);
      }

      return color;
    }
  }

  public static void main(String[] args) {
    NumberOfProvinces_547 numberOfProvinces_547 = new NumberOfProvinces_547();
    Solution solution = numberOfProvinces_547.new Solution();

    int[][] isConnected = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    System.out.println(solution.findCircleNum(isConnected));

    isConnected = new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    System.out.println(solution.findCircleNum(isConnected));
  }
}
