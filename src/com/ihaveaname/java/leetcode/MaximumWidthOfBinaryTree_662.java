package com.ihaveaname.java.leetcode;

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree_662 {
  class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      int max = Integer.MIN_VALUE;
      var queue = new LinkedList<TreeNode>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        boolean meetNotNull = false;
        int count = 0;
        int nullCount = 0;
        int length = queue.size();
        for (int i = 0; i < length; i++) {
          TreeNode n = queue.poll();
          if (n == null && meetNotNull) {
            queue.offer(null);
            queue.offer(null);
            nullCount++;
          } else if (n != null) {
            queue.offer(n.left);
            queue.offer(n.right);
            count++;
            if (!meetNotNull) meetNotNull = true;
            else {
              count += nullCount;
              nullCount = 0;
            }
          }
        }

        if (!meetNotNull) break;

        if (count > max) max = count;
      }
      return max;
    }
  }

  public static void main(String[] args) {
    MaximumWidthOfBinaryTree_662 maximumWIdthOfBinaryTree_662 = new MaximumWidthOfBinaryTree_662();
    Solution solution = maximumWIdthOfBinaryTree_662.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9)));
    System.out.println(solution.widthOfBinaryTree(tree));

    tree = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), null);
    System.out.println(solution.widthOfBinaryTree(tree));

    tree = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
    System.out.println(solution.widthOfBinaryTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
            new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7))));
    System.out.println(solution.widthOfBinaryTree(tree));

    tree =
        new TreeNode(
            0,
            new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))),
            new TreeNode(0, new TreeNode(0, new TreeNode(0), null), null));
    System.out.println(solution.widthOfBinaryTree(tree));
  }
}
