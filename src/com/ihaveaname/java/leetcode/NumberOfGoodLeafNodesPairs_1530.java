package com.ihaveaname.java.leetcode;

import java.util.ArrayList;

public class NumberOfGoodLeafNodesPairs_1530 {
  class Solution {
    public int result;

    private ArrayList<Integer> dfs(TreeNode root, final int distance) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      if (root != null) {
        if (root.left == null && root.right == null) {
          ArrayList<Integer> l = new ArrayList<>();
          l.add(0);
          return l;
        }

        if (root.left != null) {
          ArrayList<Integer> lm = dfs(root.left, distance);
          for (int i = 0; i < lm.size(); i++) lm.set(i, lm.get(i) + 1);
          arrayList.addAll(lm);
        }

        for (Integer e : arrayList) {
          if (distance - e > 0) result += bfs(root.right, distance - e);
        }

        if (root.right != null) {
          ArrayList<Integer> rm = dfs(root.right, distance);
          for (int i = 0; i < rm.size(); i++) rm.set(i, rm.get(i) + 1);
          arrayList.addAll(rm);
        }
      }

      return arrayList;
    }

    private int bfs(TreeNode root, int length) {
      if (root != null && length > 0) {
        if (root.left == null && root.right == null) {
          return 1;
        } else {
          int lc = 0;
          if (root.left != null) {
            lc = bfs(root.left, length - 1);
          }

          int rc = 0;
          if (root.right != null) {
            rc = bfs(root.right, length - 1);
          }

          return lc + rc;
        }
      } else return 0;
    }

    public int countPairs(TreeNode root, int distance) {
      result = 0;
      dfs(root, distance);

      return result;
    }
  }

  public static void main(String[] args) {
    NumberOfGoodLeafNodesPairs_1530 numberOfGoodLeafNodesPairs_1530 =
        new NumberOfGoodLeafNodesPairs_1530();
    Solution solution = numberOfGoodLeafNodesPairs_1530.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
    assert solution.countPairs(tree, 3) == 1;

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    assert solution.countPairs(tree, 3) == 2;

    tree =
        new TreeNode(
            7,
            new TreeNode(1, new TreeNode(6), null),
            new TreeNode(4, new TreeNode(5), new TreeNode(3, new TreeNode(2), null)));
    assert solution.countPairs(tree, 3) == 1;

    tree = new TreeNode(100);
    assert solution.countPairs(tree, 1) == 0;

    tree = new TreeNode(1, new TreeNode(1), new TreeNode(1));
    assert solution.countPairs(tree, 2) == 1;

    tree = new TreeNode(1, new TreeNode(84, new TreeNode(80), new TreeNode(61)), null);
    assert solution.countPairs(tree, 2) == 1;
  }
}
