package com.ihaveaname.java.leetcode;

import java.util.List;

public class DeepestLeavesSum {
  private int sum;
  private int max;

  public DeepestLeavesSum() {
    sum = 0;
    max = Integer.MIN_VALUE;
  }

  private void helper(TreeNode root, int depth) {
    if (root != null) {
      helper(root.left, depth + 1);
      helper(root.right, depth + 1);
      if (depth > max) {
        max = depth;
        sum = root.val;
      } else if (depth == max) {
        sum += root.val;
      }
    }
  }

  public int deepestLeavesSum(TreeNode root) {
    helper(root, 0);
    return sum;
  }

  public static void main(String[] args) {
    DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(
                2, new TreeNode(4, new TreeNode(7, null, null), null), new TreeNode(5, null, null)),
            new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8, null, null))));
    System.out.println(deepestLeavesSum.deepestLeavesSum(tree));
  }
}
