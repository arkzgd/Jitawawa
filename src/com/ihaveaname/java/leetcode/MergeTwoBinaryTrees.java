package com.ihaveaname.java.leetcode;

public class MergeTwoBinaryTrees {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 != null && t2 != null) t1.val += t2.val;
    else if (t1 == null) return t2;
    else return t1;

    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);

    return t1;
  }

  public static void main(String[] args) {
    MergeTwoBinaryTrees mtbt = new MergeTwoBinaryTrees();

    TreeNode tree1 =
        new TreeNode(
            1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null));
    TreeNode tree2 =
        new TreeNode(
            2,
            new TreeNode(1, null, new TreeNode(4, null, null)),
            new TreeNode(3, null, new TreeNode(7, null, null)));
    TreeNode merged = mtbt.mergeTrees(tree1, tree2);
    System.out.println(merged);
  }
}
