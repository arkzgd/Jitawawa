package com.ihaveaname.java.leetcode;

import java.util.Stack;

class BSTIterator {
  private Stack<TreeNode> stack = new Stack<>();

  public BSTIterator(TreeNode root) {
    stack.clear();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  public int next() {
    TreeNode node = stack.pop();
    int result = node.val;

    node = node.right;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }

    return result;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public static void main(String[] args) {
    TreeNode tree =
        new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
    BSTIterator iterator = new BSTIterator(tree);
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.hasNext());
  }
}
