package com.ihaveaname.java.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak_1765 {
  class Solution {
    private int[][] result;
    private boolean[][] visited;

    private boolean rangeCheck(int[][] isWater, int row, int col) {
      return row >= 0 && row < isWater.length && col >= 0 && col < isWater[row].length;
    }

    private void setNeighbor(
        int[][] isWater, int[][] result, int row, int col, Queue<int[]> queue) {
      if (rangeCheck(isWater, row - 1, col) && isWater[row - 1][col] != 1) {
        result[row - 1][col] =
            result[row - 1][col] == 0
                ? result[row][col] + 1
                : Math.min(result[row - 1][col], result[row][col] + 1);
        if (!visited[row - 1][col]) {
          queue.offer(new int[] {row - 1, col});
          visited[row - 1][col] = true;
        }
      }

      if (rangeCheck(isWater, row + 1, col) && isWater[row + 1][col] != 1) {
        result[row + 1][col] =
            result[row + 1][col] == 0
                ? result[row][col] + 1
                : Math.min(result[row + 1][col], result[row][col] + 1);
        if (!visited[row + 1][col]) {
          queue.offer(new int[] {row + 1, col});
          visited[row + 1][col] = true;
        }
      }

      if (rangeCheck(isWater, row, col - 1) && isWater[row][col - 1] != 1) {
        result[row][col - 1] =
            result[row][col - 1] == 0
                ? result[row][col] + 1
                : Math.min(result[row][col - 1], result[row][col] + 1);
        if (!visited[row][col - 1]) {
          queue.offer(new int[] {row, col - 1});
          visited[row][col - 1] = true;
        }
      }

      if (rangeCheck(isWater, row, col + 1) && isWater[row][col + 1] != 1) {
        result[row][col + 1] =
            result[row][col + 1] == 0
                ? result[row][col] + 1
                : Math.min(result[row][col + 1], result[row][col] + 1);
        if (!visited[row][col + 1]) {
          queue.offer(new int[] {row, col + 1});
          visited[row][col + 1] = true;
        }
      }
    }

    private void bfs(int[][] isWater, int row, int col) {
      if (!rangeCheck(isWater, row, col) || isWater[row][col] != 1) return;
      else {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        result[row][col] = 0;
        while (!queue.isEmpty()) {
          int[] pair = queue.poll();
          setNeighbor(isWater, result, pair[0], pair[1], queue);
        }
      }
    }

    public int[][] highestPeak(int[][] isWater) {
      int rows = isWater.length;
      int cols = isWater[0].length;
      result = new int[rows][cols];
      for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
          if (isWater[row][col] == 1) {
            visited = new boolean[rows][cols];
            bfs(isWater, row, col);
          }
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

    isWater =
        new int[][] {
          {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
          {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
          {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
        };
    System.out.println(Arrays.deepToString(solution.highestPeak(isWater)));
  }
}
