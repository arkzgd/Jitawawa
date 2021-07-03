package com.ihaveaname.java.leetcode.graph;

import java.util.HashSet;
import java.util.Set;

public class MostStoneRemovedWithSameRowOrColumn_947 {
  class Solution {
    class Node {
      int i;
      int j;
      Node parent;

      Node(int i, int j) {
        this.i = i;
        this.j = j;
        this.parent = null;
      }

      boolean connected(Node another) {
        return this.i == another.i || this.j == another.j;
      }
    }

    public int removeStones(int[][] stones) {
      int N = stones.length;
      Set<Node> incorporated = new HashSet<>();

      for (int[] s : stones) {
        Node stone = new Node(s[0], s[1]);
        for (Node n : incorporated) {
          if (n.connected(stone)) {
            Node p = n;
            while (p.parent != null) p = p.parent;
            if (p != stone) p.parent = stone;
          }
        }
        incorporated.add(stone);
      }

      int count = 0;
      for (Node n : incorporated) {
        if (n.parent == null) count++;
      }

      return N - count;
    }
  }

  public static void main(String[] args) {
    MostStoneRemovedWithSameRowOrColumn_947 mostStoneRemovedWithSameRowOrColumn_947 =
        new MostStoneRemovedWithSameRowOrColumn_947();
    Solution solution = mostStoneRemovedWithSameRowOrColumn_947.new Solution();
    int[][] stones = new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    System.out.println(solution.removeStones(stones));

    stones = new int[][] {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
    System.out.println(solution.removeStones(stones));

    stones = new int[][] {{0, 1}, {1, 0}, {1, 1}};
    System.out.println(solution.removeStones(stones));

    stones = new int[][] {{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}};
    System.out.println(solution.removeStones(stones));

    stones = new int[][] {{0, 1}, {0, 2}, {4, 3}, {2, 4}, {0, 3}, {1, 1}};
    System.out.println(solution.removeStones(stones));
  }
}
