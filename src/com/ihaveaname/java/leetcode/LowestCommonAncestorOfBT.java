package com.ihaveaname.java.leetcode;

import java.util.Stack;

public class LowestCommonAncestorOfBT {
  private boolean reachable(TreeNode s, TreeNode t, Stack<TreeNode> path) {
    if (s == null) return false;

    if (s.val == t.val) {
      path.push(s);
      return true;
    }

    if (reachable(s.left, t, path)) {
      path.push(s);
      return true;
    }

    if (reachable(s.right, t, path)) {
      path.push(s);
      return true;
    }

    return false;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Stack<TreeNode> pr = new Stack<>();
    boolean pf = reachable(root, p, pr);
    Stack<TreeNode> qr = new Stack<>();
    boolean qf = reachable(root, q, qr);
    TreeNode r = null;

    if (pf && qf) {
      while (!pr.isEmpty() && !qr.isEmpty() && pr.peek().val == qr.peek().val) {
        r = pr.pop();
        qr.pop();
      }
      return r;
    } else return null;
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
