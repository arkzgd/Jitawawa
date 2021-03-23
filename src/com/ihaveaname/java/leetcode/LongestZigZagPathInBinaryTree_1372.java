package com.ihaveaname.java.leetcode;

public class LongestZigZagPathInBinaryTree_1372 {
  class Solution {
    private int max;

    private int dfs(TreeNode root, TreeNode parent) {
      if (root != null) {
        int ll;
        if (root == parent.right && root.left != null) {
          ll = dfs(root.left, root) + 1;
        } else ll = 0;

        int rl;
        if (root == parent.left && root.right != null) {
          rl = dfs(root.right, root) + 1;
        } else rl = 0;

        if (Math.max(ll, rl) > max) {
          max = Math.max(ll, rl);
        }

        return Math.max(ll, rl);
      }

      return 0;
    }

    public int longestZigZag(TreeNode root) {
      max = Integer.MIN_VALUE;
      max = Math.max(max, Math.max(dfs(root.left, root), dfs(root.right, root)));
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
                2,
                new TreeNode(3),
                new TreeNode(
                    4,
                    new TreeNode(5, null, new TreeNode(7, null, new TreeNode(8))),
                    new TreeNode(6))));
    System.out.println(solution.longestZigZag(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(
                2, null, new TreeNode(4, new TreeNode(5, null, new TreeNode(7)), new TreeNode(6))),
            new TreeNode(3));
    System.out.println(solution.longestZigZag(tree));

    tree = new TreeNode(1);
    System.out.println(solution.longestZigZag(tree));
  }
}
