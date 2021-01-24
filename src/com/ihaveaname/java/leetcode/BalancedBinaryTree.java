package com.ihaveaname.java.leetcode;

public class BalancedBinaryTree {
  private int height(TreeNode node) {
    if (node == null) return 0;
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (Math.abs(height(root.left) - height(root.right)) <= 1)
      return isBalanced(root.left) && isBalanced(root.right);
    else return false;
  }

  public static void main(String[] args) {
    BalancedBinaryTree bbt = new BalancedBinaryTree();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(9, null, null),
            new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    System.out.println(bbt.isBalanced(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(3, new TreeNode(4, null, null), new TreeNode(4, null, null)),
                new TreeNode(3, null, null)),
            new TreeNode(2, null, null));
    System.out.println(bbt.isBalanced(tree));
  }
}
