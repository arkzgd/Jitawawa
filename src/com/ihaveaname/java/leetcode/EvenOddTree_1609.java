package com.ihaveaname.java.leetcode;

import java.util.ArrayList;

public class EvenOddTree_1609 {
  class Solution {
    private boolean helper(TreeNode root, int level, ArrayList<Integer> ledger) {
      if (root != null) {
        if (level == ledger.size()) {
          ledger.add(-1);
        }

        int val = ledger.get(level);
        if ((level & 1) == 0) {
          if ((root.val & 1) == 0) {
            return false;
          }

          if (val != -1 && root.val <= val) {
            return false;
          }
        } else {
          if ((root.val & 1) == 1) {
            return false;
          }

          if (val != -1 && root.val >= val) {
            return false;
          }
        }
        ledger.set(level, root.val);

        if (!helper(root.left, level + 1, ledger)) {
          return false;
        }
        if (!helper(root.right, level + 1, ledger)) {
          return false;
        }
      }

      return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
      ArrayList<Integer> ledger = new ArrayList<>();
      return helper(root, 0, ledger);
    }
  }

  public static void main(String[] args) {
    EvenOddTree_1609 evenOddTree_1609 = new EvenOddTree_1609();
    Solution solution = evenOddTree_1609.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null),
            new TreeNode(
                4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2))));
    System.out.println(solution.isEvenOddTree(tree));

    tree =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(3), new TreeNode(3)),
            new TreeNode(2, new TreeNode(7), null));
    System.out.println(solution.isEvenOddTree(tree));

    tree =
        new TreeNode(
            5,
            new TreeNode(9, new TreeNode(3), new TreeNode(5)),
            new TreeNode(1, new TreeNode(7), null));
    System.out.println(solution.isEvenOddTree(tree));

    tree = new TreeNode(1);
    System.out.println(solution.isEvenOddTree(tree));
  }
}
