package com.ihaveaname.java.leetcode.graph;

public class IsGraphBipartite_785 {
  class Solution {
    public boolean isBipartite(int[][] graph) {
      return false;
    }
  }

  public static void main(String[] args) {
    IsGraphBipartite_785 isGraphBipartite_785 = new IsGraphBipartite_785();
    Solution solution = isGraphBipartite_785.new Solution();

    int[][] graph = new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    System.out.println(solution.isBipartite(graph));
  }
}
