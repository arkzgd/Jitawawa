package com.ihaveaname.java.leetcode;

import java.util.*;

public class PathSumIII_437 {
  class Solution {
    private int count;
    private Map<Integer, Integer> dp;

    public void helper(TreeNode root, int curSum, int targetSum) {
      if (root != null) {
        curSum += root.val;
        int target =
            curSum
                - targetSum; // Why it is not targetSum - curSum? Because curSum is the sum of
                             // elements seen so far
        count += dp.getOrDefault(target, 0);
        dp.put(curSum, dp.getOrDefault(curSum, 0) + 1);
        helper(root.left, curSum, targetSum);
        helper(root.right, curSum, targetSum);
        dp.put(curSum, dp.get(curSum) - 1);
      }
    }

    public int pathSum(TreeNode root, int targetSum) {
      count = 0;
      dp = new HashMap<>();
      dp.put(0, 1);
      helper(root, 0, targetSum);
      return count;
    }
  }

  public static void main(String[] args) {
    PathSumIII_437 pathSumIII_437 = new PathSumIII_437();
    Solution solution = pathSumIII_437.new Solution();

    TreeNode tree =
        new TreeNode(
            10,
            new TreeNode(
                5,
                new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                new TreeNode(2, null, new TreeNode(1))),
            new TreeNode(-3, null, new TreeNode(11)));
    System.out.println(solution.pathSum(tree, 8));

    tree =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
    System.out.println(solution.pathSum(tree, 22));

    tree =
        new TreeNode(
            1,
            new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
            new TreeNode(-3, new TreeNode(-2), null));
    System.out.println(solution.pathSum(tree, -1));
  }
}
