package com.ihaveaname.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckCompletenessOfBinaryTree_958 {
  class Solution {
    private Map<TreeNode, Integer> heights;

    private int height(TreeNode root) {
      if (root != null) {
        if (heights.containsKey(root)) return heights.get(root);
        else {
          heights.put(root, Math.max(height(root.left), height(root.right)) + 1);
          return heights.get(root);
        }
      }

      return 0;
    }

    private boolean isFullTree(TreeNode root) {
      if (root != null) {
        boolean lr = isFullTree(root.left);
        if (!lr) return false;
        boolean rr = isFullTree(root.right);
        if (!rr) return false;
        return height(root.left) == height(root.right);
      }

      return true;
    }

    private boolean helper(TreeNode root) {
      if (root != null) {
        boolean lr = helper(root.left);
        if (!lr) return false;
        boolean rr = helper(root.right);
        if (!rr) return false;

        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == rh) return isFullTree(root.left) && isCompleteTree(root.right);
        else if (lh == rh + 1) return isCompleteTree(root.left) && isFullTree(root.right);
        else return false;
      }

      return true;
    }

    public boolean isCompleteTree(TreeNode root) {
      heights = new HashMap<>();
      return helper(root);
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
