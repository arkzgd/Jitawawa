package com.ihaveaname.java.leetcode;

public class TrimBranch {
  static class TreeNode {
    int val;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode left;

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private static TreeNode trimBranch(TreeNode root) {
    if (root != null) {
      root.left = trimBranch(root.left);
      root.right = trimBranch(root.right);
      if (root.val == 0 && root.left == null && root.right == null) root = null;
    }

    return root;
  }

  private static TreeNode solutionTrimBranch(TreeNode root) {
    return trimBranch(root);
  }

  public static void main(String[] args) {
    TreeNode root =
        new TreeNode(
            1, null, new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null)));
    root = solutionTrimBranch(root);
    System.out.println(root);

    TreeNode root2 =
      new TreeNode(1, new TreeNode(0, new TreeNode(0, null, null), new TreeNode(0, null, null)), new TreeNode(1, new TreeNode(0, null, null), new TreeNode(1, null, null)));
    root2 = solutionTrimBranch(root2);
    System.out.println(root2);
  }
}
