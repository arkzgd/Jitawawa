package com.ihaveaname.java.leetcode;

import com.ihaveaname.java.datastructure.Pair;
import java.util.Stack;

public class LowestCommonAncestorOfBT {
  private Pair<Stack<TreeNode>, Boolean> reachable(TreeNode s, TreeNode t) {
    if (s == null) return new Pair<>(new Stack<>(), false);

    if (s.val == t.val) {
      Stack<TreeNode> ss = new Stack<>();
      ss.push(s);
      return new Pair<>(ss, true);
    }

    Pair<Stack<TreeNode>, Boolean> lr = reachable(s.left, t);
    if (lr.v) {
      lr.u.push(s);
      return new Pair<>(lr.u, true);
    }

    Pair<Stack<TreeNode>, Boolean> rr = reachable(s.right, t);
    if (rr.v) {
      rr.u.push(s);
      return new Pair<>(rr.u, true);
    }

    return new Pair<>(new Stack<>(), false);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Pair<Stack<TreeNode>, Boolean> pr = reachable(root, p);
    Pair<Stack<TreeNode>, Boolean> qr = reachable(root, q);
    TreeNode r = null;

    if (pr.v && qr.v) {
      while (!pr.u.isEmpty() && !qr.u.isEmpty() && pr.u.peek().val == qr.u.peek().val) {
        r = pr.u.pop();
        qr.u.pop();
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
