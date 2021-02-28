package com.ihaveaname.java.leetcode;

public class TrimABST {
  class Solution {
    private TreeNode helper(TreeNode root, TreeNode parent, int low, int high) {
      if (root != null) {
        if (root.val < low) {
          if (parent != null) {
            TreeNode n = root;
            root = helper(root.right, root, low, high);
            if (parent.left == n) parent.left = root;
            if (parent.right == n) parent.right = root;
          } else root = root.right;
        } else if (root.val > high) {
          if (parent != null) {
            TreeNode n = root;
            root = helper(root.left, root, low, high);
            if (parent.left == n) parent.left = root;
            if (parent.right == n) parent.right = root;
          } else root = root.left;
        } else {
          root.left = helper(root.left, root, low, high);
          root.right = helper(root.right, root, low, high);
        }
      }

      return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
      return helper(root, null, low, high);
    }
  }

  public static void main(String[] args) {
    TrimABST trimABST = new TrimABST();
    Solution solution = trimABST.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(0), new TreeNode(2));
    tree = solution.trimBST(tree, 1, 2);
    System.out.println(tree);

    tree =
        new TreeNode(
            3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
    tree = solution.trimBST(tree, 1, 3);
    System.out.println(tree);

    tree = new TreeNode(1);
    tree = solution.trimBST(tree, 1, 2);
    System.out.println(tree);

    tree = new TreeNode(1, null, new TreeNode(2));
    tree = solution.trimBST(tree, 1, 3);
    System.out.println(tree);

    tree = new TreeNode(1, null, new TreeNode(2));
    tree = solution.trimBST(tree, 2, 4);
    System.out.println(tree);

    tree =
      new TreeNode(
        0,
        null,
        new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)))
        );
    tree = solution.trimBST(tree, 2, 4);
    System.out.println(tree);

    tree =
      new TreeNode(
        0,
        null,
        new TreeNode(1)
      );
    tree = solution.trimBST(tree, 2, 4);
    System.out.println(tree);
  }
}
