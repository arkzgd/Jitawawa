package com.ihaveaname.java.leetcode;

import java.util.*;

public class RedundantConnection {
  class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      HashSet<Integer> visited = new HashSet<>();
      int[] lastPair = new int[2];
      HashMap<Integer, List<Integer>> adjMatrix = new LinkedHashMap<>();
      for (int[] e : edges) {
        if (adjMatrix.containsKey(e[0])) adjMatrix.get(e[0]).add(e[1]);
        else {
          List<Integer> l = new ArrayList<>();
          l.add(e[1]);
          adjMatrix.put(e[0], l);
        }
      }

      for (int i = 0; i < edges.length; i++) {
        if (visited.contains(edges[i][0]) && visited.contains(edges[i][1])) {
          lastPair[0] = Math.min(edges[i][0], edges[i][1]);
          lastPair[1] = Math.max(edges[i][0], edges[i][1]);
          break;
        } else {
          visited.add(edges[i][0]);
          visited.add(edges[i][1]);
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
