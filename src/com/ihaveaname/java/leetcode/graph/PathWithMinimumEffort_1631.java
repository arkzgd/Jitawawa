package com.ihaveaname.java.leetcode.graph;

public class PathWithMinimumEffort_1631 {
  class Solution {
    private int min;
    private int[][] where = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(
        int i, int j, int[][] heights, int rows, int cols, int soFar, int[][] visited) {
      if (i == rows - 1 && j == cols - 1) return;
      for (int[] move : where) {

      }
    }

    public int minimumEffortPath(int[][] heights) {
      min = Integer.MAX_VALUE;
      int rows = heights.length;
      int cols = heights[0].length;
      int[][] visited = new int[rows][cols];
      dfs(0, 0, heights, rows, cols, 0, visited);

      return min;
    }
  }

  public static void main(String[] args) {
    PathWithMinimumEffort_1631 pathWithMinimumEffort_1631 = new PathWithMinimumEffort_1631();
    Solution solution = pathWithMinimumEffort_1631.new Solution();

    int[][] heights = new int[][] {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
    System.out.println(solution.minimumEffortPath(heights));
  }
}
