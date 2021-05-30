package com.ihaveaname.java.leetcode.graph;

import java.util.Arrays;

public class MapOfHighestPeak_1765 {
  class Solution {
    int[][] result;
    boolean[][] visited;

    private boolean rangeCheck(int[][] isWater, int row, int col) {
      return row >= 0 && row < isWater.length && col >= 0 && col < isWater[row].length;
    }

    private void setNeighbor(int[][] isWater, int[][] result, int row, int col) {
      if (rangeCheck(isWater, row - 1, col)) {
        result[row - 1][col] =
            result[row - 1][col] == 0
                ? result[row][col] + 1
                : Math.min(result[row - 1][col], result[row][col] + 1);
      }

      if (rangeCheck(isWater, row + 1, col)) {
        result[row + 1][col] =
            result[row + 1][col] == 0
                ? result[row][col] + 1
                : Math.min(result[row + 1][col], result[row][col] + 1);
      }

      if (rangeCheck(isWater, row, col - 1)) {
        result[row][col - 1] =
            result[row][col - 1] == 0
                ? result[row][col] + 1
                : Math.min(result[row][col - 1], result[row][col] + 1);
      }

      if (rangeCheck(isWater, row, col + 1)) {
        result[row][col + 1] =
            result[row][col + 1] == 0
                ? result[row][col] + 1
                : Math.min(result[row][col + 1], result[row][col] + 1);
      }
    }

    private void bfs(int[][] isWater, int row, int col) {
      if (!rangeCheck(isWater, row, col)) return;
      else if (!visited[row][col]) {
        if (isWater[row][col] == 1) {
          result[row][col] = 0;
          setNeighbor(isWater, result, row, col);
          visited[row][col] = true;
        } else {
          setNeighbor(isWater, result, row, col);
          visited[row][col] = true;
        }

        bfs(isWater, row - 1, col);
        bfs(isWater, row + 1, col);
        bfs(isWater, row, col - 1);
        bfs(isWater, row, col + 1);
      }
    }

    public int[][] highestPeak(int[][] isWater) {
      int rows = isWater.length;
      int cols = isWater[0].length;
      result = new int[rows][cols];
      visited = new boolean[rows][cols];
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          if (isWater[row][col] == 1) bfs(isWater, row, col);
        }
      }

      return result;
    }
  }

  public static void main(String[] args) {
    MapOfHighestPeak_1765 mapOfHighestPeak_1765 = new MapOfHighestPeak_1765();
    Solution solution = mapOfHighestPeak_1765.new Solution();

    int[][] isWater = new int[][] {{0, 1}, {0, 0}};
    System.out.println(Arrays.deepToString(solution.highestPeak(isWater)));

    isWater = new int[][] {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
    System.out.println(Arrays.deepToString(solution.highestPeak(isWater)));
  }
}
