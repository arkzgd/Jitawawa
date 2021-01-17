package com.ihaveaname.java.leetcode;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;

    if (root.left == null && root.right == null && sum - root.val == 0) return true;

    if (hasPathSum(root.left, sum - root.val)) return true;
    if (hasPathSum(root.right, sum - root.val)) return true;

    return false;
  }

  public static void main(String[] args) {
    PathSum ps = new PathSum();

    TreeNode tree =
        new TreeNode(
            5,
            new TreeNode(
                4,
                new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)),
                null),
            new TreeNode(
                8,
                new TreeNode(13, null, null),
                new TreeNode(4, null, new TreeNode(1, null, null))));
    System.out.println(ps.hasPathSum(tree, 22));

    tree = new TreeNode(1, new TreeNode(2, null, null), null);
    System.out.println(ps.hasPathSum(tree, 1));
  }
}
