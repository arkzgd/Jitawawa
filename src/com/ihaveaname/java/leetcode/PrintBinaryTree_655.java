package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree_655 {
  class Solution {
    private List<String> dfs(TreeNode root) {
      if (root != null) {
        if (root.left == null && root.right == null) {
          List<String> l = new ArrayList<>();
          l.add(Integer.toString(root.val));
          return l;
        }
        else {
          List<String> ll = dfs(root.left);
          List<String> rl = dfs(root.right);
          merge(ll, root.val, rl);
        }
      }

      return new ArrayList<>();
    }

    private void merge(List<String> ll, int val, List<String> rl) {}

    public List<List<String>> printTree(TreeNode root) {
      List<List<String>> result = new ArrayList<>();

      dfs(root);

      return result;
    }
  }

  public static void main(String[] args) {
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    Solution solution = printBinaryTree_655.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2), null);
    System.out.println(solution.printTree(tree));
  }
}
