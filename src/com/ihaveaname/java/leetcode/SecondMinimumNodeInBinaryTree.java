package com.ihaveaname.java.leetcode;

public class SecondMinimumNodeInBinaryTree {
  private int lowMark;
  private int min;

  private void traverse(TreeNode root) {
    if (root != null) {
      if (root.val > lowMark && lowMark == min) lowMark = root.val;
      if (root.val < lowMark && root.val > min) lowMark = root.val;
      if (root.val == min) {
        traverse(root.left);
        traverse(root.right);
      }
    }
  }

  public int findSecondMinimumValue(TreeNode root) {
    min = root.val;
    lowMark = root.val;
    traverse(root);
    return lowMark == min ? -1 : lowMark;
  }

  public static void main(String[] args) {
    SecondMinimumNodeInBinaryTree smnib = new SecondMinimumNodeInBinaryTree();

    TreeNode tree =
        new TreeNode(
            2,
            new TreeNode(2, null, null),
            new TreeNode(5, new TreeNode(5, null, null), new TreeNode(7, null, null)));
    assert smnib.findSecondMinimumValue(tree) == 5;

    tree = new TreeNode(2, new TreeNode(2, null, null), new TreeNode(2, null, null));
    assert smnib.findSecondMinimumValue(tree) == -1;

    tree =
        new TreeNode(
            2,
            new TreeNode(2, null, null),
            new TreeNode(5, new TreeNode(5, null, null), new TreeNode(5, null, null)));
    assert smnib.findSecondMinimumValue(tree) == 5;

    tree = new TreeNode(2, new TreeNode(2, null, null), new TreeNode(2147483647, null, null));
    assert smnib.findSecondMinimumValue(tree) == 2147483647;

    tree = new TreeNode(5, new TreeNode(8, null, null), new TreeNode(5, null, null));
    assert smnib.findSecondMinimumValue(tree) == 8;
  }
}
