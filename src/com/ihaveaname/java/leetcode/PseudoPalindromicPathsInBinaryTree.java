package com.ihaveaname.java.leetcode;

public class PseudoPalindromicPathsInBinaryTree {
  class Solution {
    private void helper(TreeNode root, int k) {
      if (root != null) {
        k ^= 1 << root.val;
        if (root.left == null && root.right == null) {
          if ((k & k - 1) == 0) count++;
        } else {
          helper(root.left, k);
          helper(root.right, k);
        }
      }
    }

    private int count;

    public int pseudoPalindromicPaths(TreeNode root) {
      count = 0;
      helper(root, 0);
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
    assert solution.pseudoPalindromicPaths(tree) == 2;

    tree =
        new TreeNode(
            2,
            new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1))),
            new TreeNode(1));
    assert solution.pseudoPalindromicPaths(tree) == 1;

    tree = new TreeNode(1);
    assert solution.pseudoPalindromicPaths(tree) == 1;
  }
}
