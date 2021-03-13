package com.ihaveaname.java.leetcode;

import java.util.*;

public class RedundantConnection {
  class Solution {
    private boolean looped(
        HashMap<Integer, List<Integer>> adjMatrix, HashSet<Integer> visited, int from, int to) {
      if (visited.contains(from) || from == to) return true;
      visited.add(from);
      for (Integer v : adjMatrix.get(from))
        if (!visited.contains(v)) {
          if (looped(adjMatrix, visited, v, to)) return true;
          visited.add(v);
        }

      return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
      HashMap<Integer, List<Integer>> adjMatrix = new LinkedHashMap<>();
      for (int i = 1; i <= 1000; i++) {
        ArrayList<Integer> l = new ArrayList<>();
        adjMatrix.put(i, l);
      }
      HashSet<Integer> visited = new HashSet<>();
      for (int[] e : edges) {
        visited.clear();
        if (looped(adjMatrix, visited, e[0], e[1])) {
          return e;
        } else {
          adjMatrix.get(e[0]).add(e[1]);
          adjMatrix.get(e[1]).add(e[0]);
        }
      }

      return null;
    }
  }

  public static void main(String[] args) {
    RedundantConnection redundantConnection = new RedundantConnection();
    Solution solution = redundantConnection.new Solution();

    int[][] input = new int[][] {{1, 2}, {1, 3}, {2, 3}};
    System.out.println(solution.findRedundantConnection(input));

    input = new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
    System.out.println(solution.findRedundantConnection(input));

    input =
        new int[][] {
          {9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}
        };
    System.out.println(solution.findRedundantConnection(input));
  }
}
