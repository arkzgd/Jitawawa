package com.ihaveaname.java.leetcode;

public class PathSumIII_437 {
  class Solution {
    int count = 0;

    public void helper(TreeNode root, int targetSum) {
      if (root != null) {
        if (root.val == targetSum) count++;
        helper(root.left, targetSum - root.val);
        helper(root.right, targetSum - root.val);
      }
    }

    public int pathSum(TreeNode root, int targetSum) {
      if (root != null) {
        helper(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
      }

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

    solution.count = 0;
    tree =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
    System.out.println(solution.pathSum(tree, 22));

    solution.count = 0;
    tree =
        new TreeNode(
            1,
            new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
            new TreeNode(-3, new TreeNode(-2), null));
    System.out.println(solution.pathSum(tree, -1));
  }
}
