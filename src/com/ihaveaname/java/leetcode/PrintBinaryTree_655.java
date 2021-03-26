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
        } else {
          List<String> ll = dfs(root.left);
          List<String> rl = dfs(root.right);
          return merge(ll, root.val, rl);
        }
      }

      List<String> l = new ArrayList<>();
      l.add("");
      return l;
    }

    private List<String> merge(List<String> ll, int val, List<String> rl) {
      if (ll.size() < rl.size()) {
        int count = (rl.size() - ll.size()) / 2;
        List<String> nll = new ArrayList<>();
        for (int i = 0; i < count; i++) nll.add("");
        nll.addAll(ll);
        for (int i = 0; i < count; i++) nll.add("");
        ll = nll;
      } else if (ll.size() > rl.size()) {
        int count = (ll.size() - rl.size()) / 2;
        List<String> nrl = new ArrayList<>();
        for (int i = 0; i < count; i++) nrl.add("");
        nrl.addAll(rl);
        for (int i = 0; i < count; i++) nrl.add("");
        rl = nrl;
      }

      ll.add(Integer.toString(val));
      ll.addAll(rl);

      return ll;
    }

    public List<List<String>> printTree(TreeNode root) {
      List<List<String>> result = new ArrayList<>();

      System.out.println(dfs(root));

      return result;
    }
  }

  public static void main(String[] args) {
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    Solution solution = printBinaryTree_655.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2), null);
    System.out.println(solution.printTree(tree));

    tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
    System.out.println(solution.printTree(tree));

    tree =
        new TreeNode(
            1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(5));
    System.out.println(solution.printTree(tree));
  }
}
