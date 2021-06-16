package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerPlantingWithNoAdjacent_1042 {
  class Solution {
    private List<Integer>[] toGraph(int n, int[][] paths) {
      List<Integer>[] graph = new List[n + 1];
      for (int[] path : paths) {
        if (graph[path[0]] == null) graph[path[0]] = new ArrayList<>();
        graph[path[0]].add(path[1]);
        if (graph[path[1]] == null) graph[path[1]] = new ArrayList<>();
        graph[path[1]].add(path[0]);
      }

      return graph;
    }

    private int getFlower(List<Integer>[] graph, int i, int flower) {
      return 2;
    }

    private void bfs(List<Integer>[] graph, int i, int flower, int[] soFar, int[] visited) {
      if (visited[i-1] > 0) return;
      visited[i-1] = flower;
      soFar[i-1] = flower;
      for (int n : graph[i]) {
        bfs(graph, n, getFlower(graph, n, flower), soFar, visited);
      }
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
      List<Integer>[] graph = toGraph(n, paths);
      int[] result = new int[n];
      int[] visited = new int[n];
      for (int i = 1; i <= n; i++) bfs(graph, i, 1, result, visited);
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
  }
}
