package com.ihaveaname.java.leetcode.graph;

import java.util.Arrays;

public class NumberOfOperationsToMakeNetworkConnected_1319 {
  class Solution {
    public int makeConnected(int n, int[][] connections) {
      int[] parent = new int[n];
      Arrays.fill(parent, -1);
      if (connections.length >= n - 1) {
        for (int[] connection : connections) {
          int i = connection[0];
          int j = connection[1];
          int p = i;
          while (parent[p] != -1) p = parent[p];
          if (p != i) {
            parent[i] = p;
            parent[j] = p;
          } else parent[j] = i;
        }
        int count = 0;
        for (int p : parent) if (p == -1) count++;
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
