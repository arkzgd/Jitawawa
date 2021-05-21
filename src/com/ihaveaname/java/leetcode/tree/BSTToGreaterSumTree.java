package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class BSTToGreaterSumTree {
  private TreeNode prev;

  public BSTToGreaterSumTree() {
    prev = null;
  }

  private void helper(TreeNode root) {
    if (root != null) {
      helper(root.right);
      if (prev != null) root.val += prev.val;
      prev = root;
      helper(root.left);
    }
  }

  public TreeNode bstToGst(TreeNode root) {
    helper(root);
    return root;
  }

  public static void main(String[] args) {
    BSTToGreaterSumTree bstToGreaterSumTree = new BSTToGreaterSumTree();

    TreeNode tree =
      new TreeNode(
        0,
        null,
        new TreeNode(1, null, null)
      );
    System.out.println(bstToGreaterSumTree.bstToGst(tree));

    bstToGreaterSumTree = new BSTToGreaterSumTree();
    tree =
      new TreeNode(
        1,
        new TreeNode(0, null, null),
        new TreeNode(2, null, null)
        );
    System.out.println(bstToGreaterSumTree.bstToGst(tree));

    bstToGreaterSumTree = new BSTToGreaterSumTree();
    tree =
      new TreeNode(
        3,
        new TreeNode(2, new TreeNode(1, null, null), null),
        new TreeNode(4, null, null)
      );
    System.out.println(bstToGreaterSumTree.bstToGst(tree));
  }
}
