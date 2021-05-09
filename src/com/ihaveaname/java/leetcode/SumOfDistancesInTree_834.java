package com.ihaveaname.java.leetcode;

import java.util.*;

public class SumOfDistancesInTree_834 {
  class Solution {
    private int helper(int i, List<Integer>[] graph, boolean[] visited, int soFar) {
      int result = 0;
      visited[i] = true;
      for (int adj : graph[i]) {
        if (!visited[adj]) {
            result += helper(adj, graph, visited, soFar + 1);
        }
      }

      return result + soFar;
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
      int[] result = new int[N];
      List<Integer>[] graph = new List[N];
      for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
      for (int[] edge : edges) {
        graph[edge[0]].add(edge[1]);
        graph[edge[1]].add(edge[0]);
      }

      for (int i = 0; i < N; i++) {
        result[i] = helper(i, graph, new boolean[N], 0);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    SumOfDistancesInTree_834 sumOfDistancesInTree_834 = new SumOfDistancesInTree_834();
    Solution solution = sumOfDistancesInTree_834.new Solution();

    int N = 6;
    int[][] edges = new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
    System.out.println(Arrays.toString(solution.sumOfDistancesInTree(N, edges)));
  }
}
