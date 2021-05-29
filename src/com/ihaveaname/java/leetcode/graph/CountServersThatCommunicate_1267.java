package com.ihaveaname.java.leetcode.graph;

public class CountServersThatCommunicate_1267 {
  class Solution {
    private int counter;

    private void count(int[][] grid, int row, int col) {
      if (grid[row][col] == 1) {
        boolean comm = false;
        grid[row][col] = 0;
        for (int newCol = 0; newCol < grid[row].length; newCol++) {
          if (grid[row][newCol] == 1) {
            comm = true;
            break;
          }
        }
        for (int newRow = 0; newRow < grid.length; newRow++) {
          if (grid[newRow][col] == 1) {
            comm = true;
            break;
          }
        }
        grid[row][col] = 1;
        if (comm) counter++;
      }
    }

    public int countServers(int[][] grid) {
      counter = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) count(grid, i, j);
      }
      return counter;
    }
  }

  public static void main(String[] args) {
    CountServersThatCommunicate_1267 countServersThatCommunicate_1267 =
        new CountServersThatCommunicate_1267();
    Solution solution = countServersThatCommunicate_1267.new Solution();

    int[][] grid = new int[][] {{1, 0}, {0, 1}};
    System.out.println(solution.countServers(grid));

    grid = new int[][] {{1, 0}, {1, 1}};
    System.out.println(solution.countServers(grid));

    grid = new int[][] {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    System.out.println(solution.countServers(grid));
  }
}
