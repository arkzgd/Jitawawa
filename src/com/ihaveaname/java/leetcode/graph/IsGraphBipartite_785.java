package com.ihaveaname.java.leetcode.graph;

import java.util.*;

public class IsGraphBipartite_785 {
  // Refer to https://courses.cs.washington.edu/courses/cse417/17wi/slides/Graphs2.pdf
  // for a better understanding of Bipartite
  class Solution {
    private List<Set<Integer>> toLayers(int[][] graph, int s, boolean[] visited) {
      int n = graph.length;
      List<Set<Integer>> layers = new ArrayList<>();
      int layer = 0;
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(s);
      visited[s] = true;
      while (!queue.isEmpty()) {
        int len = queue.size();
        Set<Integer> set = new HashSet<>();
        layers.add(set);
        for (int i = 0; i < len; i++) {
          int v = queue.poll();
          layers.get(layer).add(v);
          for (int neighbor : graph[v]) {
            if (!visited[neighbor]) {
              visited[neighbor] = true;
              queue.offer(neighbor);
            }
          }
        }
        layer++;
      }

      return layers;
    }

    private boolean validate(List<Set<Integer>> layers, int[][] graph) {
      for (int i = 0; i < graph.length; i++) {
        for (Set<Integer> l : layers) {
          if (l.contains(i)) {
            for (int n : graph[i]) {
              if (l.contains(n)) return false;
            }
          }
        }
      }

      return true;
    }

    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      boolean[] visited = new boolean[n];

      for (int i = 0; i < n; i++) {
        if (!visited[i] && !validate(toLayers(graph, i, visited), graph)) {
          return false;
        }
      }

      return true;
    }
  }

  public static void main(String[] args) {
    IsGraphBipartite_785 isGraphBipartite_785 = new IsGraphBipartite_785();
    Solution solution = isGraphBipartite_785.new Solution();

    int[][] graph = new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    System.out.println(solution.isBipartite(graph));

    graph = new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    System.out.println(solution.isBipartite(graph));

    graph =
        new int[][] {
          {},
          {2, 4, 6},
          {1, 4, 8, 9},
          {7, 8},
          {1, 2, 8, 9},
          {6, 9},
          {1, 5, 7, 8, 9},
          {3, 6, 9},
          {2, 3, 4, 6, 9},
          {2, 4, 5, 6, 7, 8}
        };
    System.out.println(solution.isBipartite(graph));
  }
}
