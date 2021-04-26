package com.ihaveaname.java.leetcode;

public class SmallestStringStartingFromLeaf_988 {
  class Solution {
    private String result;

    private void helper(TreeNode root, StringBuilder sb) {
      if (root != null) {
        sb.insert(0, (char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
          if (result == null || result.compareTo(sb.toString()) > 0) {
            result = sb.toString();
          }
        }
        helper(root.left, sb);
        helper(root.right, sb);
        sb.deleteCharAt(0);
      }
    }

    public String smallestFromLeaf(TreeNode root) {
      result = null;
      StringBuilder sb = new StringBuilder();
      helper(root, sb);

      return result;
    }
  }

  public static void main(String[] args) {
    SmallestStringStartingFromLeaf_988 smallestStringStartingFromLeaf_988 =
        new SmallestStringStartingFromLeaf_988();
    Solution solution = smallestStringStartingFromLeaf_988.new Solution();

    TreeNode tree =
        new TreeNode(
            0,
            new TreeNode(1, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(3), new TreeNode(4)));
    System.out.println(solution.smallestFromLeaf(tree));

    tree =
        new TreeNode(
            25,
            new TreeNode(1, new TreeNode(1), new TreeNode(3)),
            new TreeNode(3, new TreeNode(0), new TreeNode(2)));
    System.out.println(solution.smallestFromLeaf(tree));

    tree =
        new TreeNode(
            2,
            new TreeNode(2, null, new TreeNode(1, new TreeNode(0), null)),
            new TreeNode(1, new TreeNode(0), null));
    System.out.println(solution.smallestFromLeaf(tree));

    tree = new TreeNode(0, null, new TreeNode(1));
    System.out.println(solution.smallestFromLeaf(tree));

    tree =
        new TreeNode(
            25,
            new TreeNode(
                1, new TreeNode(0, new TreeNode(1, new TreeNode(0), null), null), new TreeNode(0)),
            null);
    System.out.println(solution.smallestFromLeaf(tree));
  }
}
