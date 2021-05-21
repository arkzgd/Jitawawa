package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
  public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    TreeNode node = root;
    TreeNode previousPopped = null;

    do {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      if (!stack.isEmpty()) {
        node = stack.pop();
        if (node.right == null || previousPopped != null && previousPopped == node.right) {
          result.add(node.val);
          previousPopped = node;
          node = null;
        } else {
          stack.push(node);
          stack.push(node.right);
          node = node.right.left;
        }
      }
    } while (!stack.isEmpty());

    return result;
  }

  public static void main(String[] args) {
    BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();

    TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    System.out.println(btpt.postorderTraversal(tree));

    tree = null;
    System.out.println(btpt.postorderTraversal(tree));

    tree =
        new TreeNode(
            1, null, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)));
    System.out.println(btpt.postorderTraversal(tree));

    tree = new TreeNode(1, null, new TreeNode(2, null, null));
    System.out.println(btpt.postorderTraversal(tree));

    tree = new TreeNode(1, new TreeNode(2, null, null), null);
    System.out.println(btpt.postorderTraversal(tree));
  }
}
