package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree_863 {
  class Solution {
    private int levelOfTarget = -1;
    private List<Integer> result = new ArrayList<>();

    private boolean pathToTarget(TreeNode root, TreeNode target, int level, int K) {
      if (root != null && levelOfTarget == -1) {
        boolean lr = pathToTarget(root.left, target, level + 1, K);
        boolean rr = pathToTarget(root.right, target, level + 1, K);
        if (!lr && !rr) {
          if (root == target) {
            levelOfTarget = level;
            if (K == 0) result.add(root.val);
            else collectK(root, 0, K);
            return true;
          }
        } else {
          int lengthSoFar = levelOfTarget - level;
          if (levelOfTarget != -1 && lengthSoFar == K) result.add(root.val);
          else if (lengthSoFar < K) {
            if (lr) collectK(root.right, lengthSoFar + 1, K);
            else collectK(root.left, lengthSoFar + 1, K);
          }
        }

        return lr || rr;
      }

      return false;
    }

    private void collectK(TreeNode root, int length, int K) {
      if (root != null && K > 0) {
        if (length == K) result.add(root.val);
        collectK(root.left, length + 1, K);
        collectK(root.right, length + 1, K);
      }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      levelOfTarget = -1;
      result = new ArrayList<>();

      pathToTarget(root, target, 0, K);

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

    subTree = new TreeNode(3);
    tree = new TreeNode(0, new TreeNode(2), new TreeNode(1, subTree, null));
    System.out.println(solution.distanceK(tree, subTree, 3));

    subTree = new TreeNode(3, null, new TreeNode(4));
    tree = new TreeNode(0, new TreeNode(1, null, new TreeNode(2, null, subTree)), null);
    System.out.println(solution.distanceK(tree, subTree, 0));

    subTree = new TreeNode(2);
    tree = new TreeNode(0, subTree, new TreeNode(1, new TreeNode(3, new TreeNode(4), null), null));
    System.out.println(solution.distanceK(tree, subTree, 0));
  }
}
