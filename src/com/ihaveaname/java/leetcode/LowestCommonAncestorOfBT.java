package com.ihaveaname.java.leetcode;

public class LowestCommonAncestorOfBT {
  private boolean reachable(TreeNode s, TreeNode t) {
    if (s == null) return false;

    if (s.val == t.val) return true;

    if (reachable(s.left, t)) return true;
    return reachable(s.right, t);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root != null) {
      if (root.val == p.val && root.val == q.val) return root;
      if (root.val == p.val && (reachable(root.left, q) || reachable(root.right, q))) return root;
      if (root.val == q.val && (reachable(root.left, p) || reachable(root.right, p))) return root;

      if (reachable(root.left, p) && reachable(root.right, q)
          || reachable(root.left, q) && reachable(root.right, p)) return root;

      if (reachable(root.left, p) && reachable(root.left, q))
        return lowestCommonAncestor(root.left, p, q);
      if (reachable(root.right, p) && reachable(root.right, q))
        return lowestCommonAncestor(root.right, p, q);
    }

    return null;
  }

  public static void main(String[] args) {
    LowestCommonAncestorOfBT lcaob = new LowestCommonAncestorOfBT();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(
                5,
                new TreeNode(6, null, null),
                new TreeNode(2, new TreeNode(7, null, null), new TreeNode(4, null, null))),
            new TreeNode(1, new TreeNode(0, null, null), new TreeNode(8, null, null)));
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(6)).val == 5;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(1)).val == 3;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(7)).val == 2;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(7), new TreeNode(8)).val == 3;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(2), new TreeNode(4)).val == 2;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(4)).val == 4;
  }
}
