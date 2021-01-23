package com.ihaveaname.java.leetcode;

public class SubtreeOfAnotherTree {

  private boolean isSubtree(TreeNode s, TreeNode t, TreeNode ot) {
    if (s == null && t == null) return true;
    if (s != null && t != null && s.val == t.val)
      return isSubtree(s.left, t.left, t) && isSubtree(s.right, t.right, t);
    else {
      if (s != null && isSubtree(s.left, ot, ot)) return true;
      else if (s != null && isSubtree(s.right, ot, ot)) return true;
      else return false;
    }
  }

  public boolean isSubtree(TreeNode s, TreeNode t) {
    return isSubtree(s, t, t);
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
  }
}
