package com.ihaveaname.java.leetcode;

import com.ihaveaname.java.datastructure.Stack;
import com.ihaveaname.java.datastructure.StackByQueue;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new StackByQueue<>();

    while (!stack.empty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      result.add(root.val);
      root = root.right;
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
    List<Integer> result = new ArrayList<>();
    InOrderTraversal iots = new InOrderTraversal();

    TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    System.out.println(iots.inorderTraversal(root));
    iots.inorderTraversal_recursive(root, result);
    System.out.println(result);
    result.clear();

    root = null;
    System.out.println(iots.inorderTraversal(root));
    iots.inorderTraversal_recursive(root, result);
    System.out.println(result);
    result.clear();

    root = new TreeNode(1, null, null);
    System.out.println(iots.inorderTraversal(root));
    iots.inorderTraversal_recursive(root, result);
    System.out.println(result);
    result.clear();

    root = new TreeNode(1, new TreeNode(2, null, null), null);
    System.out.println(iots.inorderTraversal(root));
    iots.inorderTraversal_recursive(root, result);
    System.out.println(result);
    result.clear();

    root = new TreeNode(1, null, new TreeNode(2, null, null));
    System.out.println(iots.inorderTraversal(root));
    iots.inorderTraversal_recursive(root, result);
    System.out.println(result);
    result.clear();

    root = new TreeNode(2, new TreeNode(3, new TreeNode(1, null, null), null), null);
    System.out.println(iots.inorderTraversal(root));
    iots.inorderTraversal_recursive(root, result);
    System.out.println(result);
    result.clear();
  }
}
