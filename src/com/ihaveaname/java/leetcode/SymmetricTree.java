package com.ihaveaname.java.leetcode;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) return true;
    if (node1 != null && node2 != null && node1.val == node2.val)
      return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

    return false;
  }

  public static void main(String[] args) {
    SymmetricTree st = new SymmetricTree();

    TreeNode root =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
            new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)));
    assert st.isSymmetric(root);

    root =
        new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(3, null, null)),
            new TreeNode(2, null, new TreeNode(3, null, null)));
    assert !st.isSymmetric(root);

    root =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(2, null, null), null),
            new TreeNode(2, new TreeNode(2, null, null), null));
    assert !st.isSymmetric(root);

    root =
        new TreeNode(
            5,
            new TreeNode(4, null, new TreeNode(1, new TreeNode(2, null, null), null)),
            new TreeNode(1, null, new TreeNode(4, new TreeNode(2, null, null), null)));
    assert !st.isSymmetric(root);
  }
}
