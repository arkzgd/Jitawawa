package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334 {
  class Solution {
    private int ans;
    private int shortest;

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
        int s,
        ArrayList<ArrayList<Integer[]>> graph,
        int soFar,
        Set<Integer> saved,
        final int distanceThreshold) {
      if (soFar <= distanceThreshold) {
        Set<Integer> save = new HashSet<>();
        save.add(s);
        for (Integer[] neighbor : graph.get(s)) {
          dfs(neighbor[0], graph, soFar + neighbor[1], save, distanceThreshold);
        }
        saved.addAll(save);

        return save.size() - 1;
      }

      return 0;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      ArrayList<ArrayList<Integer[]>> graph = toGraph(n, edges);
      ans = -1;
      shortest = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int r = dfs(i, graph, 0, new HashSet<>(), distanceThreshold);
        System.out.println("i: " + i + " r: " + r);
        if (r <= shortest) {
          ans = i;
          shortest = r;
        }
      }

      return ans;
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

    n = 5;
    edges = new int[][] {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
    distanceThreshold = 2;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));

    n = 6;
    edges = new int[][] {{0, 1, 10}, {0, 2, 1}, {2, 3, 1}, {1, 3, 1}, {1, 4, 1}, {4, 5, 10}};
    distanceThreshold = 20;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));

    n = 6;
    edges = new int[][] {{0,3,7},{2,4,1},{0,1,5},{2,3,10},{1,3,6},{1,2,1}};
    distanceThreshold = 417;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));
  }
}
