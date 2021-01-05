package com.ihaveaname.java.leetcode;

public class CopyOfNodeInClonedBinaryTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public final TreeNode getTargetCopy(
      final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (cloned == null) return null;
    int val = target.val;
    if (cloned.val != val) {
      TreeNode l = getTargetCopy(original, cloned.left, target);
      return l != null ? l : getTargetCopy(original, cloned.right, target);
    } else return cloned;
  }
}
