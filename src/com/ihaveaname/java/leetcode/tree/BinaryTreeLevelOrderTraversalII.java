package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {
  private void helper(TreeNode root, int level, Stack<List<Integer>> result) {
    if (root != null) {
      if (result.size() == level) result.push(new ArrayList<>());

      result.get(level).add(root.val);

      helper(root.left, level + 1, result);
      helper(root.right, level + 1, result);
    }
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Stack<List<Integer>> stacked = new Stack<>();
    helper(root, 0, stacked);
    while (!stacked.isEmpty()) result.add(stacked.pop());

    return result;
  }

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversalII btlotii = new BinaryTreeLevelOrderTraversalII();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(9, null, null),
            new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    System.out.println(btlotii.levelOrderBottom(tree));
  }
}
