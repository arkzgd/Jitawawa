package com.ihaveaname.java.leetcode;

public class LongestZigZagPathInBinaryTree_1372 {
  class Solution {
    private int max;

    private int[] dfs(TreeNode root, TreeNode parent, int flag) {
      if (root != null) {
        int[] ll = dfs(root.left, root, -flag);
        int[] rl = dfs(root.right, root, -flag);
      }

      return new int[]{0, 0};
    }

    public int longestZigZag(TreeNode root) {
      max = Integer.MIN_VALUE;
      dfs(root, null,-1);
      dfs(root, null, 1);

      return max;
    }
  }

  public static void main(String[] args) {
    LongestZigZagPathInBinaryTree_1372 longestZigZagPathInBinaryTree_1372 =
        new LongestZigZagPathInBinaryTree_1372();
    Solution solution = longestZigZagPathInBinaryTree_1372.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            null,
            new TreeNode(
                1,
                new TreeNode(1),
                new TreeNode(
                    1,
                    new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))),
                    new TreeNode(1))));
    System.out.println(solution.longestZigZag(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(
                2, null, new TreeNode(4, new TreeNode(5, null, new TreeNode(7)), new TreeNode(6))),
            new TreeNode(3));
    System.out.println(solution.longestZigZag(tree));
  }
}
