package com.ihaveaname.java.leetcode;

public class LowestCommonAncestorOfDeepestLeaves {
  class Solution {
    private TreeNode ans;
    private int deepest; // deepest leaves' level so far
    private int longest; // highest subtree eligible (left tree height == right tree height)

    private int helper(TreeNode root, int level) {
      if (root != null) {
        int lh = helper(root.left, level + 1);
        int rh = helper(root.right, level + 1);

        // Update things only if:
        // 1) Found a eligible (lh == rh) subtree which is higher than currently eligible; Or,
        // 2) If found a deeper leaf node
        // Note: lh + level == deepest is necessary, because you don't like to update ans if
        // the subtree is actually of non-deepest leaves
        if (lh == rh && lh > longest && lh + level == deepest || level > deepest) {
          longest = lh;
          ans = root;
        }

        if (level > deepest) deepest = level;

        return Math.max(lh, rh) + 1;
      }

      return 0;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
      ans = null;
      deepest = -1;
      longest = -1;
      helper(root, 0);

      return ans;
    }
  }

  public static void main(String[] args) {
    LowestCommonAncestorOfDeepestLeaves lowestCommonAncestorOfDeepestLeaves =
        new LowestCommonAncestorOfDeepestLeaves();
    Solution solution = lowestCommonAncestorOfDeepestLeaves.new Solution();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
            new TreeNode(1, new TreeNode(0), new TreeNode(8)));
    assert solution.lcaDeepestLeaves(tree).val == 2;

    tree = new TreeNode(1);
    assert solution.lcaDeepestLeaves(tree).val == 1;

    tree = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
    assert solution.lcaDeepestLeaves(tree).val == 2;
  }
}
