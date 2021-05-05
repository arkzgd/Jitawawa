package com.ihaveaname.java.leetcode;

public class LongestUnivaluePath_687 {
  class Solution {
    private int max;

    public int helper(TreeNode root) {
      if (root != null) {
        int lc = 0;
        int rc = 0;
        if (root.left != null) {
          lc = helper(root.left);
          if (root.left.val == root.val) lc++;
          else lc = 0;
        }
        if (root.right != null) {
          rc = helper(root.right);
          if (root.right.val == root.val) rc++;
          else rc = 0;
        }
        if (root.left != null
            && root.right != null
            && root.left.val == root.val
            && root.right.val == root.val) {
          int sum = lc + rc;
          max = Math.max(max, sum);
        } else {
          if ((root.left == null || root.left.val != root.val)
              && root.right != null
              && root.right.val == root.val) {
            max = Math.max(max, rc);
          }
          if (root.left != null
              && (root.right == null || root.right.val != root.val)
              && root.left.val == root.val) {
            max = Math.max(max, lc);
          }
        }

        return Math.max(lc, rc);
      }

      return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
      max = 0;
      helper(root);

      return max;
    }
  }

  public static void main(String[] args) {
    LongestUnivaluePath_687 longestUnivaluePath_687 = new LongestUnivaluePath_687();
    Solution solution = longestUnivaluePath_687.new Solution();

    TreeNode tree =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(1), new TreeNode(1)),
            new TreeNode(5, null, new TreeNode(5)));
    System.out.println(solution.longestUnivaluePath(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(4, new TreeNode(4), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(5)));
    System.out.println(solution.longestUnivaluePath(tree));

    tree =
        new TreeNode(
            1,
            null,
            new TreeNode(
                1,
                new TreeNode(1, new TreeNode(1), new TreeNode(1)),
                new TreeNode(1, new TreeNode(1), null)));
    System.out.println(solution.longestUnivaluePath(tree));
  }
}
