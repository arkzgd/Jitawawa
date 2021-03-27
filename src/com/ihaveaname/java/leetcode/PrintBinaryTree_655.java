package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree_655 {
  class Solution {
    private List<List<String>> result = new ArrayList<>();

    private int height(TreeNode root) {
      if (root != null) return Math.max(height(root.left), height(root.right)) + 1;

      return 0;
    }

    private void dfs(TreeNode root, int level, int start, int end) {
      if (root != null) {
        int mid = (start + end) / 2;
        dfs(root.left, level + 1, start, mid - 1);
        dfs(root.right, level + 1, mid + 1, end);

        result.get(level).set(mid, Integer.toString(root.val));
      }
    }

    public List<List<String>> printTree(TreeNode root) {
      result.clear();
      int h = height(root);
      int length = (2 << h - 1) - 1;
      result.clear();
      for (int row = 0; row < h; row++) {
        List<String> l = new ArrayList<>();
        for (int col = 0; col < length; col++) {
          l.add("");
        }
        result.add(l);
      }

      dfs(root, 0, 0, length - 1);

      return result;
    }
  }

  public static void main(String[] args) {
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    Solution solution = printBinaryTree_655.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2), null);
    List<List<String>> printed = solution.printTree(tree);
    for (List<String> l : printed) System.out.println(l);

    tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
    printed = solution.printTree(tree);
    for (List<String> l : printed) System.out.println(l);

    tree =
        new TreeNode(
            1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(5));
    printed = solution.printTree(tree);
    for (List<String> l : printed) System.out.println(l);
  }
}
