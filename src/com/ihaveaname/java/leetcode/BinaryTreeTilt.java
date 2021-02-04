package com.ihaveaname.java.leetcode;

public class BinaryTreeTilt {
  private int sum(TreeNode root) {
    if (root == null) return 0;
    return sum(root.left) + sum(root.right) + root.val;
  }

  public int findTilt(TreeNode root) {
    if (root == null) return 0;

    int lsum = sum(root.left);
    int rsum = sum(root.right);
    return Math.abs(lsum - rsum) + findTilt(root.left) + findTilt(root.right);
  }

  public static void main(String[] args) {
    BinaryTreeTilt btt = new BinaryTreeTilt();

    TreeNode tree = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    System.out.println(btt.findTilt(tree));
  }
}
