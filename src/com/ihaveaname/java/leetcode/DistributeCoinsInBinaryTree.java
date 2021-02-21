package com.ihaveaname.java.leetcode;

public class DistributeCoinsInBinaryTree {
  class Solution {
    private int count;

    private int helper(TreeNode root) {
      if (root != null) {
        int fromLeft = helper(root.left);
        int fromRight = helper(root.right);
        count += Math.abs(fromLeft) + Math.abs(fromRight);
        return fromLeft + fromRight + root.val - 1;
      }

      return 0;
    }

    public int distributeCoins(TreeNode root) {
      count = 0;
      helper(root);
      return count;
    }
  }

  public static void main(String[] args) {
    DistributeCoinsInBinaryTree distributeCoinsInBinaryTree = new DistributeCoinsInBinaryTree();
    Solution solution = distributeCoinsInBinaryTree.new Solution();

    TreeNode tree = new TreeNode(3, new TreeNode(0), new TreeNode(0));
    System.out.println(solution.distributeCoins(tree));

    tree = new TreeNode(0, new TreeNode(3), new TreeNode(0));
    System.out.println(solution.distributeCoins(tree));

    tree = new TreeNode(1, new TreeNode(0), new TreeNode(2));
    System.out.println(solution.distributeCoins(tree));

    tree = new TreeNode(1, new TreeNode(0, null, new TreeNode(3)), new TreeNode(0));
    System.out.println(solution.distributeCoins(tree));

    tree = new TreeNode(4, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))), null);
    System.out.println(solution.distributeCoins(tree));
  }
}
