package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    inOrder(root, result);
    int low = 0, high = result.size() - 1;
    while (low < high) {
      if (!result.get(low++).equals(result.get(high--))) return false;
    }

    return true;
  }

  private void inOrder(TreeNode node, List<Integer> result) {
    if (node.left != null) inOrder(node.left, result);
    else result.add(Integer.MIN_VALUE);

    result.add(node.val);

    if (node.right != null) inOrder(node.right, result);
    else result.add(Integer.MIN_VALUE);
  }

  public static void main(String[] args) {
    SymmetricTree st = new SymmetricTree();

    TreeNode root =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
            new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)));
    System.out.println(st.isSymmetric(root));

    root =
        new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(3, null, null)),
            new TreeNode(2, null, new TreeNode(3, null, null)));
    System.out.println(st.isSymmetric(root));

    root =
      new TreeNode(
        1,
        new TreeNode(2, new TreeNode(2, null, null), null),
        new TreeNode(2, new TreeNode(2, null, null), null)
      );
    System.out.println(st.isSymmetric(root));
  }
}
