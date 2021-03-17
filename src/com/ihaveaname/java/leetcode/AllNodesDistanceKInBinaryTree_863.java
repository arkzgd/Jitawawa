package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllNodesDistanceKInBinaryTree_863 {
  class Solution {
    private boolean pathToTarget(TreeNode root, TreeNode target, Stack<TreeNode> path) {
      if (root != null) {
        path.push(root);
        if (root == target) {
          return true;
        } else {
          if (pathToTarget(root.left, target, path)) return true;
          else if (pathToTarget(root.right, target, path)) return true;
          else path.pop();
        }
      }

      return false;
    }

    private void collectKSiblins(Stack<TreeNode> path, int K, List<Integer> result) {
      int l = 0;
      while (!path.isEmpty()) {
        TreeNode n = path.pop();
        if (l == K) {
          result.add(n.val);
          return;
        } else {
          if (!path.isEmpty()) {
            TreeNode p = path.peek();
            if (n == p.left) collectK(p.right, l + 1, K - l - 1, result);
            if (n == p.right) collectK(p.left, l + 1, K - l - 1, result);
          }
        }
        l++;
      }
    }

    private void collectK(TreeNode root, int length, int K, List<Integer> result) {
      if (root != null) {
        if (length == K) result.add(root.val);
        collectK(root.left, length + 1, K, result);
        collectK(root.right, length + 1, K, result);
      }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      List<Integer> result = new ArrayList<>();
      collectK(target, 0, K, result);

      Stack<TreeNode> path = new Stack<>();
      pathToTarget(root, target, path);
      collectKSiblins(path, K, result);

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
