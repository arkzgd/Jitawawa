package com.ihaveaname.java.leetcode;

public class MaximumDifferenceBetweenNodeAndAncestor {
  class Solution {
    private int helper(TreeNode root, int min, int max) {
      if (root != null) {
        if (root.val > max) max = root.val;
        if (root.val < min) min = root.val;
        if (root.left == null && root.right == null) return max - min;
        else return Math.max(helper(root.left, min, max), helper(root.right, min, max));
      }

      return 0;
    }

    public int maxAncestorDiff(TreeNode root) {
      return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
  }

  public static void main(String[] args) {
    MaximumDifferenceBetweenNodeAndAncestor maximumDifferenceBetweenNodeAndAncestor =
        new MaximumDifferenceBetweenNodeAndAncestor();
    Solution solution = maximumDifferenceBetweenNodeAndAncestor.new Solution();

    TreeNode tree =
        new TreeNode(
            8,
            new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
            new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
    System.out.println(solution.maxAncestorDiff(tree));

    tree = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
    System.out.println(solution.maxAncestorDiff(tree));

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(100));
    System.out.println(solution.maxAncestorDiff(tree));
  }
}
