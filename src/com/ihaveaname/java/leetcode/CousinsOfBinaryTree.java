package com.ihaveaname.java.leetcode;

public class CousinsOfBinaryTree {
  private int height(TreeNode root, int v, int currHeight) {
    if (root != null) {
      if (root.val == v) return currHeight;
      int lh = height(root.left, v, currHeight + 1);
      if (lh != -1) return lh;
      int rh = height(root.right, v, currHeight + 1);
      if (rh != -1) return rh;
    }

    return -1;
  }

  private TreeNode parent(TreeNode root, int v) {
    if (root != null) {
      if (root.left != null && root.left.val == v || root.right != null && root.right.val == v) return root;
      TreeNode lr = parent(root.left, v);
      if (lr != null) return lr;
      TreeNode rr = parent(root.right, v);
      if (rr != null) return rr;
    }

    return null;
  }

  public boolean isCousins(TreeNode root, int x, int y) {
    return height(root, x, 0) == height(root, y, 0) && parent(root, x) != parent(root, y);
  }

  public static void main(String[] args) {
    CousinsOfBinaryTree cobt = new CousinsOfBinaryTree();

    TreeNode tree = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4, null, null), null),
      new TreeNode(3, null, new TreeNode(6, null, null))
    );
    System.out.println(cobt.isCousins(tree, 4, 3));
    System.out.println(cobt.isCousins(tree, 2, 3));
    System.out.println(cobt.isCousins(tree, 4, 6));
  }
}
