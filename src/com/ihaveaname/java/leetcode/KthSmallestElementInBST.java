package com.ihaveaname.java.leetcode;

public class KthSmallestElementInBST {
  class Solution {
    private int rank = 0;
    private int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
      if (root != null) {
        kthSmallest(root.left, k);
        if (++rank == k) ans = root.val;
        kthSmallest(root.right, k);
      }

      return ans;
    }
  }

  public static void main(String[] args) {
    KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
    Solution solution = kthSmallestElementInBST.new Solution();

    TreeNode tree = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
    System.out.println(solution.kthSmallest(tree, 1));

    solution = kthSmallestElementInBST.new Solution();
    tree =
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
            new TreeNode(6));
    System.out.println(solution.kthSmallest(tree, 3));

    solution = kthSmallestElementInBST.new Solution();
    tree =
      new TreeNode(
        4,
        new TreeNode(2, null, new TreeNode(3)),
        new TreeNode(5)
      );
    System.out.println(solution.kthSmallest(tree, 1));
  }
}
