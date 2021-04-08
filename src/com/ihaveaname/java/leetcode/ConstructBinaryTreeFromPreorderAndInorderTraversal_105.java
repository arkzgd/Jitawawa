package com.ihaveaname.java.leetcode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
  class Solution {
    private TreeNode parAndCreate(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
      System.out.println("pl: " + pl + " pr: " + pr + " il: " + il + " ir: " + ir);
      int plength = pr - pl + 1;
      int ilength = ir - il + 1;
      if (pl >= preorder.length || ir >= inorder.length || plength <= 0 || ilength <= 0)
        return null;
      else {
        int root = preorder[pl];
        TreeNode n = new TreeNode(root);

        int i = il;
        for (; i <= ir; i++) {
          if (inorder[i] == root) break;
        }

        int npl_length = i - il;

        n.left = parAndCreate(preorder, inorder, pl + 1, pl + 1 + npl_length, il, il + npl_length);
        n.right = parAndCreate(preorder, inorder, pl + 1 + npl_length + 1, pr, i + 1, ir);

        return n;
      }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return parAndCreate(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
  }

  public static void main(String[] args) {
    ConstructBinaryTreeFromPreorderAndInorderTraversal_105
        constructBinaryTreeFromPreorderAndInorderTraversal_105 =
            new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();
    Solution solution = constructBinaryTreeFromPreorderAndInorderTraversal_105.new Solution();

    int[] preorder = new int[] {3, 9, 20, 15, 7};
    int[] inorder = new int[] {9, 3, 15, 20, 7};
    TreeNode tree = solution.buildTree(preorder, inorder);
    System.out.println(tree);
  }
}
