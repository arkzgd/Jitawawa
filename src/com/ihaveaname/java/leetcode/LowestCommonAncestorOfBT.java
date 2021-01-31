package com.ihaveaname.java.leetcode;

public class LowestCommonAncestorOfBT {
  private TreeNode ans;

  public LowestCommonAncestorOfBT() {
    this.ans = null;
  }

  private int reachable(TreeNode s, TreeNode p, TreeNode q) {
    int ret = 0;
    if (s != null) {
      if (s.val == p.val && s.val == q.val) {
        ans = s;
        return 2;
      }

      if (s.val == p.val || s.val == q.val) {
        if (reachable(s.left, p, q) == 1 || reachable(s.right, p, q) == 1) {
          ans = s;
          return 2;
        }
        else return 1;
      } else {
        switch (reachable(s.left, p, q)) {
          case 0:
            ret = reachable(s.right, p, q);
            break;
          case 1:
            if (reachable(s.right, p, q) == 1) {
              ans = s;
              return 2;
            }
            else ret = 1;
            break;
          case 2:
            ret = reachable(s.left, p, q);
            break;
          default:
            throw new IllegalStateException("Unexpected value: ");
        }
      }
    }

    return ret;
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
