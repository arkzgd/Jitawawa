package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class FindBottomLeftTreeValue {
  class Solution {
    private int maxLevel;
    private int maxLeftness;
    private TreeNode ans;

    private void helper(TreeNode root, TreeNode parent, int level, int leftness) {
      if (root != null) {
        helper(root.left, root, level + 1, leftness + 1);
        helper(root.right, root, level + 1, leftness - 1);

        if (level > maxLevel) {
          maxLevel = level;
          maxLeftness = Integer.MIN_VALUE;
        }

        if (level == maxLevel && leftness > maxLeftness) {
          maxLeftness = leftness;
          if (root.left == null && root.right == null) ans = root;
        }
      }
    }

    public int findBottomLeftValue(TreeNode root) {
      maxLevel = Integer.MIN_VALUE;
      maxLeftness = Integer.MIN_VALUE;
      ans = null;

      helper(root, null, 1, 0);

      return ans.val;
    }
  }

  public static void main(String[] args) {
    FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
    Solution solution = findBottomLeftTreeValue.new Solution();

    TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    assert solution.findBottomLeftValue(tree) == 1;

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
    assert solution.findBottomLeftValue(tree) == 7;
  }
}
