package com.ihaveaname.java.leetcode;

import java.util.List;

public class FlattenBinaryTreeToLinkedList_114 {
  class Solution {
    TreeNode list;

    private TreeNode helper(TreeNode root, TreeNode prev) {
      if (root != null) {
        TreeNode n = new TreeNode(root.val);
        if (list == null) list = n;
        if (prev != null) prev.right = n;
        TreeNode p = helper(root.left, n);
        TreeNode r = helper(root.right, p);
        return r;
      }

      return prev;
    }

    public void flatten(TreeNode root) {
      list = null;
      helper(root, null);
    }
  }

  public static void main(String[] args) {
    FlattenBinaryTreeToLinkedList_114 flattenBinaryTreeToLinkedList_114 =
        new FlattenBinaryTreeToLinkedList_114();
    Solution solution = flattenBinaryTreeToLinkedList_114.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(6)));
    solution.flatten(tree);

    tree = null;
    solution.flatten(tree);

    tree = new TreeNode(0);
    solution.flatten(tree);
  }
}
