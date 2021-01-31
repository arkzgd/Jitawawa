package com.ihaveaname.java.leetcode;

public class SumOfLeftLeaves {
  private int sum;

  public SumOfLeftLeaves() {
    sum = 0;
  }

  private void helper(TreeNode node) {
    if (node == null) return;

    if (node.left != null) {
      if (node.left.left == null && node.left.right == null) sum += node.left.val;
      helper(node.left);
    }
    helper(node.right);
  }

  public int sumOfLeftLeaves(TreeNode root) {
    helper(root);
    return sum;
  }

  public static void main(String[] args) {
    SumOfLeftLeaves soll = new SumOfLeftLeaves();

    TreeNode tree = new TreeNode(
      3,
      new TreeNode(9, null, null),
      new TreeNode(20,
        new TreeNode(15, null, null),
        new TreeNode(7, null, null))
    );

    System.out.println(soll.sumOfLeftLeaves(tree));
  }
}
