package com.ihaveaname.java.leetcode;

public class SumOfRootToLeafBinaryNumbers {
  private int sum;

  public SumOfRootToLeafBinaryNumbers() {
    sum = 0;
  }

  private void helper(TreeNode root, int sofar) {
    if (root != null) {
      helper(root.left, (sofar << 1) | root.val);
      helper(root.right, (sofar << 1) | root.val);
      if (root.left == null && root.right == null) {
        sum += (sofar << 1) + root.val;
      }
    }
  }

  public int sumRootToLeaf(TreeNode root) {
    helper(root, 0);
    return sum;
  }

  public static void main(String[] args) {
    SumOfRootToLeafBinaryNumbers srtbn = new SumOfRootToLeafBinaryNumbers();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null)),
            new TreeNode(1, new TreeNode(0, null, null), new TreeNode(1, null, null)));

    System.out.println(srtbn.sumRootToLeaf(tree));
  }
}
