package com.ihaveaname.java.leetcode;

import java.util.*;

public class PathSumIII_437 {
  class Solution {
    private int count;
    private Map<TreeNode, List<Integer>> dp;

    public void helper(TreeNode root, int targetSum) {
      if (root != null) {
        helper(root.left, targetSum);
        helper(root.right, targetSum);

        if (!dp.containsKey(root)) {
          dp.put(root, new LinkedList<>());
        }

        dp.get(root).add(root.val);

        if (root.left != null) {
          for (Integer i : dp.get(root.left)) dp.get(root).add(i + root.val);
        }
        if (root.right != null) {
          for (Integer i : dp.get(root.right)) dp.get(root).add(i + root.val);
        }

        for (Integer i : dp.get(root)) {
          if (i == targetSum) count++;
        }
      }
    }

    public int pathSum(TreeNode root, int targetSum) {
      count = 0;
      dp = new HashMap<>();
      helper(root, targetSum);
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
