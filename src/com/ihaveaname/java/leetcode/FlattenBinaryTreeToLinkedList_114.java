package com.ihaveaname.java.leetcode;

public class FlattenBinaryTreeToLinkedList_114 {
  class Solution {
    private TreeNode prev;
    private void helper(TreeNode root) {
      if (root != null) {
        if (prev != null) System.out.println("prev: " + prev.val);
        else System.out.println("prev: nil");
        System.out.println("root: " + root.val);

        prev = root;
        if (root.left != null) {
          helper(root.left);
        }
        if (root.right != null) {
          helper(root.right);
          prev = root.right;
        }
      }
    }

    public void flatten(TreeNode root) {
      helper(root);
    }
  }

  public static void main(String[] args) {
    FlattenBinaryTreeToLinkedList_114 flattenBinaryTreeToLinkedList_114 =
        new FlattenBinaryTreeToLinkedList_114();
    Solution solution = flattenBinaryTreeToLinkedList_114.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(6)));
    solution.flatten(tree);

    /*tree = null;
    solution.flatten(tree);

    tree = new TreeNode(0);
    solution.flatten(tree);*/
  }
}
