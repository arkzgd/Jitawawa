package com.ihaveaname.java.leetcode;

public class ConstructStringFromBinaryTree {

  public String tree2str(TreeNode t) {
    if (t != null) {
      if (t.left == null) {
        String r = tree2str(t.right);
        return t.val + (r.isBlank() ? r : "()(" + r + ")");
      }
      else {
        String l = tree2str(t.left);
        String r = tree2str(t.right);
        return t.val + "(" + l +")" + (r.isBlank() ? r : "(" + r + ")");
      }
    }

    return "";
  }

  public static void main(String[] args) {
    ConstructStringFromBinaryTree csfbt = new ConstructStringFromBinaryTree();

    TreeNode tree =
        new TreeNode(
            1, new TreeNode(2, new TreeNode(4, null, null), null), new TreeNode(3, null, null));
    System.out.println(csfbt.tree2str(tree));

    tree =
        new TreeNode(
            1, new TreeNode(2, null, new TreeNode(4, null, null)), new TreeNode(3, null, null));
    System.out.println(csfbt.tree2str(tree));
  }
}
