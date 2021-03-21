package com.ihaveaname.java.leetcode;

import java.util.ArrayList;

public class NumberOfGoodLeafNodesPairs_1530 {
  class Solution {
    public int result;

    private ArrayList<Integer> dfs(TreeNode root, final int distance) {
      if (root != null) {
        if (root.left == null && root.right == null) {
          ArrayList<Integer> l = new ArrayList<>();
          l.add(0);
          return l;
        } else {
          ArrayList<Integer> arrayList = new ArrayList<>();
          if (root.left != null) {
            ArrayList<Integer> lm = dfs(root.left, distance);
            for (int i = 0; i < lm.size(); i++) lm.set(i, lm.get(i) + 1);
            arrayList.addAll(lm);

            for (Integer e : lm) {
              if (e < distance) {
                result += dfs_l(root.right, distance - e);
              }
            }
          }

          if (root.right != null) {
            ArrayList<Integer> rm = dfs(root.right, distance);
            for (int i = 0; i < rm.size(); i++) rm.set(i, rm.get(i) + 1);
            arrayList.addAll(rm);

            for (Integer e : rm) {
              if (e < distance) {
                result += dfs_l(root.left, distance - e);
              }
            }
          }

          return arrayList;
        }
      }

      return new ArrayList<>();
    }

    private int dfs_l(TreeNode root, int length) {
      if (root != null && length > 0) {
        if (root.left == null && root.right == null) {
          return 1;
        } else {
          int lc = 0;
          if (root.left != null) {
            lc = dfs_l(root.left, length - 1);
          }

          int rc = 0;
          if (root.right != null) {
            rc = dfs_l(root.right, length - 1);
          }

          return lc + rc;
        }
      } else return 0;
    }

    public int countPairs(TreeNode root, int distance) {
      result = 0;
      dfs(root, distance);

      return result / 2;
    }
  }

  public static void main(String[] args) {
    NumberOfGoodLeafNodesPairs_1530 numberOfGoodLeafNodesPairs_1530 =
        new NumberOfGoodLeafNodesPairs_1530();
    Solution solution = numberOfGoodLeafNodesPairs_1530.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
    System.out.println(solution.countPairs(tree, 3));

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    System.out.println(solution.countPairs(tree, 3));

    tree =
        new TreeNode(
            7,
            new TreeNode(1, new TreeNode(6), null),
            new TreeNode(4, new TreeNode(5), new TreeNode(3, new TreeNode(2), null)));
    System.out.println(solution.countPairs(tree, 3));

    tree = new TreeNode(100);
    System.out.println(solution.countPairs(tree, 1));

    tree = new TreeNode(1, new TreeNode(1), new TreeNode(1));
    System.out.println(solution.countPairs(tree, 2));
  }
}
