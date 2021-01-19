package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SecondMinimumNodeInBinaryTree {
  private void preOrder(TreeNode root, List<Integer> result) {
    if (root != null) {
      result.add(root.val);
      preOrder(root.left, result);
      preOrder(root.right, result);
    }
  }

  public int findSecondMinimumValue(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    preOrder(root, result);

    Collections.sort(result);
    int slow = 0, fast = 0;
    for (; fast < result.size(); fast++) {
      if (!Objects.equals(result.get(fast), result.get(slow))) return result.get(fast);
    }

    return -1;
  }

  public static void main(String[] args) {
    SecondMinimumNodeInBinaryTree smnib = new SecondMinimumNodeInBinaryTree();

    TreeNode tree =
        new TreeNode(
            2,
            new TreeNode(2, null, null),
            new TreeNode(5, new TreeNode(5, null, null), new TreeNode(7, null, null)));
    System.out.println(smnib.findSecondMinimumValue(tree));

    tree = new TreeNode(2, new TreeNode(2, null, null), new TreeNode(2, null, null));
    System.out.println(smnib.findSecondMinimumValue(tree));

    tree =
        new TreeNode(
            2,
            new TreeNode(2, null, null),
            new TreeNode(5, new TreeNode(5, null, null), new TreeNode(5, null, null)));
    System.out.println(smnib.findSecondMinimumValue(tree));
  }
}
