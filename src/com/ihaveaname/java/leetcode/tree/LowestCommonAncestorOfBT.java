package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class LowestCommonAncestorOfBT {
  private TreeNode ans;

  public LowestCommonAncestorOfBT() {
    this.ans = null;
  }

  private int reachable(TreeNode s, TreeNode p, TreeNode q) {
    if (s != null) {
      int left = reachable(s.left, p, q) == 1 ? 1 : 0;
      int right = reachable(s.right, p, q) == 1 ? 1 : 0;
      int mid = s.val == p.val && s.val == q.val ? 2 : s.val == p.val || s.val == q.val ? 1 : 0;

      if (left + right + mid == 2) {
        ans = s;
        return 2;
      } else return left + right + mid;
    }

    return 0;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    reachable(root, p, q);
    return ans;
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
