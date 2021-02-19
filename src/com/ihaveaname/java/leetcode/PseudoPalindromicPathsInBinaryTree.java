package com.ihaveaname.java.leetcode;

import java.util.*;

public class PseudoPalindromicPathsInBinaryTree {
  class Solution {
    private boolean isPseudoPalindromicPath(List<Integer> list) {
      Set<Integer> set = new HashSet<>();
      for (Integer e : list) {
        if (set.contains(e)) set.remove(e);
        else set.add(e);
      }

      if (set.size() == 0 && list.size() % 2 == 0 || set.size() == 1 && list.size() % 2 == 1)
        return true;
      return false;
    }

    private void helper(TreeNode root, List<Integer> result) {
      if (root != null) {
        if (root.left == null && root.right == null) {
          result.add(root.val);
          if (isPseudoPalindromicPath(result)) count++;
        } else {
          result.add(root.val);
          helper(root.left, result);
          helper(root.right, result);
        }
        result.remove(result.size() - 1);
      }
    }

    private int count;

    public int pseudoPalindromicPaths(TreeNode root) {
      count = 0;
      List<Integer> result = new LinkedList<>();
      helper(root, result);
      return count;
    }
  }

  public static void main(String[] args) {
    PseudoPalindromicPathsInBinaryTree pseudoPalindromicPathsInBinaryTree =
        new PseudoPalindromicPathsInBinaryTree();
    Solution solution = pseudoPalindromicPathsInBinaryTree.new Solution();

    TreeNode tree =
        new TreeNode(
            2,
            new TreeNode(3, new TreeNode(3, null, null), new TreeNode(1, null, null)),
            new TreeNode(1, null, new TreeNode(1, null, null)));
    System.out.println(solution.pseudoPalindromicPaths(tree));

    tree =
        new TreeNode(
            2,
            new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1))),
            new TreeNode(1));
    System.out.println(solution.pseudoPalindromicPaths(tree));

    tree = new TreeNode(1);
    System.out.println(solution.pseudoPalindromicPaths(tree));
  }
}
