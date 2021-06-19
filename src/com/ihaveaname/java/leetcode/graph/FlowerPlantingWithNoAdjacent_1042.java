package com.ihaveaname.java.leetcode.graph;

import java.util.*;

public class FlowerPlantingWithNoAdjacent_1042 {
  class Solution {
    private List<Integer>[] toGraph(int n, int[][] paths) {
      List<Integer>[] graph = new List[n + 1];
      for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
      for (int[] path : paths) {
        graph[path[0]].add(path[1]);
        graph[path[1]].add(path[0]);
      }

      return graph;
    }

    private int getFlower(List<Integer>[] graph, int i, int flower, int[] visited) {
      boolean[] flowers = new boolean[5];
      flowers[flower] = true;
      for (int n : graph[i]) {
        if (visited[n - 1] > 0) flowers[visited[n - 1]] = true;
      }

      int j;
      for (j = 1; j <= 4; j++) if (!flowers[j]) break;

      return j;
    }

    private void dfs(List<Integer>[] graph, int i, int flower, int[] soFar, int[] visited) {
      if (visited[i - 1] > 0) return;
      visited[i - 1] = flower;
      soFar[i - 1] = flower;
      for (int n : graph[i]) {
        dfs(graph, n, getFlower(graph, n, flower, visited), soFar, visited);
      }
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
      List<Integer>[] graph = toGraph(n, paths);
      int[] result = new int[n];
      int[] visited = new int[n];
      for (int i = 1; i <= n; i++) dfs(graph, i, 1, result, visited);
      return result;
    }
  }

  public static void main(String[] args) {
    FlowerPlantingWithNoAdjacent_1042 flowerPlantingWithNoAdjacent_1042 =
        new FlowerPlantingWithNoAdjacent_1042();
    Solution solution = flowerPlantingWithNoAdjacent_1042.new Solution();

    int n = 3;
    int[][] paths = new int[][] {{1, 2}, {2, 3}, {3, 1}};
    System.out.println(Arrays.toString(solution.gardenNoAdj(n, paths)));

    n = 4;
    paths = new int[][] {{1, 2}, {3, 4}};
    System.out.println(Arrays.toString(solution.gardenNoAdj(n, paths)));

    n = 4;
    paths = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
    System.out.println(Arrays.toString(solution.gardenNoAdj(n, paths)));

    n = 1;
    paths = new int[][] {};
    System.out.println(Arrays.toString(solution.gardenNoAdj(n, paths)));
  }
}
