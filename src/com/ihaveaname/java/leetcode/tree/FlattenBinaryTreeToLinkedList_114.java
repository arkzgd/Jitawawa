package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {
  class Solution {
    private void helper(TreeNode root, TreeNode prev) {
      if (root != null) {
        if (root.right != null) {
          helper(root.right, prev);
        }

        if (root.left != null) {
          helper(root.left, root.right != null ? root.right : prev);
        }

        prev = (root.left != null ? root.left : (root.right != null ? root.right : prev));
        root.left = null;
        root.right = prev;
      }
    }

    public void flatten(TreeNode root) {
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
