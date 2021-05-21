package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class DiameterOfBinaryTree {

  // height returns [height of node.left, maximum diameter so far, height of node.right]
  private int[] height(TreeNode node) {
    if (node == null) return new int[] {0, 0, 0};

    int[] fromLeftSubtree = height(node.left);
    int[] fromRightSubtree = height(node.right);
    int leftSubTreeDiameter = fromLeftSubtree[1];
    int rightSubTreeDiameter = fromRightSubtree[1];
    int myDiameter =
        Math.max(fromLeftSubtree[0], fromLeftSubtree[2])
            + Math.max(fromRightSubtree[0], fromRightSubtree[2]);

    return new int[] {
      Math.max(fromLeftSubtree[0], fromLeftSubtree[2]) + 1,
      Math.max(myDiameter, Math.max(leftSubTreeDiameter, rightSubTreeDiameter)),
      Math.max(fromRightSubtree[0], fromRightSubtree[2]) + 1
    };
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    return height(root)[1];
  }

  public static void main(String[] args) {
    DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
            new TreeNode(3, null, null));
    System.out.println(dbt.diameterOfBinaryTree(tree));
  }
}
