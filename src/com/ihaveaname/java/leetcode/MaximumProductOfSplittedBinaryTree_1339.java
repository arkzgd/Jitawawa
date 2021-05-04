package com.ihaveaname.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfSplittedBinaryTree_1339 {
  class Solution {
    private Map<TreeNode, Long> map;
    private TreeNode treeRoot;
    private long max;

    private long dp(TreeNode node) {
      if (node != null) {
        if (!map.containsKey(node)) {
          var sum = dp(node.left) + dp(node.right);
          map.put(node, sum + node.val);
        }

        return map.get(node);
      } else return 0;
    }

    private void helper(TreeNode root) {
      if (root != null) {
        if (root != treeRoot) {
          long sum1 = dp(treeRoot);
          long sum2 = dp(root);
          max = Math.max((sum1 - sum2) * sum2, max);
        }
        helper(root.left);
        helper(root.right);
      }
    }

    public int maxProduct(TreeNode root) {
      treeRoot = root;
      map = new HashMap<>(50000, 0.75f);
      max = 0;
      helper(root);
      return (int) (max % (1e9 + 7));
    }
  }

  public static void main(String[] args) {
    MaximumProductOfSplittedBinaryTree_1339 maximumProductOfSplittedBinaryTree_1339 =
        new MaximumProductOfSplittedBinaryTree_1339();
    Solution solution = maximumProductOfSplittedBinaryTree_1339.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));
    System.out.println(solution.maxProduct(tree));

    tree =
        new TreeNode(
            1,
            null,
            new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6))));
    System.out.println(solution.maxProduct(tree));

    tree = new TreeNode(1, new TreeNode(1), null);
    System.out.println(solution.maxProduct(tree));

    tree =
        new TreeNode(
            2,
            new TreeNode(
                3,
                new TreeNode(10, new TreeNode(5), new TreeNode(4)),
                new TreeNode(7, new TreeNode(11), new TreeNode(1))),
            new TreeNode(9, new TreeNode(8), new TreeNode(6)));
    System.out.println(solution.maxProduct(tree));
  }
}
