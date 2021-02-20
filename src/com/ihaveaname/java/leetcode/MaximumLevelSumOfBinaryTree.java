package com.ihaveaname.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumLevelSumOfBinaryTree {
  class Solution {
    public int maxLevelSum(TreeNode root) {
      int currLevel = 0;
      int minLevel = 0;
      int maxSum = Integer.MIN_VALUE;
      Deque<TreeNode> queue = new LinkedList<>();
      if (root != null) queue.offer(root);

      while (!queue.isEmpty()) {
        currLevel++;
        int count = 0;
        int sum = 0;
        int len = queue.size();
        while (count++ < len) {
          TreeNode n = queue.poll();
          sum += n.val;
          if (n.left != null) queue.offer(n.left);
          if (n.right != null) queue.offer(n.right);
        }
        if (sum > maxSum) {
          maxSum = sum;
          minLevel = currLevel;
        }
      }

      return minLevel;
    }
  }

  public static void main(String[] args) {
    MaximumLevelSumOfBinaryTree maximumLevelSumOfBinaryTree = new MaximumLevelSumOfBinaryTree();
    Solution solution = maximumLevelSumOfBinaryTree.new Solution();

    TreeNode tree =
        new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
    System.out.println(solution.maxLevelSum(tree));

    tree =
        new TreeNode(
            989,
            null,
            new TreeNode(
                10250, new TreeNode(98963), new TreeNode(-89388, null, new TreeNode(-32127))));
    System.out.println(solution.maxLevelSum(tree));
  }
}
