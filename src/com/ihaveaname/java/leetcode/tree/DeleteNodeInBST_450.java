package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class DeleteNodeInBST_450 {
  class Solution {
    private TreeNode helper(TreeNode root, int key) {
      if (root != null) {
        if (root.val == key) {
          if (root.left == null && root.right == null) return null;
          else if (root.left == null) return root.right;
          else if (root.right == null) return root.left;
          else {
            // root has both left chile and right child
            TreeNode t = root.right;
            while (t.left != null) t = t.left;
            root.val = t.val;
            root.right = helper(root.right, t.val);
          }
        } else {
          if (key < root.val) root.left = helper(root.left, key);
          if (key > root.val) root.right = helper(root.right, key);
        }
      }

      return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
      return helper(root, key);
    }
  }

  public static void main(String[] args) {
    DeleteNodeInBST_450 deleteNodeInBST_450 = new DeleteNodeInBST_450();
    Solution solution = deleteNodeInBST_450.new Solution();
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

    TreeNode tree =
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7)));
    System.out.println(printer.printTree(solution.deleteNode(tree, 3)));

    tree =
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2), new TreeNode(4)),
            new TreeNode(6, null, new TreeNode(7)));
    System.out.println(printer.printTree(solution.deleteNode(tree, 0)));

    tree = null;
    System.out.println(printer.printTree(solution.deleteNode(tree, 0)));
  }
}
