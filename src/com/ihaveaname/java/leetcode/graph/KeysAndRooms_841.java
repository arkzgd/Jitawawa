package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms_841 {
  class Solution {
    private boolean[] visited;
    private int nonVisitedCount;

    private void dfs(int[][] rooms, int room) {
      if (!visited[room]) {
        nonVisitedCount--;
        visited[room] = true;
      }
      for (int key : rooms[room]) if (!visited[key]) dfs(rooms, key);
    }

    private int[][] listToArray(List<List<Integer>> list) {
      int[][] result = new int[list.size()][];
      int ri = 0;
      for (List<Integer> l : list) {
        int len = l.size();
        int[] a = new int[len];
        int idx = 0;
        for (int i : l) a[idx++] = i;
        result[ri++] = a;
      }

      return result;
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int len = rooms.size();
      visited = new boolean[len];
      nonVisitedCount = len;

      dfs(listToArray(rooms), 0);

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
