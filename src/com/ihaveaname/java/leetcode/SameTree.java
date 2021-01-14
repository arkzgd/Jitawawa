package com.ihaveaname.java.leetcode;

public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p != null && q != null) {
      if (p.val != q.val) return false;
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } else if (p == null && q == null) return true;
    else return false;
  }

  public static void main(String[] args) {
    SameTree st = new SameTree();

    TreeNode p = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    TreeNode q = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    System.out.println(st.isSameTree(p, q));

    p = new TreeNode(1, new TreeNode(2, null, null), null);
    q = new TreeNode(1, null, new TreeNode(2, null, null));
    System.out.println(st.isSameTree(p, q));

    p = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    q = new TreeNode(1, new TreeNode(3, null, null), new TreeNode(2, null, null));
    System.out.println(st.isSameTree(p, q));

    System.out.println(st.isSameTree(null, null));

    System.out.println(st.isSameTree(p, null));

    System.out.println(st.isSameTree(null, q));
  }
}
