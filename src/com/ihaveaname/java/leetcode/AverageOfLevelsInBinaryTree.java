package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
  private void helper(TreeNode root, int level, List<List<Double>> results) {
    if (root != null) {
      if (level == results.size()) results.add(new ArrayList<>());
      results.get(level).add(Double.valueOf(root.val));
      helper(root.left, level + 1, results);
      helper(root.right, level + 1, results);
    }
  }

  public List<Double> averageOfLevels(TreeNode root) {
    List<List<Double>> results = new ArrayList<>();
    List<Double> result = new ArrayList<>();
    helper(root, 0, results);
    for (List<Double> l : results) {
      Double sum = 0.0;
      for (Double d : l) {
        sum += d;
      }
      result.add(sum / l.size());
    }

    return result;
  }

  public static void main(String[] args) {
    AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();

    TreeNode tree =
        new TreeNode(
            3,
            new TreeNode(9, null, null),
            new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
    System.out.println(averageOfLevelsInBinaryTree.averageOfLevels(tree));
  }
}
