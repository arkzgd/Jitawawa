package com.ihaveaname.java.leetcode;

public class DiameterOfBinaryTree {
  private int height(TreeNode node) {
    if (node == null) return 0;
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  private int max = Integer.MIN_VALUE;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    int currMax = height(root.left) + height(root.right);
    if (currMax > max) max = currMax;
    currMax = diameterOfBinaryTree(root.left);
    if (currMax > max) max = currMax;
    currMax = diameterOfBinaryTree(root.right);
    if (currMax > max) max = currMax;

    return max;
  }

  public static void main(String[] args) {
    DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
            new TreeNode(3, null, null));
    System.out.println(dbt.diameterOfBinaryTree(tree));
  }
}
