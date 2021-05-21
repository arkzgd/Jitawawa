package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
  class Solution {
    // Recursive version for reference
    private void helper(TreeNode root, List<Integer> result) {
      if (root != null) {
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
      }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();

      while (root != null) {
        result.add(root.val);
        stack.push(root);
        root = root.left;
      }

      while (!stack.isEmpty()) {
        TreeNode n = stack.pop();
        if (n.right != null) {
          n = n.right;
          while (n != null) {
            result.add(n.val);
            stack.push(n);
            n = n.left;
          }
        }
      }

      return result;
    }
  }

  public static void main(String[] args) {
    BinaryTreePreorderTraversal_144 binaryTreePreorderTraversal_144 =
        new BinaryTreePreorderTraversal_144();
    Solution solution = binaryTreePreorderTraversal_144.new Solution();

    TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    System.out.println(solution.preorderTraversal(tree));

    tree = null;
    System.out.println(solution.preorderTraversal(tree));

    tree = new TreeNode(1);
    System.out.println(solution.preorderTraversal(tree));

    tree = new TreeNode(1, new TreeNode(2), null);
    System.out.println(solution.preorderTraversal(tree));

    tree = new TreeNode(1, null, new TreeNode(2));
    System.out.println(solution.preorderTraversal(tree));
  }
}
