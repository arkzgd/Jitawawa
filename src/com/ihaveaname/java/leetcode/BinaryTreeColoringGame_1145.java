package com.ihaveaname.java.leetcode;

public class BinaryTreeColoringGame_1145 {
  class Solution {
    private boolean win;

    private int helper(TreeNode root, TreeNode parent, int n, int x) {
      if (root != null && !win) {
        int lc = helper(root.left, root, n, x);
        int rc = helper(root.right, root, n, x);
        if (root.val == x) {
          int pc = n - 1 - lc - rc;
          win = Math.max(pc, Math.max(lc, rc)) > n / 2;
        } else return lc + rc + 1;
      }

      return 0;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
      win = false;
      helper(root, null, n, x);
      return win;
    }
  }

  public static void main(String[] args) {
    BinaryTreeColoringGame_1145 binaryTreeColoringGame_1145 = new BinaryTreeColoringGame_1145();
    Solution solution = binaryTreeColoringGame_1145.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(4, new TreeNode(8), new TreeNode(9)),
                new TreeNode(5, new TreeNode(10), new TreeNode(11))),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    System.out.println(solution.btreeGameWinningMove(tree, 11, 3));

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(solution.btreeGameWinningMove(tree, 3, 2));

    tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    System.out.println(solution.btreeGameWinningMove(tree, 5, 1));

    tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    System.out.println(solution.btreeGameWinningMove(tree, 5, 4));

    tree =
        new TreeNode(
            6,
            new TreeNode(
                3,
                new TreeNode(7),
                new TreeNode(
                    4, null, new TreeNode(2, null, new TreeNode(1, null, new TreeNode(5))))),
            null);
    System.out.println(solution.btreeGameWinningMove(tree, 7, 3));
  }
}
