package com.ihaveaname.java.leetcode;

public class AddOneRowToTree_623 {
  class Solution {
    private TreeNode helper(TreeNode root, TreeNode parent, int val, int depth) {
      if (root != null) {
        if (depth == 1) {
          TreeNode n = new TreeNode(val);
          if (parent == null) n.left = root;
          else {
            if (root == parent.left) n.left = root;
            else if (root == parent.right) n.right = root;
          }
          return n;
        } else {
          root.left = helper(root.left, root, val, depth - 1);
          root.right = helper(root.right, root, val, depth - 1);
          return root;
        }
      }

      return null;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
      return helper(root, null, val, depth);
    }
  }

  public static void main(String[] args) {
    AddOneRowToTree_623 addOneRowToTree_623 = new AddOneRowToTree_623();
    Solution solution = addOneRowToTree_623.new Solution();
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

    TreeNode tree =
        new TreeNode(
            4,
            new TreeNode(2, new TreeNode(3), new TreeNode(1)),
            new TreeNode(6, new TreeNode(5), null));
    System.out.println(printer.printTree(solution.addOneRow(tree, 1, 2)));
  }
}
