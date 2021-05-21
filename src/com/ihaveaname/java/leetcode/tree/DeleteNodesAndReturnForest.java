package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest {
  class Solution {
    private boolean[] toDelete;
    private List<TreeNode> result;

    private void helper(TreeNode root, TreeNode parent) {
      if (root != null) {
        helper(root.left, root);
        helper(root.right, root);

        if (toDelete[root.val]) {
          if (parent != null) {
            if (parent.left == root) parent.left = null;
            if (parent.right == root) parent.right = null;
          }

          if (root.left != null) result.add(root.left);
          if (root.right != null) result.add(root.right);
        } else if (parent == null) result.add(root);
      }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      result = new ArrayList<>();
      toDelete = new boolean[1001];
      for (int i : to_delete) toDelete[i] = true;

      helper(root, null);
      return result;
    }
  }

  public static void main(String[] args) {
    DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
    Solution solution = deleteNodesAndReturnForest.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    int[] toDelete = new int[] {3, 5};
    System.out.println(solution.delNodes(tree, toDelete));

    tree =
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(4), new TreeNode(3)),
        null
      );
    toDelete = new int[]{2, 3};
    System.out.println(solution.delNodes(tree, toDelete));
  }
}
