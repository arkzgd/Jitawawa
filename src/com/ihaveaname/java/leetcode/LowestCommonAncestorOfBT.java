package com.ihaveaname.java.leetcode;

public class LowestCommonAncestorOfBT {
  private int reachable(TreeNode s, TreeNode p, TreeNode q) {
    if (s == null) return 0;

    int ret = 0;
    if (s.val == p.val) ret++;
    if (s.val == q.val) ret++;
    if (s.val == p.val || s.val == q.val) {
      if (reachable(s.left, p, q) == 0) return reachable(s.right, p, q) + ret;
      else return 2;
    }
    ret = reachable(s.left, p, q);
    if (ret < 2) return reachable(s.right, p, q) + ret;
    else return ret;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (root.val == p.val || root.val == q.val) break;
      int ret = reachable(root.left, p, q);
      if (ret == 1) break;
      if (ret == 2) root = root.left;
      else root = root.right;
    }

    return root;
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
    //    System.out.println(lcaob.reachable(tree.left.left, new TreeNode(2), new TreeNode(8)));
  }
}
