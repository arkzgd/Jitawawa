package com.ihaveaname.java.leetcode;

public class InsertToBST {
  public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode pre = null;
    TreeNode curr = root;
    TreeNode t = new TreeNode(val, null, null);
    while (curr != null) {
      if (curr.val > val) {
        pre = curr;
        curr = curr.left;
      } else {
        pre = curr;
        curr = curr.right;
      }
    }

    if (pre == null) return t;
    if (pre.val > val) pre.left = t;
    else pre.right = t;

    return root;
  }
}
