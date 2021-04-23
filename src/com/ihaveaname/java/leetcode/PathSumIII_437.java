package com.ihaveaname.java.leetcode;

public class PathSumIII_437 {
  class Solution {
    public int pathSum(TreeNode root, int targetSum) {
      return -1;
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
  }
}
