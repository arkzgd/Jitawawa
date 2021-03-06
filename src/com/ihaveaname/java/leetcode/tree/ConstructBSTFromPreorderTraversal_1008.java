package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class ConstructBSTFromPreorderTraversal_1008 {
  class Solution {
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
  }

  public static void main(String[] args) {
    ConstructBSTFromPreorderTraversal_1008 constructBSTFromPreorderTraversal_1008 =
        new ConstructBSTFromPreorderTraversal_1008();
    Solution solution = constructBSTFromPreorderTraversal_1008.new Solution();

    int[] preorder = new int[] {8, 5, 1, 7, 10, 12};
    TreeNode tree = solution.bstFromPreorder(preorder);
    System.out.println(tree);
  }
}
