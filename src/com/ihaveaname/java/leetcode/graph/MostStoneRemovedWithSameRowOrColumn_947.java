package com.ihaveaname.java.leetcode.graph;

import java.util.*;

public class MostStoneRemovedWithSameRowOrColumn_947 {
  class Solution {
    class Node {
      int i;
      int j;
      Node parent;

      Node(int i, int j) {
        this.i = i;
        this.j = j;
        this.parent = this;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return i == node.i && j == node.j;
      }

      @Override
      public int hashCode() {
        return Objects.hash(i, j);
      }

      boolean connected(Node another) {
        return this.i == another.i || this.j == another.j;
      }
    }

    private Node findParent(Node v) {
      if (v.parent != v) {
        v.parent = findParent(v.parent);
      }

      return v.parent;
    }

    public int removeStones(int[][] stones) {
      int count = stones.length;
      ArrayList<Node> graph = new ArrayList<>();
      Map<Node, Integer> ranks = new HashMap<>();
      for (int[] stone : stones) {
        Node n = new Node(stone[0], stone[1]);
        graph.add(n);
        ranks.put(n, 1);
      }

      for (Node s : graph) {
        for (Node t : graph) {
          if (s.connected(t)) {
            count = union(graph, ranks, s, t, count);
          }
        }
      }

      return stones.length - count;
    }

    private int union(
        ArrayList<Node> graph, Map<Node, Integer> ranks, Node stone1, Node stone2, int count) {
      Node root1 = findParent(stone1);
      Node root2 = findParent(stone2);

      if (root1 == root2) return count;
      else {
        if (ranks.get(root1) > ranks.get(root2)) {
          root2.parent = root1;
          ranks.put(root1, ranks.get(root1) + ranks.get(root2));
        } else {
          root1.parent = root2;
          ranks.put(root2, ranks.get(root1) + ranks.get(root2));
        }
        count--;
      }

      return count;
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
