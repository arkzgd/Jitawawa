package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeToCollectAllApplesInATree_1443 {
  class Solution {
    private int count;

    private ArrayList<List<Integer>> buildGraph(int n, int[][] edges) {
      ArrayList<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < n; i++) result.add(new ArrayList<>());
      for (int[] e : edges) {
        result.get(e[0]).add(e[1]);
      }

      return result;
    }

    private boolean bfs(int s, ArrayList<List<Integer>> graph, List<Boolean> hasApple) {
      List<Integer> l = graph.get(s);
      boolean shouldCome = false;

      for (int e : l) {
        if (bfs(e, graph, hasApple)) {
          shouldCome = true;
          count += 2;
        }
      }

      if (hasApple.get(s)) shouldCome = true;

      return shouldCome;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
      ArrayList<List<Integer>> graph = buildGraph(n, edges);
      count = 0;
      bfs(0, graph, hasApple);

      return count;
    }
  }

  public static void main(String[] args) {
    MinTimeToCollectAllApplesInATree_1443 minTimeToCollectAllApplesInATree_1443 =
        new MinTimeToCollectAllApplesInATree_1443();
    Solution solution = minTimeToCollectAllApplesInATree_1443.new Solution();

    int[][] edges = new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
    System.out.println(solution.minTime(7, edges, hasApple));

    edges = new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    hasApple = Arrays.asList(false, false, true, false, false, true, false);
    System.out.println(solution.minTime(7, edges, hasApple));

    edges = new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    hasApple = Arrays.asList(false, false, false, false, false, false, false);
    System.out.println(solution.minTime(7, edges, hasApple));

    edges = new int[][] {{0, 1}, {1, 2}, {0, 3}};
    hasApple = Arrays.asList(true, true, true, true);
    System.out.println(solution.minTime(4, edges, hasApple));
  }
}
