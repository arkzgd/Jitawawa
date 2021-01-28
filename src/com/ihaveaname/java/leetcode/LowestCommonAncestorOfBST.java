package com.ihaveaname.java.leetcode;

public class LowestCommonAncestorOfBST {
  private boolean reachable(TreeNode s, TreeNode t) {
    while (s != null && s.val != t.val) {
      if (s.val > t.val) s = s.left;
      else s = s.right;
    }

    if (s == null) return false;
    else return true;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (reachable(root, p) && reachable(root, q)) return root;

    TreeNode l = lowestCommonAncestor(root.left, p, q);
    if (l != null) return l;

    TreeNode r = lowestCommonAncestor(root.right, p, q);
    if (r != null) return r;

    return null;
  }

  public static void main(String[] args) {
    LowestCommonAncestorOfBST lcaob = new LowestCommonAncestorOfBST();

    TreeNode tree =
        new TreeNode(
            6,
            new TreeNode(
                2,
                new TreeNode(0, null, null),
                new TreeNode(4, new TreeNode(3, null, null), new TreeNode(5, null, null))),
            new TreeNode(8, new TreeNode(7, null, null), new TreeNode(9, null, null)));
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(0), new TreeNode(3)).val);
  }
}
