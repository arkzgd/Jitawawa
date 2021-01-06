package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    if (root != null) stack.push(root);

    while (!stack.isEmpty()) {
      while (root != null) {
        stack.push(root.left);
        root = root.left;
      }

      root = stack.pop();
      if (root != null) {
        result.add(root.val);
        stack.push(root.right);
        root = root.right;
      }
    }

    return result;
  }

  public void inorderTraversal_recursive(TreeNode root, List<Integer> result) {
    if (root == null) return;

    inorderTraversal_recursive(root.left, result);
    result.add(root.val);
    inorderTraversal_recursive(root.right, result);
  }

  public static void main(String[] args) {
    InOrderTraversal iots = new InOrderTraversal();

    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    System.out.println(iots.inorderTraversal(root));

    root = null;
    System.out.println(iots.inorderTraversal(root));

    root = new TreeNode(1, null, null);
    System.out.println(iots.inorderTraversal(root));

    root = new TreeNode(1, new TreeNode(2, null, null), null);
    System.out.println(iots.inorderTraversal(root));

    root = new TreeNode(1, null, new TreeNode(2, null, null));
    System.out.println(iots.inorderTraversal(root));

    root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null, null), null), null);
    System.out.println(iots.inorderTraversal(root));
  }
}
