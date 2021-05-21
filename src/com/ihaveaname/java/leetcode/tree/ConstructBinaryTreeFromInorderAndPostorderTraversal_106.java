package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
  class Solution {
    private TreeNode buildTreeHelper(
        int[] inorder, int ilow, int ihigh, int[] postorder, int plow, int phigh) {
      if (ilow <= ihigh && plow <= phigh) {
        int root = postorder[phigh];
        TreeNode n = new TreeNode(root);
        int leftLen = 0;
        for (int i = ilow; i <= ihigh; i++) {
          if (inorder[i] == root) {
            leftLen = i - ilow;
            break;
          }
        }

        n.left =
            buildTreeHelper(inorder, ilow, ilow + leftLen - 1, postorder, plow, plow + leftLen - 1);
        n.right =
            buildTreeHelper(
                inorder, ilow + leftLen + 1, ihigh, postorder, plow + leftLen, phigh - 1);

        return n;
      }

      return null;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
  }

  public static void main(String[] args) {
    ConstructBinaryTreeFromInorderAndPostorderTraversal_106
        constructBinaryTreeFromInorderAndPostorderTraversal_106 =
            new ConstructBinaryTreeFromInorderAndPostorderTraversal_106();
    Solution solution = constructBinaryTreeFromInorderAndPostorderTraversal_106.new Solution();

    int[] inorder = new int[] {9, 3, 15, 20, 7};
    int[] postorder = new int[] {9, 15, 7, 20, 3};
    TreeNode tree = solution.buildTree(inorder, postorder);
    System.out.println(tree);
  }
}
