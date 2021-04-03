package com.ihaveaname.java.leetcode;

public class CheckCompletenessOfBinaryTree_958 {
  class Solution {
    public boolean isCompleteTree(TreeNode root) {
      return true;
    }
  }

  public static void main(String[] args) {
    CheckCompletenessOfBinaryTree_958 checkCompletenessOfBinaryTree_958 = new CheckCompletenessOfBinaryTree_958();
    Solution solution = checkCompletenessOfBinaryTree_958.new Solution();

    TreeNode tree =
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, new TreeNode(6), null)
      );
    System.out.println(solution.isCompleteTree(tree));

    tree =
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, null, new TreeNode(6))
      );
    System.out.println(solution.isCompleteTree(tree));

    tree =
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(5), null),
        new TreeNode(3, new TreeNode(7), new TreeNode(8))
      );
    System.out.println(solution.isCompleteTree(tree));

    tree =
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(5), null),
        new TreeNode(3)
      );
    System.out.println(solution.isCompleteTree(tree));
  }
}
