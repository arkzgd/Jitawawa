package com.ihaveaname.java.leetcode;

public class BinaryTreeTilt {
  private int sum;

  public BinaryTreeTilt() {
    sum = 0;
  }

  private int helper(TreeNode root) {
    if (root == null) return 0;
    int lsum = helper(root.left);
    int rsum = helper(root.right);
    sum += Math.abs(lsum - rsum);
    return  lsum + rsum + root.val;
  }

  public int findTilt(TreeNode root) {
    helper(root);

    return sum;
  }

  public static void main(String[] args) {
    BinaryTreeTilt btt = new BinaryTreeTilt();

    TreeNode tree = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    System.out.println(btt.findTilt(tree));
  }
}
