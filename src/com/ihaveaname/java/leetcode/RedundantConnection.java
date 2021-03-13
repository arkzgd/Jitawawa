package com.ihaveaname.java.leetcode;

import java.util.*;

public class RedundantConnection {
  class Solution {
    private boolean looped(
        HashMap<Integer, List<Integer>> adjMatrix, HashSet<Integer> visited, int from, int to) {
      if (visited.contains(from) || from == to) return true;
      visited.add(from);
      if (!adjMatrix.containsKey(from)) return false;
      for (Integer v : adjMatrix.get(from))
        if (!visited.contains(v)) {
          if (looped(adjMatrix, visited, v, to)) return true;
          visited.add(v);
        }

      return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
      int[] lastPair = null;
      HashMap<Integer, List<Integer>> adjMatrix = new LinkedHashMap<>();
      HashSet<Integer> visited = new HashSet<>();
      for (int[] e : edges) {
        visited.clear();
        if (looped(adjMatrix, visited, e[0], e[1])) {
          lastPair = e;
          break;
        } else {
          if (adjMatrix.containsKey(e[0])) adjMatrix.get(e[0]).add(e[1]);
          else {
            List<Integer> l = new ArrayList<>();
            l.add(e[1]);
            adjMatrix.put(e[0], l);
          }

          if (adjMatrix.containsKey(e[1])) adjMatrix.get(e[1]).add(e[0]);
          else {
            List<Integer> l = new ArrayList<>();
            l.add(e[0]);
            adjMatrix.put(e[1], l);
          }
        }
      }

      return lastPair;
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
