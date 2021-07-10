package com.ihaveaname.java.leetcode.graph;

import java.util.Arrays;

public class NumberOfOperationsToMakeNetworkConnected_1319 {
  class Solution {
    private int findParent(int[] parent, int i) {
      if (parent[i] == -1) return i;
      parent[i] = findParent(parent, parent[i]);
      return parent[i];
    }

    private int union(int[] parent, int[] ranks, int i, int j, int count) {
      int ip = findParent(parent, i);
      int jp = findParent(parent, j);

      if (ip == jp) return count;
      else {
        if (ranks[ip] > ranks[jp]) {
          parent[jp] = ip;
          ranks[ip] += ranks[jp];
        } else {
          parent[ip] = jp;
          ranks[jp] += ranks[ip];
        }
        count--;
      }

      return count;
    }

    public int makeConnected(int n, int[][] connections) {
      int[] parent = new int[n];
      Arrays.fill(parent, -1);
      int[] ranks = new int[n];
      Arrays.fill(ranks, 1);
      int count = n;
      if (connections.length >= n - 1) {
        for (int[] connection : connections) {
          int i = connection[0];
          int j = connection[1];
          count = union(parent, ranks, i, j, count);
        }
        return count - 1;
      } else return -1;
    }
  }

  public static void main(String[] args) {
    NumberOfOperationsToMakeNetworkConnected_1319 numberOfOperationsToMakeNetworkConnected_1319 =
        new NumberOfOperationsToMakeNetworkConnected_1319();
    Solution solution = numberOfOperationsToMakeNetworkConnected_1319.new Solution();

    int n = 4;
    int[][] connected = new int[][] {{0, 1}, {0, 2}, {1, 2}};
    System.out.println(solution.makeConnected(n, connected));

    n = 6;
    connected = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
    System.out.println(solution.makeConnected(n, connected));

    n = 6;
    connected = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
    System.out.println(solution.makeConnected(n, connected));

    n = 5;
    connected = new int[][] {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
    System.out.println(solution.makeConnected(n, connected));

    n = 11;
    connected =
        new int[][] {
          {1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1}, {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7},
          {0, 7}, {5, 7}
        };
    System.out.println(solution.makeConnected(n, connected));
  }
}
