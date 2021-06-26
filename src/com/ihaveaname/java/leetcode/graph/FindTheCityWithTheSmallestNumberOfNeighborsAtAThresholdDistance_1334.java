package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334 {
  class Solution {
    private ArrayList<ArrayList<Integer[]>> toGraph(int n, int[][] edges) {
      ArrayList<ArrayList<Integer[]>> result = new ArrayList<>();
      for (int i = 0; i < n; i++) result.add(new ArrayList<>());

      for (int[] e : edges) {
        result.get(e[0]).add(new Integer[] {e[1], e[2]});
        result.get(e[1]).add(new Integer[] {e[0], e[2]});
      }

      return result;
    }

    private int dfs(
        int s, ArrayList<ArrayList<Integer[]>> graph, int threshold, boolean[] visited) {
      if (!visited[s]) {
        visited[s] = true;
        int count = 0;
        for (Integer[] neighbor : graph.get(s)) {
          if (neighbor[1] <= threshold) {
            count++;
            dfs(neighbor[0], graph, threshold - neighbor[1], visited);
          }
        }

        return count + 1;
      }

      return 0;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      ArrayList<ArrayList<Integer[]>> graph = toGraph(n, edges);
      for (int i = 0; i < n; i++) {
        System.out.println(
            " Of: " + i + " Get: " + dfs(i, graph, distanceThreshold, new boolean[n]));
      }

      return 0;
    }
  }

  public static void main(String[] args) {
    FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334
        findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334 =
            new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334();
    Solution solution =
        findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334.new Solution();

    int n = 4;
    int[][] edges = new int[][] {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
    int distanceThreshold = 4;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));
  }
}
