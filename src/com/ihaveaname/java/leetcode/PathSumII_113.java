package com.ihaveaname.java.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {
  class Solution {
    private List<LinkedList<Integer>> helper(TreeNode root, int targetSum) {
      List<LinkedList<Integer>> result = new LinkedList<>();
      if (root != null) {
        List<LinkedList<Integer>> ll = helper(root.left, targetSum - root.val);
        List<LinkedList<Integer>> rl = helper(root.right, targetSum - root.val);

        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
          LinkedList<Integer> l = new LinkedList<>();
          l.add(root.val);
          result.add(l);
        } else {
          if (root.left != null) {
            for (LinkedList l : ll) {
              l.addFirst(root.val);
            }
          }

          if (root.right != null) {
            for (LinkedList l : rl) {
              l.addFirst(root.val);
            }
          }

          result.addAll(ll);
          result.addAll(rl);
        }
      }

      return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<List<Integer>> result = new LinkedList<>();
      result.addAll(helper(root, targetSum));

      return result;
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
