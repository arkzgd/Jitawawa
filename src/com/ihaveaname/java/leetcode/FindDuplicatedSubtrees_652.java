package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicatedSubtrees_652 {
  class Solution {
    private Set<TreeNode> subtrees;
    private List<TreeNode> result;

    private void helper(TreeNode root) {
      if (root != null) {
        helper(root.left);
        helper(root.right);

        boolean skip = false;
        for (TreeNode t : subtrees) {
          if (sameTree(t, root)) {
            skip = true;
          }
        }

        if (!skip) {
          subtrees.add(root);
        }
      }
    }

    private boolean sameTree(TreeNode root1, TreeNode root2) {
      if (root1 == null && root2 == null) return true;
      if (root1 != null && root2 != null) {
        return (root1.val == root2.val
            && sameTree(root1.left, root2.left)
            && sameTree(root1.right, root2.right));
      }

      return false;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      subtrees = new HashSet<>();
      helper(root);

      result = new ArrayList<>();
      for (TreeNode s : subtrees) result.add(s);

      return result;
    }
  }

  public static void main(String[] args) {
    FindDuplicatedSubtrees_652 findDuplicatedSubtrees_652 = new FindDuplicatedSubtrees_652();
    Solution solution = findDuplicatedSubtrees_652.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
    System.out.println(solution.findDuplicateSubtrees(tree));
  }
}
