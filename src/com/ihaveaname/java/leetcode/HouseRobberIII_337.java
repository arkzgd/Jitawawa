package com.ihaveaname.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII_337 {
  class Solution {
    private Map<TreeNode, Integer> trueMap;
    private Map<TreeNode, Integer> falseMap;

    private int dp(TreeNode root, boolean parentRobbed) {
      if (parentRobbed && trueMap.containsKey(root)) return trueMap.get(root);
      if (!parentRobbed && falseMap.containsKey(root)) return falseMap.get(root);
      if (root != null) {
        if (parentRobbed) {
          int v = dp(root.left, false) + dp(root.right, false);
          trueMap.put(root, v);
          return v;
        } else {
          int trueV = dp(root.left, true) + dp(root.right, true);
          int falseV = dp(root.left, false) + dp(root.right, false);
          int v = Math.max(root.val + trueV, falseV);
          falseMap.put(root, v);
          return v;
        }
      }

      return 0;
    }

    public int rob(TreeNode root) {
      trueMap = new HashMap<>();
      falseMap = new HashMap<>();
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
