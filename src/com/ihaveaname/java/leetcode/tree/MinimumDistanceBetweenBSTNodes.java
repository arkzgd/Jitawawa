package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
  private int minGap;
  private TreeNode previous;

  public MinimumDistanceBetweenBSTNodes() {
    minGap = Integer.MAX_VALUE;
    previous = null;
  }

  private void helper(TreeNode root) {
    if (root != null) {
      helper(root.left);
      if (previous != null && root.val - previous.val < minGap) minGap = root.val - previous.val;
      previous = root;
      helper(root.right);
    }
  }

  public int minDiffInBST(TreeNode root) {
    helper(root);
    return minGap;
  }

  public static void main(String[] args) {
    MinimumDistanceBetweenBSTNodes mdbbn = new MinimumDistanceBetweenBSTNodes();

    TreeNode tree =
        new TreeNode(
            4,
            new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
            new TreeNode(6, null, null));
    System.out.println(mdbbn.minDiffInBST(tree));
  }
}
