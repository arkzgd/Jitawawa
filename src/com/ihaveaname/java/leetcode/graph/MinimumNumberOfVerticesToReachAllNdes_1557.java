package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNdes_1557 {
  class Solution {
    private List<List<Integer>> buildGraph(int n, int[][] edges) {
      List<List<Integer>> result = new ArrayList<>();
      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        List<Integer> l = new ArrayList<>();
        l.add(u);
        l.add(v);
        result.add(l);
      }

      return result;
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
      List<Integer> result = new ArrayList<>();

      int[] vertices = new int[n];
      Arrays.fill(vertices, -1);

      for (List<Integer> edge : edges) {
        int u = edge.get(0);
        int v = edge.get(1);
        int up = u;
        while (vertices[up] != -1) up = vertices[up];
        if (vertices[v] == -1) vertices[v] = up;
      }

      for (int i = 0; i < n; i++) {
        if (vertices[i] == -1) result.add(i);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    MinimumNumberOfVerticesToReachAllNdes_1557 minimumNumberOfVerticesToReachAllNdes_1557 =
        new MinimumNumberOfVerticesToReachAllNdes_1557();
    Solution solution = minimumNumberOfVerticesToReachAllNdes_1557.new Solution();

    int n = 6;
    int[][] edges = new int[][] {{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}};
    System.out.println(solution.findSmallestSetOfVertices(n, solution.buildGraph(n, edges)));

    n = 5;
    edges = new int[][] {{0, 1}, {2, 1}, {3, 1}, {1, 4}, {2, 4}};
    System.out.println(solution.findSmallestSetOfVertices(n, solution.buildGraph(n, edges)));
  }
}
