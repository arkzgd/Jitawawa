package com.ihaveaname.java.leetcode.graph;

public class RegionsCutBySlashes_959 {
  class Solution {
    private int[] graph;

    private int graphToIndex(int n, int row, int col, int i) {
      return (row * n + col) * 4 + i;
    }

    private void createGraph(String[] grid) {
      int rows = grid.length;
      int cols = rows;
      graph = new int[rows * cols * 4];
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          switch (grid[row].charAt(col)) {
            case ' ':
              graph[graphToIndex(rows, row, col, 0)] = graphToIndex(rows, row, col, 0);
              graph[graphToIndex(rows, row, col, 1)] = graphToIndex(rows, row, col, 0);
              graph[graphToIndex(rows, row, col, 2)] = graphToIndex(rows, row, col, 1);
              graph[graphToIndex(rows, row, col, 3)] = graphToIndex(rows, row, col, 2);
              break;
            case '/':
              graph[graphToIndex(rows, row, col, 0)] = graphToIndex(rows, row, col, 0);
              graph[graphToIndex(rows, row, col, 1)] = graphToIndex(rows, row, col, 0);
              graph[graphToIndex(rows, row, col, 2)] = graphToIndex(rows, row, col, 2);
              graph[graphToIndex(rows, row, col, 3)] = graphToIndex(rows, row, col, 2);
              break;
            case '\\':
              graph[graphToIndex(rows, row, col, 0)] = graphToIndex(rows, row, col, 0);
              graph[graphToIndex(rows, row, col, 1)] = graphToIndex(rows, row, col, 1);
              graph[graphToIndex(rows, row, col, 2)] = graphToIndex(rows, row, col, 1);
              graph[graphToIndex(rows, row, col, 3)] = graphToIndex(rows, row, col, 0);
              break;
          }
        }
      }
    }

    private void unionTwoGrid(int n, int row1, int col1, int row2, int col2) {
      if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) return;
      if (row1 == row2 && col1 + 1 == col2) {
        // Union grid[row2][col2] to its left cube
        int index = graphToIndex(n, row2, col2, 1);
        while (graph[index] != index) index = graph[index];
        graph[index] = graphToIndex(n, row1, col1, 3);
      } else if (row1 + 1 == row2 && col1 == col2) {
        // Unior grid[row2][col2] to its upper cube
        int index = graphToIndex(n, row2, col2, 0);
        while (graph[index] != index) index = graph[index];
        graph[index] = graphToIndex(n, row1, col1, 2);
      }
    }

    public int regionsBySlashes(String[] grid) {
      createGraph(grid);
      int rows = grid.length;
      int cols = rows;
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          unionTwoGrid(rows, row - 1, col, row, col);
          unionTwoGrid(rows, row, col - 1, row, col);
        }
      }

      int count = 0;
      for (int i = 0; i < rows * cols * 4; i++) if (graph[i] == i) count++;

      return count;
    }
  }

  public static void main(String[] args) {
    RegionsCutBySlashes_959 regionsCutBySlashes_959 = new RegionsCutBySlashes_959();
    Solution solution = regionsCutBySlashes_959.new Solution();

    String[] grid = new String[] {" /", "/ "};
    System.out.println(solution.regionsBySlashes(grid));

    grid = new String[] {" /", "  "};
    System.out.println(solution.regionsBySlashes(grid));

    grid = new String[] {"\\/", "/\\"};
    System.out.println(solution.regionsBySlashes(grid));

    grid = new String[] {"/\\", "\\/"};
    System.out.println(solution.regionsBySlashes(grid));

    grid = new String[] {"//", "/ "};
    System.out.println(solution.regionsBySlashes(grid));
  }
}
