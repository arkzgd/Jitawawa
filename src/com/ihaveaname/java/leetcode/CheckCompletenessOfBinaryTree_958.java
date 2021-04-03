package com.ihaveaname.java.leetcode;

import java.util.*;

public class CheckCompletenessOfBinaryTree_958 {
  class Solution {
    private boolean checkResult(List<List<TreeNode>> result) {
      boolean seenNull = false;
      for (int level = 0; level < result.size() - 1; level++) {
        if (level < result.size() - 2
            && result.get(level).size() < (1 << level)
            && !result.get(level + 1).isEmpty()) return false;

        for (int l = 0; l < result.get(level).size(); l++) {
          if (result.get(level).get(l) == null) seenNull = true;
          else if (seenNull) return false;
        }
      }

      return true;
    }

    public boolean isCompleteTree(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      List<List<TreeNode>> result = new ArrayList<>();
      if (root != null) queue.offer(root);

      while (!queue.isEmpty()) {
        int size = queue.size();
        List<TreeNode> l = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          TreeNode n = queue.poll();
          l.add(n);
          if (n != null) {
            queue.offer(n.left);
            queue.offer(n.right);
          }
        }
        result.add(l);
      }

      return checkResult(result);
    }
  }

  public static void main(String[] args) {
    CheckCompletenessOfBinaryTree_958 checkCompletenessOfBinaryTree_958 =
        new CheckCompletenessOfBinaryTree_958();
    Solution solution = checkCompletenessOfBinaryTree_958.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));
    System.out.println(solution.isCompleteTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, null, new TreeNode(6)));
    System.out.println(solution.isCompleteTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(5), null),
            new TreeNode(3, new TreeNode(7), new TreeNode(8)));
    System.out.println(solution.isCompleteTree(tree));

    tree = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3));
    System.out.println(solution.isCompleteTree(tree));
  }
}
