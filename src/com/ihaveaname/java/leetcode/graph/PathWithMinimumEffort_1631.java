package com.ihaveaname.java.leetcode.graph;

public class PathWithMinimumEffort_1631 {
  class Solution {
    private int min;
    private final int[][] where = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(
        int i, int j, int[][] heights, int rows, int cols, int soFar, int[][] visited) {
      visited[i][j] = 1;
      if (i == rows - 1 && j == cols - 1) {
        min = Math.min(soFar, min);
        return;
      }
      int row, col;
      for (int[] move : where) {
        row = i + move[0];
        col = j + move[1];
        if (row < 0 || row >= rows || col < 0 || col >= cols) continue;
        if (visited[row][col] == 0) {
          int d = Math.abs(heights[i][j] - heights[row][col]);
          dfs(row, col, heights, rows, cols, Math.max(soFar, d), visited);
          visited[row][col] = 0;
        }
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

    heights = new int[][] {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
    System.out.println(solution.minimumEffortPath(heights));

    heights =
        new int[][] {
          {1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}
        };
    System.out.println(solution.minimumEffortPath(heights));

    heights =
        new int[][] {
          {8, 3, 2, 5, 2, 10, 7, 1, 8, 9},
          {1, 4, 9, 1, 10, 2, 4, 10, 3, 5},
          {4, 10, 10, 3, 6, 1, 3, 9, 8, 8},
          {4, 4, 6, 10, 10, 10, 2, 10, 8, 8},
          {9, 10, 2, 4, 1, 2, 2, 6, 5, 7},
          {2, 9, 2, 6, 1, 4, 7, 6, 10, 9},
          {8, 8, 2, 10, 8, 2, 3, 9, 5, 3},
          {2, 10, 9, 3, 5, 1, 7, 4, 5, 6},
          {2, 3, 9, 2, 5, 10, 2, 7, 1, 8},
          {9, 10, 4, 10, 7, 4, 9, 3, 1, 6}
        };
    System.out.println(solution.minimumEffortPath(heights));
  }
}
