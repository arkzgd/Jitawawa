package com.ihaveaname.java.leetcode;

public class PseudoPalindromicPathsInBinaryTree {
  class Solution {
    private boolean isPseudoPalindromicPath(int[] result) {
      int count = 0;
      for (int i : result) {
        if (i != 0) count++;
      }

      return count <= 1;
    }

    private void helper(TreeNode root, int[] result) {
      if (root != null) {
        result[root.val - 1] ^= 1;
        if (root.left == null && root.right == null) {
          if (isPseudoPalindromicPath(result)) count++;
        } else {
          helper(root.left, result);
          helper(root.right, result);
        }
        // Because you are using int[] to record partial results, you have to
        // clean the effect of this recursive level before return to upper level
        result[root.val - 1] ^= 1;
      }
    }

    private int count;

    public int pseudoPalindromicPaths(TreeNode root) {
      count = 0;
      int[] result = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      helper(root, result);
      return count;
    }
  }

  public static void main(String[] args) {
    PseudoPalindromicPathsInBinaryTree pseudoPalindromicPathsInBinaryTree =
        new PseudoPalindromicPathsInBinaryTree();
    Solution solution = pseudoPalindromicPathsInBinaryTree.new Solution();

    TreeNode tree =
        new TreeNode(
            2,
            new TreeNode(3, new TreeNode(3, null, null), new TreeNode(1, null, null)),
            new TreeNode(1, null, new TreeNode(1, null, null)));
    System.out.println(solution.pseudoPalindromicPaths(tree));

    tree =
        new TreeNode(
            2,
            new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1))),
            new TreeNode(1));
    System.out.println(solution.pseudoPalindromicPaths(tree));

    tree = new TreeNode(1);
    System.out.println(solution.pseudoPalindromicPaths(tree));
  }
}
