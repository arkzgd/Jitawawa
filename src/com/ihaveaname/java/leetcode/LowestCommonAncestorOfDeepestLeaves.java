package com.ihaveaname.java.leetcode;

public class LowestCommonAncestorOfDeepestLeaves {
  class Solution {
    private int maxLevel;
    TreeNode ans;

    private void helper(TreeNode treeRoot, TreeNode root, int level) {
      if (root != null) {
        helper(treeRoot, root.left, level + 1);
        helper(treeRoot, root.right, level + 1);
        if (root.left == null && root.right == null) {
          if (level > maxLevel) {
            ans = root;
            maxLevel = level;
          } else if (level == maxLevel) {
            reachable(treeRoot, root, ans);
          }
        }
      }
    }

    private int reachable(TreeNode s, TreeNode p, TreeNode q) {
      if (s != null) {
        int left = reachable(s.left, p, q) == 1 ? 1 : 0;
        int right = reachable(s.right, p, q) == 1 ? 1 : 0;
        int mid = s.val == p.val && s.val == q.val ? 2 : s.val == p.val || s.val == q.val ? 1 : 0;

        if (left + right + mid == 2) {
          ans = s;
          return 2;
        } else return left + right + mid;
      }

      return 0;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
      maxLevel = -1;
      ans = null;

      helper(root, root, 0);
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
    System.out.println(solution.lcaDeepestLeaves(tree).val);

    tree = new TreeNode(1);
    System.out.println(solution.lcaDeepestLeaves(tree).val);

    tree = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
    System.out.println(solution.lcaDeepestLeaves(tree).val);
  }
}
