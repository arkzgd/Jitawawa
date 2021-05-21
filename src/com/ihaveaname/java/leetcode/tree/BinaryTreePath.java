package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
  private final List<String> path;

  public BinaryTreePath() {
    path = new ArrayList<>();
  }

  private void helper(TreeNode root, String sofar) {
    if (root != null) {
      helper(root.left, sofar + root.val + "->");
      helper(root.right, sofar + root.val + "->");
      if (root.left == null && root.right == null) {
        path.add(sofar + root.val);
      }
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    helper(root, "");
    return path;
  }

  public static void main(String[] args) {
    BinaryTreePath btp = new BinaryTreePath();

    TreeNode tree =
        new TreeNode(
            1, new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null));
    System.out.println(btp.binaryTreePaths(tree));

    btp = new BinaryTreePath();
    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3, null, null), new TreeNode(5, null, null)),
            new TreeNode(3, null, new TreeNode(6, null, null)));
    System.out.println(btp.binaryTreePaths(tree));
  }
}
