package com.ihaveaname.java.leetcode;

import java.util.ArrayList;

public class LowestCommonAncestorOfBST {
  private ArrayList<TreeNode> reachable(TreeNode s, TreeNode t) {
    ArrayList<TreeNode> result = new ArrayList<>();

    while (s != null && s.val != t.val) {
      result.add(s);
      if (s.val > t.val) s = s.left;
      else s = s.right;
    }

    if (s != null) result.add(t);

    return result;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    ArrayList<TreeNode> plist = reachable(root, p);
    ArrayList<TreeNode> qlist = reachable(root, q);
    int i = 0;
    int len = Math.min(plist.size(), qlist.size());
    while (i < len) {
      if (plist.get(i).val == qlist.get(i).val) i++;
      else break;
    }
    if (i >= len) return plist.get(i - 1);
    else return plist.get(i == 0 ? i : i - 1);
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
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(3), new TreeNode(9)).val);
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(2), new TreeNode(6)).val);
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(8), new TreeNode(6)).val);
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(7), new TreeNode(6)).val);
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(7), new TreeNode(9)).val);
    System.out.println(lcaob.lowestCommonAncestor(tree, new TreeNode(4), new TreeNode(5)).val);
  }
}
