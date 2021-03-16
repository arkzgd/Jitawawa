package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree_863 {
  class Solution {
    private int distance(TreeNode root, TreeNode target, int current) {
      if (root != null) {
        if (root.val == target.val) return current;
        else {
          int ld = distance(root.left, target, current + 1);
          if (ld == Integer.MAX_VALUE) return distance(root.right, target, current + 1);
        }
      }

      return Integer.MAX_VALUE;
    }

    private void countAtDistance(TreeNode root, int current, int target, List<Integer> result) {
      if (root != null) {
        if (current == target) result.add(root.val);
        else if (current < target) {
          countAtDistance(root.left, current + 1, target, result);
          countAtDistance(root.right, current + 1, target, result);
        }
      }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      List<Integer> result = new ArrayList<>();
      int d = distance(root.left, target, 1);
      if (d < Integer.MAX_VALUE) {
        countAtDistance(root.right, d, K - d, result);
      } else {
        d = distance(root.right, target, 1);
        countAtDistance(root.left, d, K - d, result);
      }
      countAtDistance(target, 0, K, result);

      return result;
    }
  }

  public static void main(String[] args) {
    AllNodesDistanceKInBinaryTree_863 allNodesDistanceKInBinaryTree_863 =
        new AllNodesDistanceKInBinaryTree_863();
    Solution solution = allNodesDistanceKInBinaryTree_863.new Solution();

    TreeNode subTree =
        new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
    TreeNode tree = new TreeNode(3, subTree, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
    System.out.println(solution.distanceK(tree, subTree, 2));
  }
}
