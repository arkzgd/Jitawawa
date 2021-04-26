package com.ihaveaname.java.leetcode;

public class SmallestStringStartingFromLeaf_988 {
  class Solution {
    public String smallestFromLeaf(TreeNode root) {
      if (root != null) {
        StringBuilder lrsb = new StringBuilder();
        String lr =
            lrsb.append(smallestFromLeaf(root.left)).append((char) ('a' + root.val)).toString();
        StringBuilder rrsb = new StringBuilder();
        String rr =
            rrsb.append(smallestFromLeaf(root.right)).append((char) ('a' + root.val)).toString();
        if (java.lang.CharSequence.compare(lr, rr) >= 0) {
          if (rr.length() > 1) return rr;
          else return lr;
        } else {
          if (lr.length() > 1) return lr;
          else return rr;
        }
      }

      return "";
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
  }
}
