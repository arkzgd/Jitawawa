package com.ihaveaname.java.leetcode;

public class InvertTree {
  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode t = root.left;
      root.left = root.right;
      root.right = t;

      invertTree(root.left);
      invertTree(root.right);
    }

    return root;
  }

  public static void main(String[] args) {
    InvertTree it = new InvertTree();
    ConstructStringFromBinaryTree cfb = new ConstructStringFromBinaryTree();

    TreeNode tree =
      new TreeNode(
        4,
        new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
        new TreeNode(7, new TreeNode(6, null, null), new TreeNode(9, null, null))
      );
    System.out.println(cfb.tree2str(tree));
    TreeNode inverted = it.invertTree(tree);
    System.out.println(cfb.tree2str(inverted));
  }
}
