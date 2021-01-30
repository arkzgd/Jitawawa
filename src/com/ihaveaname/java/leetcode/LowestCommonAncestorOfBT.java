package com.ihaveaname.java.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorOfBT {
  private Set<TreeNode> reachable(
      TreeNode s, TreeNode p, TreeNode q, Stack<TreeNode> ppath, Stack<TreeNode> qpath) {
    if (s == null) return new HashSet<>();

    Set<TreeNode> result = new HashSet<>();

    if (s.val == p.val) {
      ppath.push(p);
      result.add(p);
    }

    if (s.val == q.val) {
      qpath.push(q);
      result.add(q);
    }

    Set<TreeNode> lr = reachable(s.left, p, q, ppath, qpath);
    Set<TreeNode> rr = reachable(s.right, p, q, ppath, qpath);

    if (lr.contains(p) || rr.contains(p)) {
      ppath.push(s);
      result.add(p);
    }

    if (lr.contains(q) || rr.contains(q)) {
      qpath.push(s);
      result.add(q);
    }

    return result;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Stack<TreeNode> pr = new Stack<>();
    Stack<TreeNode> qr = new Stack<>();
    reachable(root, p, q, pr, qr);
    TreeNode r = null;
    while (!pr.isEmpty() && !qr.isEmpty() && pr.peek().val == qr.peek().val) {
      r = pr.pop();
      qr.pop();
    }
    return r;
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
