package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {
  class Solution {
    private List<List<Integer>> helper(TreeNode root, int targetSum) {
      List<List<Integer>> result = new ArrayList<>();
      if (root != null) {
        List<List<Integer>> ll = helper(root.left, targetSum - root.val);
        List<List<Integer>> rl = helper(root.right, targetSum - root.val);

        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
          LinkedList<Integer> l = new LinkedList<>();
          l.add(root.val);
          result.add(l);
        } else {
          if (root.left != null) {
            List<List<Integer>> newll = new ArrayList<>();
            for (List l : ll) {
              List<Integer> newl = new ArrayList<>();
              newl.add(root.val);
              newl.addAll(l);
              newll.add(newl);
            }
            ll = newll;
          }

          if (root.right != null) {
            List<List<Integer>> newrl = new ArrayList<>();
            for (List l : rl) {
              List<Integer> newl = new ArrayList<>();
              newl.add(root.val);
              newl.addAll(l);
              newrl.add(newl);
            }
            rl = newrl;
          }

          result.addAll(ll);
          result.addAll(rl);
        }
      }

      return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      return helper(root, targetSum);
    }
  }

  public static void main(String[] args) {
    PathSumII_113 pathSumII_113 = new PathSumII_113();
    Solution solution = pathSumII_113.new Solution();

    TreeNode tree =
        new TreeNode(
            5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
    System.out.println(solution.pathSum(tree, 22));

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(solution.pathSum(tree, 5));

    tree = new TreeNode(1, new TreeNode(2), null);
    System.out.println(solution.pathSum(tree, 0));
  }
}
