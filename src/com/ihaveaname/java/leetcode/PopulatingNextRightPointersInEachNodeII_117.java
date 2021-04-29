package com.ihaveaname.java.leetcode;

public class PopulatingNextRightPointersInEachNodeII_117 {
  class Solution {
    public Node connect(Node root) {
      Node thisLevel = root;
      Node head = root;
      while (head != null) {
        while (thisLevel != null) {
          if (thisLevel.left != null) {
            if (thisLevel.right != null) thisLevel.left.next = thisLevel.right;
            else {
              Node next = thisLevel.next;
              while (next != null && next.left == null && next.right == null) next = next.next;
              if (next != null) thisLevel.left.next = next.left != null ? next.left : next.right;
            }
          }

          if (thisLevel.right != null) {
            Node next = thisLevel.next;
            while (next != null && next.left == null && next.right == null) next = next.next;
            if (next != null) thisLevel.right.next = next.left != null ? next.left : next.right;
          }

          thisLevel = thisLevel.next;
        }

        while (head != null && head.left == null && head.right == null) {
          head = head.next;
        }

        if (head != null) thisLevel = head.left != null ? head.left : head.right;
        head = thisLevel;
      }

      return root;
    }
  }

  public static void main(String[] args) {
    PopulatingNextRightPointersInEachNodeII_117 populatingNextRightPointersInEachNodeII_117 =
        new PopulatingNextRightPointersInEachNodeII_117();
    Solution solution = populatingNextRightPointersInEachNodeII_117.new Solution();

    Node tree =
        new Node(
            1,
            new Node(2, new Node(4), new Node(5), null),
            new Node(3, null, new Node(7), null),
            null);
    System.out.println(solution.connect(tree));

    tree = new Node(1);
    System.out.println(solution.connect(tree));

    tree =
        new Node(
            1, new Node(2, new Node(4), null, null), new Node(3, null, new Node(7), null), null);
    System.out.println(solution.connect(tree));

    tree =
        new Node(
            1,
            new Node(2, new Node(4, new Node(7), null, null), new Node(5), null),
            new Node(3, null, new Node(6, null, new Node(8), null), null),
            null);
    System.out.println(solution.connect(tree));
  }
}
