package com.ihaveaname.java.leetcode;

public class CopyOfNodeInClonedBinaryTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, TreeNode left, TreeNode right) {
      val = x;
      this.left = left;
      this.right = right;
    }
  }

  private TreeNode copyTree(TreeNode root) {
    if (root == null) return null;
    TreeNode cloned = new TreeNode(root.val, root.left, root.right);
    cloned.left = copyTree(root.left);
    cloned.right = copyTree(root.right);

    return cloned;
  }

  private TreeNode find(TreeNode root, int value) {
    if (root == null) return null;

    if (root.val == value) return root;
    TreeNode inLeftTree = find(root.left, value);
    return inLeftTree != null ? inLeftTree : find(root.right, value);
  }

  public final TreeNode getTargetCopy(
      final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (original == null || cloned == null) return null;
    if (original == target) return cloned;

    TreeNode inLeftTree = getTargetCopy(original.left, cloned.left, target);
    return inLeftTree != null ? inLeftTree : getTargetCopy(original.right, cloned.right, target);
  }

  public static void main(String[] args) {
    CopyOfNodeInClonedBinaryTree concbt = new CopyOfNodeInClonedBinaryTree();

    TreeNode original =
        new TreeNode(
            7,
            new TreeNode(4, null, null),
            new TreeNode(3, new TreeNode(6, null, null), new TreeNode(19, null, null)));

    TreeNode cloned = concbt.copyTree(original);

    assert concbt.getTargetCopy(original, cloned, concbt.find(original, 3))
        == concbt.find(cloned, 3);
  }
}
