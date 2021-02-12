package com.ihaveaname.java.leetcode;

public class ConstructBSTFromPreorderTraversal {
  private int partition(int[] preorder, int low, int high) {
    int i = low;
    for (; i <= high; i++) if (preorder[i] > preorder[low]) break;
    return i;
  }

  private TreeNode helper(int[] preorder, int low, int high) {
    if (low > high) return null;
    if (low == high) return new TreeNode(preorder[low], null, null);

    TreeNode t = new TreeNode(preorder[low]);
    int m = partition(preorder, low, high);
    t.left = helper(preorder, low + 1, m - 1);
    t.right = helper(preorder, m, high);
    return t;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    return helper(preorder, 0, preorder.length - 1);
  }

  public static void main(String[] args) {
    ConstructBSTFromPreorderTraversal constructBSTFromPreorderTraversal =
        new ConstructBSTFromPreorderTraversal();

    int[] preorder = new int[] {8, 5, 1, 7, 10, 12};
    TreeNode tree = constructBSTFromPreorderTraversal.bstFromPreorder(preorder);
    System.out.println(tree);
  }
}
