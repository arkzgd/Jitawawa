package com.ihaveaname.java.leetcode;

public class RangeSumOfBST {
  private int cnt;

  public int rangeSumBST(TreeNode root, int low, int high) {
    cnt = 0;
    inOrder(root, low, high);
    return cnt;
  }

  private void inOrder(TreeNode root, int low, int high) {
    if (root == null) return;
    if (root.val > low) inOrder(root.left, low, high);
    if (root.val >= low && root.val <= high) cnt += root.val;
    if (root.val < high) inOrder(root.right, low, high);
  }

  public static void main(String[] args) {
    RangeSumOfBST rsb = new RangeSumOfBST();

    TreeNode tree =
        new TreeNode(
            10,
            new TreeNode(5, new TreeNode(3, null, null), new TreeNode(7, null, null)),
            new TreeNode(15, null, new TreeNode(18, null, null)));
    assert rsb.rangeSumBST(tree, 7, 15) == 32;

    tree =
        new TreeNode(
            10,
            new TreeNode(
                5,
                new TreeNode(3, new TreeNode(1, null, null), null),
                new TreeNode(7, new TreeNode(6, null, null), null)),
            new TreeNode(15, new TreeNode(13, null, null), new TreeNode(18, null, null)));
    assert rsb.rangeSumBST(tree, 6, 10) == 23;
  }
}
