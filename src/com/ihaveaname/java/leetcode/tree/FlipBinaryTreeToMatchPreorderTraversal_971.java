package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipBinaryTreeToMatchPreorderTraversal_971 {
  class Solution {
    List<Integer> result;
    boolean unresolvable;
    Map<Integer, Integer> where;

    private boolean validate(TreeNode root, int b, boolean flag) {
      if (root != null) {
        if (flag && where.get(root.val) > b) {
          return false;
        } else if (!flag && where.get(root.val) < b) {
          return false;
        } else {
          return validate(root.left, b, flag) && validate(root.right, b, flag);
        }
      }

      return true;
    }

    private void dfs(TreeNode root) {
      if (root != null && !unresolvable) {
        if (root.left != null && root.right != null) {
          int li = where.get(root.left.val);
          int rooti = where.get(root.val);
          int ri = where.get(root.right.val);
          if (li > ri) {
            result.add(root.val);
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
          }
          if (!(rooti < li && rooti < ri)
              || !validate(root.left, where.get(root.right.val), true)
              || !validate(root.right, where.get(root.left.val), false)) {
            unresolvable = true;
            result.clear();
            result.add(-1);
          }
        } else {
          if (root.left != null) {
            int li = where.get(root.left.val);
            int rooti = where.get(root.val);
            if (!(rooti < li)) {
              unresolvable = true;
              result.clear();
              result.add(-1);
            }
          } else if (root.right != null) {
            int rooti = where.get(root.val);
            int ri = where.get(root.right.val);
            if (!(rooti < ri)) {
              unresolvable = true;
              result.clear();
              result.add(-1);
            }
          }
        }

        dfs(root.left);
        dfs(root.right);
      }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
      result = new ArrayList<>();
      where = new HashMap<>();
      unresolvable = false;
      for (int i = 0; i < voyage.length; i++) where.put(voyage[i], i);
      dfs(root);

      return result;
    }
  }

  public static void main(String[] args) {
    FlipBinaryTreeToMatchPreorderTraversal_971 flipBinaryTreeToMatchPreorderTraversal_971 =
        new FlipBinaryTreeToMatchPreorderTraversal_971();
    Solution solution = flipBinaryTreeToMatchPreorderTraversal_971.new Solution();

    TreeNode tree =
        new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
    int[] voyage = new int[] {1, 3, 4, 5, 2};
    System.out.println(solution.flipMatchVoyage(tree, voyage));

    tree = new TreeNode(1, new TreeNode(2), null);
    voyage = new int[] {2, 1};
    System.out.println(solution.flipMatchVoyage(tree, voyage));

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    voyage = new int[] {1, 3, 2};
    System.out.println(solution.flipMatchVoyage(tree, voyage));

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    voyage = new int[] {1, 2, 3};
    System.out.println(solution.flipMatchVoyage(tree, voyage));

    tree =
        new TreeNode(
            7,
            new TreeNode(1),
            new TreeNode(5, new TreeNode(3), new TreeNode(2, new TreeNode(6), new TreeNode(4))));
    voyage = new int[] {7, 5, 2, 4, 3, 6, 1};
    System.out.println(solution.flipMatchVoyage(tree, voyage));
  }
}
