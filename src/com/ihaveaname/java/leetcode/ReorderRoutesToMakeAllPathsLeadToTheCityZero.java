package com.ihaveaname.java.leetcode;

import java.util.HashSet;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
  class Solution {
    public int minReorder(int n, int[][] connections) {
      int count = 0;
      HashSet<Integer> cities = new HashSet<>();
      cities.add(0);
      for (int[] connection : connections) {
        int from = connection[0];
        int to = connection[1];
        if (!cities.contains(to)) count++;
        cities.add(from);
        cities.add(to);
      }

      return count;
    }
  }

  public static void main(String[] args) {
    ReorderRoutesToMakeAllPathsLeadToTheCityZero reorderRoutesToMakeAllPathsLeadToTheCityZero =
        new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
    Solution solution = reorderRoutesToMakeAllPathsLeadToTheCityZero.new Solution();

    int[][] connections = new int[][] {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    System.out.println(solution.minReorder(6, connections));

    connections = new int[][] {{1,0},{1,2},{3,2},{3,4}};
    System.out.println(solution.minReorder(6, connections));

    connections = new int[][] {{1, 0}, {2, 0}};
    System.out.println(solution.minReorder(6, connections));
  }
}
