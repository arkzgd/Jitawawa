package com.ihaveaname.java.leetcode;

public class SmallestSubtreeWithAllTheDeepestNodes {
  class Solution {
    private TreeNode ans;
    private int deepest;

    private int helper(TreeNode root, int level) {
      if (root != null) {
        int lh = helper(root.left, level + 1);
        int rh = helper(root.right, level + 1);
        if (lh == rh) {
          if (level > deepest) {
            ans = root;
            deepest = level;
          }

          return lh + 1;
        } else return Math.max(lh, rh) + 1;
      }

      return 0;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
      ans = null;
      deepest = -1;
      helper(root, 0);

      return ans;
    }
  }

  public static void main(String[] args) {
    SmallestSubtreeWithAllTheDeepestNodes smallestSubtreeWithAllTheDeepestNodes =
        new SmallestSubtreeWithAllTheDeepestNodes();
    Solution solution = smallestSubtreeWithAllTheDeepestNodes.new Solution();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
            new TreeNode(1, new TreeNode(0), new TreeNode(8)));
    System.out.println(solution.subtreeWithAllDeepest(tree).val);

//    tree = new TreeNode(1);
//    System.out.println(solution.subtreeWithAllDeepest(tree).val);

    tree = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
    System.out.println(solution.subtreeWithAllDeepest(tree).val);
  }
}
