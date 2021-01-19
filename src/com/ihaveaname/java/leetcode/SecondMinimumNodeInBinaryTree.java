package com.ihaveaname.java.leetcode;

public class SecondMinimumNodeInBinaryTree {
  private boolean isLeafNode(TreeNode node) {
    return node.left == null && node.right == null;
  }

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) return -1;
    if (isLeafNode(root)) return -1;
    if (isLeafNode(root.left) && isLeafNode(root.right)) {
      if (root.left.val == root.right.val) return -1;
      else return Math.max(root.left.val, root.right.val);
    }

    if (root.left.val > root.val)
      return Math.min(findSecondMinimumValue(root.left), root.left.val);
    else if (root.right.val > root.val)
      return Math.min(findSecondMinimumValue(root.right), root.right.val);
    else return Math.min(findSecondMinimumValue(root.left), findSecondMinimumValue(root.right));
  }

  public static void main(String[] args) {
    SecondMinimumNodeInBinaryTree smnib = new SecondMinimumNodeInBinaryTree();

    TreeNode tree =
        new TreeNode(
            2,
            new TreeNode(2, null, null),
            new TreeNode(5, new TreeNode(5, null, null), new TreeNode(7, null, null)));
    System.out.println(smnib.findSecondMinimumValue(tree));

    tree =
      new TreeNode(2, new TreeNode(2, null, null), new TreeNode(2, null, null));
    System.out.println(smnib.findSecondMinimumValue(tree));
  }
}
