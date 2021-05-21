package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root != null) {
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    return 0;
  }
}
