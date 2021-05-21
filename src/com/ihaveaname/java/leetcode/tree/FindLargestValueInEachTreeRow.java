package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
  class Solution {
    private void helper(TreeNode root, int level, ArrayList<Integer> result) {
      if (root != null) {
        if (level == result.size()) result.add(root.val);
        else if (result.get(level) < root.val) result.set(level, root.val);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
      }
    }

    public List<Integer> largestValues(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<>();
      helper(root, 0, result);
      return result;
    }
  }

  public static void main(String[] args) {
    FindLargestValueInEachTreeRow findLargestValueInEachTreeRow =
        new FindLargestValueInEachTreeRow();
    Solution solution = findLargestValueInEachTreeRow.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(3, new TreeNode(5), new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(9)));
    System.out.println(solution.largestValues(tree));

    tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(solution.largestValues(tree));

    tree = new TreeNode(1);
    System.out.println(solution.largestValues(tree));

    tree = new TreeNode(1, null, new TreeNode(2));
    System.out.println(solution.largestValues(tree));

    tree = null;
    System.out.println(solution.largestValues(tree));
  }
}
