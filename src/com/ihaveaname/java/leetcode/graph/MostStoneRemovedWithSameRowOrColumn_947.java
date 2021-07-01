package com.ihaveaname.java.leetcode.graph;

public class MostStoneRemovedWithSameRowOrColumn_947 {
  class Solution {
    public int removeStones(int[][] stones) {
      int n = stones.length;
      return 0;
    }
  }

  public static void main(String[] args) {
    MostStoneRemovedWithSameRowOrColumn_947 mostStoneRemovedWithSameRowOrColumn_947 =
        new MostStoneRemovedWithSameRowOrColumn_947();
    Solution solution = mostStoneRemovedWithSameRowOrColumn_947.new Solution();
    int[][] stones = new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    System.out.println(solution.removeStones(stones));
  }
}
