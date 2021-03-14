package com.ihaveaname.java.leetcode;

import java.util.ArrayList;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
  class Solution {
    class Adj {
      int number;
      boolean forward;

      Adj(int number, boolean forward) {
        this.number = number;
        this.forward = forward;
      }
    }

    private void dfs(int vertex, ArrayList<Adj>[] graph, boolean[] visited) {
      if (!visited[vertex]) {
        visited[vertex] = true;
        for (Adj a : graph[vertex]) {
          if (!visited[a.number] && a.forward) count++;
          dfs(a.number, graph, visited);
        }
      }
    }

    private int count;

    public int minReorder(int n, int[][] connections) {
      count = 0;
      ArrayList<Adj>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
      for (int[] connection : connections) {
        int from = connection[0];
        int to = connection[1];
        graph[from].add(new Adj(to, true));
        graph[to].add(new Adj(from, false));
      }
      boolean[] visited = new boolean[n];
      dfs(0, graph, visited);

      return count;
    }
  }

  public static void main(String[] args) {
    ReorderRoutesToMakeAllPathsLeadToTheCityZero reorderRoutesToMakeAllPathsLeadToTheCityZero =
        new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
    Solution solution = reorderRoutesToMakeAllPathsLeadToTheCityZero.new Solution();

    int[][] connections = new int[][] {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    System.out.println(solution.minReorder(6, connections));

    connections = new int[][] {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
    System.out.println(solution.minReorder(5, connections));

    connections = new int[][] {{1, 0}, {2, 0}};
    System.out.println(solution.minReorder(3, connections));

    connections = new int[][] {{1, 2}, {2, 0}};
    System.out.println(solution.minReorder(3, connections));
  }
}
