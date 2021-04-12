package com.ihaveaname.java.leetcode;

public class HouseRobberIII_337 {
  class Solution {
    private int dp(TreeNode root, boolean parentRobbed) {
      if (root != null) {
        if (parentRobbed) return dp(root.left, false) + dp(root.right, false);
        else {
          return Math.max(
              root.val + dp(root.left, true) + dp(root.right, true),
              dp(root.left, false) + dp(root.right, false));
        }
      }

      return 0;
    }

    public int rob(TreeNode root) {
      return dp(root, false);
    }
  }

  public static void main(String args[]) {
    HouseRobberIII_337 houseRobberIII_337 = new HouseRobberIII_337();
    Solution solution = houseRobberIII_337.new Solution();

    TreeNode tree =
        new TreeNode(
            3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
    System.out.println(solution.rob(tree));

    tree =
        new TreeNode(
            3,
            new TreeNode(4, new TreeNode(1), new TreeNode(3)),
            new TreeNode(5, null, new TreeNode(1)));
    System.out.println(solution.rob(tree));
  }
}
