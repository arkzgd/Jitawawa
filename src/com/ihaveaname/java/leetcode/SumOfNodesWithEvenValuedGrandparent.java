package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumOfNodesWithEvenValuedGrandparent {
  private int sum;

  public SumOfNodesWithEvenValuedGrandparent() {
    sum = 0;
  }

  private List<TreeNode> grandChildren(TreeNode node) {
    List<TreeNode> result = new ArrayList<>();
    if (node != null) {
      if (node.left != null) {
        result.add(node.left.left);
        result.add(node.left.right);
      }
      if (node.right != null) {
        result.add(node.right.left);
        result.add(node.right.right);
      }
    }

    return result;
  }

  private void helper(TreeNode grandParent, List<TreeNode> gc) {
    if (grandParent != null) {
      helper(grandParent.left, grandChildren(grandParent.left));
      helper(grandParent.right, grandChildren(grandParent.right));

      if (grandParent.val % 2 == 0) {
        for (TreeNode c : gc) sum += c == null ? 0 : c.val;
      }
    }
  }

  public int sumEvenGrandparent(TreeNode root) {
    helper(root, grandChildren(root));
    return sum;
  }

  public static void main(String[] args) {
    SumOfNodesWithEvenValuedGrandparent sumOfNodesWithEvenValuedGrandparent =
        new SumOfNodesWithEvenValuedGrandparent();

    TreeNode tree =
        new TreeNode(
            6,
            new TreeNode(
                7,
                new TreeNode(2, new TreeNode(9, null, null), null),
                new TreeNode(7, new TreeNode(1, null, null), new TreeNode(4, null, null))),
            new TreeNode(
                8,
                new TreeNode(1, null, null),
                new TreeNode(3, null, new TreeNode(5, null, null))));
    System.out.println(sumOfNodesWithEvenValuedGrandparent.sumEvenGrandparent(tree));
  }
}
