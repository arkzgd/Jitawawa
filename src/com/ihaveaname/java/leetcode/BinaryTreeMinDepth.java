package com.ihaveaname.java.leetcode;

public class BinaryTreeMinDepth {
  private int getMinDepth(TreeNode node) {
    if (node == null) return 0;

    if (node.left == null) return getMinDepth(node.right) + 1;
    else if (node.right == null) return getMinDepth(node.left) + 1;
    else return Math.min(getMinDepth(node.left), getMinDepth(node.right)) + 1;
  }

  public int minDepth(TreeNode root) {
    return getMinDepth(root);
  }

  public static void main(String[] args) {
    BinaryTreeMinDepth btmd = new BinaryTreeMinDepth();

    TreeNode root =
        new TreeNode(
            3,
            new TreeNode(9, null, null),
            new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    System.out.println(btmd.minDepth(root));
    assert btmd.minDepth(root) == 2;

    root =
        new TreeNode(
            2,
            null,
            new TreeNode(
                3,
                null,
                new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null)))));
    System.out.println(btmd.minDepth(root));
    assert btmd.minDepth(root) == 5;
  }
}
