package com.ihaveaname.java.leetcode;

public class PopulatingNextRightPointersInEachNode_116 {
  class Solution {
    private void helper(Node root, int level, Node[] store) {
      if (root != null) {
        if (store[level] != null) store[level].next = root;
        store[level] = root;
        helper(root.left, level + 1, store);
        helper(root.right, level + 1, store);
      }
    }

    public Node connect(Node root) {
      Node[] store = new Node[12];
      helper(root, 0, store);

      return root;
    }
  }

  public static void main(String[] args) {
    PopulatingNextRightPointersInEachNode_116 populatingNextRightPointersInEachNode_116 =
        new PopulatingNextRightPointersInEachNode_116();
    Solution solution = populatingNextRightPointersInEachNode_116.new Solution();

    Node tree =
        new Node(
            1,
            new Node(2, new Node(4), new Node(5), null),
            new Node(3, new Node(6), new Node(7), null),
            null);
    System.out.println(solution.connect(tree));
  }
}
