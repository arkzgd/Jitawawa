package com.ihaveaname.java.leetcode;

public class SumRootToLeafNumbers_129 {
  class Solution {
    int result;

    private int sum(int[] soFar, int level) {
      int sum = 0;
      for (int i = level; i >= 0; i--) {
        sum += soFar[i] * Math.pow(10, level - i);
      }

      return sum;
    }

    private void helper(TreeNode root, int level, int[] soFar) {
      if (root != null) {
        if (root.left == null && root.right == null) {
          soFar[level] = root.val;
          result += sum(soFar, level);
        } else {
          soFar[level] = root.val;
          helper(root.left, level + 1, soFar);
          helper(root.right, level + 1, soFar);
        }
      }
    }

    public int sumNumbers(TreeNode root) {
      result = 0;
      int[] soFar = new int[10];

      helper(root, 0, soFar);

      return result;
    }
  }

  public static void main(String[] args) {
    SumRootToLeafNumbers_129 sumRootToLeafNumbers_129 = new SumRootToLeafNumbers_129();
    Solution solution = sumRootToLeafNumbers_129.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(solution.sumNumbers(tree));

    tree = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
    System.out.println(solution.sumNumbers(tree));
  }
}
