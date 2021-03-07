package com.ihaveaname.java.leetcode;

public class MaximunBinaryTreeII {
  class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
      if (root != null) {
        if (val > root.val) {
          TreeNode node = new TreeNode(val);
          node.left = root;
          return node;
        } else root.right = insertIntoMaxTree(root.right, val);
      } else {
        root = new TreeNode(val);
      }

      return root;
    }
  }

  public static void main(String[] args) {
    MaximunBinaryTreeII maximunBinaryTreeII = new MaximunBinaryTreeII();
    Solution solution = maximunBinaryTreeII.new Solution();

    TreeNode tree = new TreeNode(4, new TreeNode(1), new TreeNode(3, new TreeNode(2), null));
    tree = solution.insertIntoMaxTree(tree, 5);
    System.out.println(tree.val);

    tree = new TreeNode(5, new TreeNode(2, null, new TreeNode(1)), new TreeNode(4));
    tree = solution.insertIntoMaxTree(tree, 3);
    System.out.println(tree.val);

    tree = new TreeNode(5, new TreeNode(2, null, new TreeNode(1)), new TreeNode(3));
    tree = solution.insertIntoMaxTree(tree, 4);
    System.out.println(tree.val);
  }
}
