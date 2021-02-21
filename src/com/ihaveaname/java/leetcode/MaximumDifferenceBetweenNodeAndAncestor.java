package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDifferenceBetweenNodeAndAncestor {
  class Solution {
    private int max;

    private void helper(TreeNode root, List<Integer> soFar) {
      if (root != null) {
        for (Integer i : soFar) {
          if (Math.abs(root.val - i) > max) max = Math.abs(root.val - i);
        }
        soFar.add(root.val);
        helper(root.left, soFar);
        helper(root.right, soFar);
        soFar.remove(soFar.size() - 1);
      }
    }

    public int maxAncestorDiff(TreeNode root) {
      max = Integer.MIN_VALUE;
      helper(root, new ArrayList<>());
      return max;
    }
  }

  public static void main(String[] args) {
    MaximumDifferenceBetweenNodeAndAncestor maximumDifferenceBetweenNodeAndAncestor =
        new MaximumDifferenceBetweenNodeAndAncestor();
    Solution solution = maximumDifferenceBetweenNodeAndAncestor.new Solution();

    TreeNode tree =
        new TreeNode(
            8,
            new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
            new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
    System.out.println(solution.maxAncestorDiff(tree));

    tree = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
    System.out.println(solution.maxAncestorDiff(tree));
  }
}
