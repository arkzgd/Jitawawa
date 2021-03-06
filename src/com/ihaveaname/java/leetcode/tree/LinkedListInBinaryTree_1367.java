package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class LinkedListInBinaryTree_1367 {
  class Solution {
    private boolean isSubPath(ListNode head, ListNode curr, TreeNode root) {
      if (root != null && curr != null) {
        if (root.val == curr.val) {
          if (isSubPath(head, curr.next, root.left)) return true;
          if (isSubPath(head, curr.next, root.right)) return true;
        } else return false;
      }

      if (curr == null) return true;
      else return false;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
      if (isSubPath(head, head, root)) return true;
      else return root != null && (isSubPath(head, root.left) || isSubPath(head, root.right));
    }
  }

  public static void main(String[] args) {
    LinkedListInBinaryTree_1367 linkedListInBinaryTree_1367 = new LinkedListInBinaryTree_1367();
    Solution solution = linkedListInBinaryTree_1367.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)),
            new TreeNode(
                4,
                new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))),
                null));
    ListNode head = new ListNode(4, new ListNode(2, new ListNode(8)));
    System.out.println(solution.isSubPath(head, tree));

    head = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6))));
    System.out.println(solution.isSubPath(head, tree));

    head = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6, new ListNode(8)))));
    System.out.println(solution.isSubPath(head, tree));

    tree =
        new TreeNode(
            1, null, new TreeNode(1, new TreeNode(10, new TreeNode(9), null), new TreeNode(1)));
    head = new ListNode(1, new ListNode(10));
    System.out.println(solution.isSubPath(head, tree));
  }
}
