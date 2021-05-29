package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms_841 {
  class Solution {
    private boolean[] visited;
    private int nonVisitedCount;

    private void dfs(List<List<Integer>> rooms, int room) {
      if (!visited[room]) {
        nonVisitedCount--;
        visited[room] = true;
      }
      for (int key : rooms.get(room)) if (!visited[key]) dfs(rooms, key);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int len = rooms.size();
      visited = new boolean[len];
      nonVisitedCount = len;

      dfs(rooms, 0);

      return nonVisitedCount == 0;
    }
  }

  private static List<List<Integer>> arrayToList(int[][] array) {
    List<List<Integer>> result = new ArrayList<>();
    for (int[] a : array) {
      List<Integer> l = new ArrayList<>();
      for (int i : a) l.add(i);
      result.add(l);
    }

    return result;
  }

  public static void main(String[] args) {
    KeysAndRooms_841 keysAndRooms_841 = new KeysAndRooms_841();
    Solution solution = keysAndRooms_841.new Solution();

    int[][] input = new int[][] {{1}, {2}, {3}, {}};
    System.out.println(solution.canVisitAllRooms(arrayToList(input)));

    input = new int[][] {{1, 3}, {3, 0, 1}, {2}, {0}};
    System.out.println(solution.canVisitAllRooms(arrayToList(input)));
  }
}
