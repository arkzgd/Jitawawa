package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree_662 {
  class Solution {
    private List<int[]> list;

    private void helper(TreeNode root, int level, int index) {
      if (root != null) {
        if (level == list.size()) {
          int[] pair = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
          list.add(pair);
        }

        int[] pair = list.get(level);
        if (index < pair[0]) pair[0] = index;
        if (index > pair[1]) pair[1] = index;
        helper(root.left, level + 1, 2 * index + 1);
        helper(root.right, level + 1, 2 * index + 2);
      }
    }

    public int widthOfBinaryTree(TreeNode root) {
      list = new ArrayList<>();
      helper(root, 0, 0);
      int max = Integer.MIN_VALUE;
      for (int[] pair : list) {
        int len = pair[1] - pair[0] + 1;
        if (len > max) max = len;
      }
      return max;
    }
  }

  public static void main(String[] args) {
    MaximumWidthOfBinaryTree_662 maximumWIdthOfBinaryTree_662 = new MaximumWidthOfBinaryTree_662();
    Solution solution = maximumWIdthOfBinaryTree_662.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9)));
    System.out.println(solution.widthOfBinaryTree(tree));

    tree = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), null);
    System.out.println(solution.widthOfBinaryTree(tree));

    tree = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
    System.out.println(solution.widthOfBinaryTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
            new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7))));
    System.out.println(solution.widthOfBinaryTree(tree));

    tree =
        new TreeNode(
            0,
            new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))),
            new TreeNode(0, new TreeNode(0, new TreeNode(0), null), null));
    System.out.println(solution.widthOfBinaryTree(tree));
  }
}
