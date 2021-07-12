package com.ihaveaname.java.leetcode.graph;

import java.util.*;

public class LoudAndRich_851 {
  class Solution {
    class Node {
      boolean sorted = false;
      Set<Integer> from = new HashSet<>();
      Set<Integer> to = new HashSet<>();
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
      int n = quiet.length;
      Node[] graph = toGraph(n, richer);
      int[] min = new int[n];
      Arrays.fill(min, -1);
      for (int i = 0; i < n; i++) {
        dfs(graph, quiet, i, min);
      }

      return min;
    }

    private int dfs(Node[] graph, int[] quiet, int i, int[] min) {
      if (min[i] == -1) {
        min[i] = i;
        for (int to : graph[i].to) {
          int cand = dfs(graph, quiet, to, min);
          if (quiet[cand] < quiet[min[i]]) {
            min[i] = cand;
          }
        }
      }

      return min[i];
    }

    private Node[] toGraph(int n, int[][] richer) {
      Node[] result = new Node[n];
      for (int i = 0; i < n; i++) result[i] = new Node();
      for (int[] r : richer) {
        int x = r[0];
        int y = r[1];
        result[y].to.add(x);
        result[x].from.add(y);
      }
      return result;
    }

    private void topoSort(Node[] graph, int[] L) {
      int count = 0;
      Queue<Integer> S = new LinkedList<>();
      for (int i = 0; i < graph.length; i++) {
        if (!graph[i].sorted && graph[i].from.isEmpty()) {
          S.add(i);
        }
      }

      while (!S.isEmpty()) {
        int length = S.size();
        for (int l = 0; l < length; l++) {
          int s = S.poll();
          L[count++] = s;
          graph[s].sorted = true;
          for (int to : graph[s].to) {
            graph[to].from.remove(s);
          }
        }

        for (int i = 0; i < graph.length; i++) {
          if (!graph[i].sorted && graph[i].from.isEmpty()) {
            S.add(i);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    LoudAndRich_851 loudAndRich_851 = new LoudAndRich_851();
    Solution solution = loudAndRich_851.new Solution();

    int[][] richer = new int[][] {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
    int[] quiet = new int[] {3, 2, 5, 4, 6, 1, 7, 0};
    System.out.println(Arrays.toString(solution.loudAndRich(richer, quiet)));
  }
}
