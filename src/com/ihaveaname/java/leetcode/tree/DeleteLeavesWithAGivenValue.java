package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class DeleteLeavesWithAGivenValue {
  static class Solution {
    private TreeNode helper(TreeNode node, TreeNode parent, int target) {
      if (node != null) {
        node.left = helper(node.left, node, target);
        node.right = helper(node.right, node, target);
        if (node.val == target && node.left == null && node.right == null) {
          if (parent != null) {
            if (parent.left == node) parent.left = null;
            if (parent.right == node) parent.right = null;
          }
        } else return node;
      }
      return null;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
      root = helper(root, null, target);
      return root;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    TreeNode tree =
        new TreeNode(
            1, new TreeNode(2, new TreeNode(2, new TreeNode(2, null, null), null), null), null);
    tree = solution.removeLeafNodes(tree, 2);

    tree = new TreeNode(1, new TreeNode(1, null, null), new TreeNode(1, null, null));
    tree = solution.removeLeafNodes(tree, 1);

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    tree = solution.removeLeafNodes(tree, 1);

    tree = new TreeNode(1, new TreeNode(3, new TreeNode(3), new TreeNode(2)), new TreeNode(3));
    tree = solution.removeLeafNodes(tree, 3);

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(2), null),
            new TreeNode(3, new TreeNode(2), new TreeNode(4)));
    tree = solution.removeLeafNodes(tree, 2);
  }
}
