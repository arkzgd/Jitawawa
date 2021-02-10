package com.ihaveaname.java.leetcode;

public class SubtreeOfAnotherTree {

  private boolean isSubtreePrivate(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s != null && t != null && s.val == t.val) {
      return isSubtreePrivate(s.left, t.left) && isSubtreePrivate(s.right, t.right);
    }

    return false;
  }

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (isSubtreePrivate(s, t)) return true;
    else {
      if (s != null && isSubtree(s.left, t)) return true;
      else return s != null && isSubtree(s.right, t);
    }
  }

  public static void main(String[] args) {
    SubtreeOfAnotherTree soat = new SubtreeOfAnotherTree();

    TreeNode s =
        new TreeNode(
            3,
            new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null)),
            new TreeNode(5, null, null));
    TreeNode t = new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null));
    System.out.println(soat.isSubtree(s, t));

    s =
        new TreeNode(
            3,
            new TreeNode(
                4, new TreeNode(1, null, null), new TreeNode(2, new TreeNode(0, null, null), null)),
            new TreeNode(5, null, null));
    System.out.println(soat.isSubtree(s, t));

    s =
        new TreeNode(
            3,
            new TreeNode(
                4,
                new TreeNode(1, null, null),
                new TreeNode(
                    2,
                    new TreeNode(
                        0,
                        new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null)),
                        null),
                    null)),
            new TreeNode(5, null, null));
    System.out.println(soat.isSubtree(s, t));

    s = new TreeNode(1, new TreeNode(1, null, null), null);
    t = new TreeNode(1, null, null);
    System.out.println(soat.isSubtree(s, t));

    System.out.println(soat.isSubtree(s, s));
  }
}
