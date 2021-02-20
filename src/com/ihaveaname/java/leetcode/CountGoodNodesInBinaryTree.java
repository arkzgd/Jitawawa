package com.ihaveaname.java.leetcode;

public class CountGoodNodesInBinaryTree {
  class Solution {
    private int count;

    private void helper(TreeNode root, int maxSoFar) {
      if (root != null) {
        if (root.val >= maxSoFar) {
          maxSoFar = root.val;
          count++;
        }

        helper(root.left, maxSoFar);
        helper(root.right, maxSoFar);
      }
    }

    public int goodNodes(TreeNode root) {
      count = 0;
      helper(root, Integer.MIN_VALUE);
      return count;
    }
  }

  public static void main(String[] args) {
    CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();
    Solution solution = countGoodNodesInBinaryTree.new Solution();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(1, new TreeNode(3), null),
            new TreeNode(4, new TreeNode(1), new TreeNode(5)));
    System.out.println(solution.goodNodes(tree));

    tree = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
    System.out.println(solution.goodNodes(tree));

    tree = new TreeNode(1);
    System.out.println(solution.goodNodes(tree));
  }
}
