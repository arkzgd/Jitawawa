package com.ihaveaname.java.leetcode;

public class IncreasingOrderSearchTree {
  private TreeNode pre = null;
  private TreeNode newRoot = null;

  private TreeNode helper(TreeNode root) {
    if (root == null) return null;

    helper(root.left);

    if (newRoot == null) newRoot = root;
    if (pre != null) {
      pre.left = null;
      pre.right = root;
    }
    pre = root;

    helper(root.right);

    return newRoot;
  }

  public TreeNode increasingBST(TreeNode root) {
    pre = null;
    newRoot = null;

    return helper(root);
  }

  public static void main(String[] args) {
    IncreasingOrderSearchTree iost = new IncreasingOrderSearchTree();

    TreeNode tree =
        new TreeNode(
            5,
            new TreeNode(
                3, new TreeNode(2, new TreeNode(1, null, null), null), new TreeNode(4, null, null)),
            new TreeNode(
                6,
                null,
                new TreeNode(8, new TreeNode(7, null, null), new TreeNode(9, null, null))));
    TreeNode root = iost.increasingBST(tree);
    System.out.println(root);

    tree =
        new TreeNode(
            2, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3, null, null), null));
    root = iost.increasingBST(tree);
    System.out.println(root);
  }
}
