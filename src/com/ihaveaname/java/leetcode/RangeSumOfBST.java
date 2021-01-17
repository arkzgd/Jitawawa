package com.ihaveaname.java.leetcode;

public class RangeSumOfBST {
  public int rangeSumBST(TreeNode root, int low, int high) {
    int cnt = 0;
    for (int i = low; i <= high; i++) cnt = search(root, i, cnt);
    return cnt;
  }

  private int search(TreeNode root, int t, int cnt) {
    if (root == null) return cnt;
    if (t == root.val) return cnt + t;
    else if (t > root.val) return search(root.right, t, cnt);
    else return search(root.left, t, cnt);
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
