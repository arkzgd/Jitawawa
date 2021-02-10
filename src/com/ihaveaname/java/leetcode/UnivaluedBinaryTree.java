package com.ihaveaname.java.leetcode;

public class UnivaluedBinaryTree {
  public boolean isUnivalTree(TreeNode root) {
    if (root != null) {
      if (root.left != null && root.left.val != root.val
          || root.right != null && root.right.val != root.val) return false;
      if (!isUnivalTree(root.left)) return false;
      return isUnivalTree(root.right);
    }

    return true;
  }

  public static void main(String[] args) {
    UnivaluedBinaryTree uvbt = new UnivaluedBinaryTree();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(1, new TreeNode(1, null, null), new TreeNode(1, null, null)),
            new TreeNode(1, null, new TreeNode(1, null, null)));
    System.out.println(uvbt.isUnivalTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(1, new TreeNode(2, null, null), new TreeNode(1, null, null)),
            new TreeNode(1, null, new TreeNode(1, null, null)));
    System.out.println(uvbt.isUnivalTree(tree));
  }
}
