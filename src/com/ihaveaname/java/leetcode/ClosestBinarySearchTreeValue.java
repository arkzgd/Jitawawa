package com.ihaveaname.java.leetcode;

public class ClosestBinarySearchTreeValue {
  private Double max = Double.MAX_VALUE;
  private int closest = Integer.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {
    while (root != null) {
      if (Math.abs(target - (double) root.val) < max) {
        max = Math.abs(target - (double) root.val);
        closest = root.val;
      }
      if (root.val > target) root = root.left;
      else root = root.right;
    }

    return closest;
  }

  public static void main(String[] args) {
    ClosestBinarySearchTreeValue cbstv = new ClosestBinarySearchTreeValue();

    TreeNode tree =
      new TreeNode(
        6,
        new TreeNode(
          2,
          new TreeNode(0, null, null),
          new TreeNode(4, new TreeNode(3, null, null), new TreeNode(5, null, null))),
        new TreeNode(8, new TreeNode(7, null, null), new TreeNode(9, null, null)));

    System.out.println(cbstv.closestValue(tree,3.145926));

    cbstv.max = Double.MAX_VALUE;
    System.out.println(cbstv.closestValue(tree,-3.145926));
  }
}
