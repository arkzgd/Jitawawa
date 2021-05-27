package com.ihaveaname.java.leetcode.graph;

public class RegionsCutBySlashes_959 {
  class Solution {
    private int[][][] graph;

    private void createGraph(String[] grid) {
      int rows = grid.length;
      int cols = rows;
      graph = new int[rows][cols][];
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          switch (grid[row].charAt(col)) {
            case ' ':
              graph[row][col] = new int[] {-1, 0, 0, 0};
              break;
            case '/':
              graph[row][col] = new int[] {-1, 0, -1, 2};
              break;
            case '\\':
              graph[row][col] = new int[] {-1, -1, 1, 0};
              break;
          }
        }
      }
    }

    private void unionTwoGrid(int row1, int col1, int row2, int col2) {
      int[] grid1 = graph[row1][col1];
      int[] grid2 = graph[row2][col2];
      if (row1 == row2 - 1) {
        // union grid[row2][col2] with the grid on top
      } else if (col1 == col2 - 1) {
        // union grid[row2][col2] with the grid on the left
      }
    }

    public int regionsBySlashes(String[] grid) {
      createGraph(grid);
      int rows = grid.length;
      int cols = rows;
      for (int row = 1; row < rows; row++) {
        for (int col = 1; col < cols; col++) {
          unionTwoGrid(row - 1, col, row, col);
          unionTwoGrid(row, col - 1, row, col);
        }
      }

      int count = 0;
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          for (int i = 0; i < 4; i++) {
            if (graph[row][col][i] == -1) count++;
          }
        }
      }

      return count;
    }
  }

  public static void main(String[] args) {
    RegionsCutBySlashes_959 regionsCutBySlashes_959 = new RegionsCutBySlashes_959();
    Solution solution = regionsCutBySlashes_959.new Solution();

    String[] grid = new String[] {" /", "/ "};
    System.out.println(solution.regionsBySlashes(grid));
  }
}
