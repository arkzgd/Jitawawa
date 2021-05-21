package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class LowestCommonAncestorOfBST {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (root.val < p.val && root.val < q.val) root = root.right;
      else if (root.val > p.val && root.val > q.val) root = root.left;
      else break;
    }

    return root;
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
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(0), new TreeNode(3)).val == 2;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(3), new TreeNode(9)).val == 6;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(2), new TreeNode(6)).val == 6;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(8), new TreeNode(6)).val == 6;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(7), new TreeNode(6)).val == 6;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(7), new TreeNode(9)).val == 8;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(5)).val == 4;
    assert lcaob.lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(4)).val == 4;
  }
}
