package com.ihaveaname.java.leetcode;

public class CountNodes {
  private static int height(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }

  private static int count(TreeNode root) {
    if (root == null) return 0;

    int lh = height(root.left);
    int rh = height(root.right);
    if (lh == rh) return (1 << lh) + count(root.right);
    else return (1 << rh) + count(root.left);
  }

  private static int solution(TreeNode root) {
    return count(root);
  }

  public static void main(String[] args) {
    TreeNode root =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
            new TreeNode(3, new TreeNode(6, null, null), null));
    System.out.println(solution(root));
  }
}
