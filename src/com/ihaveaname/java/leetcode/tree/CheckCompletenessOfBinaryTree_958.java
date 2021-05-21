package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree_958 {
  class Solution {
    public boolean isCompleteTree(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      if (root != null) queue.offer(root);

      boolean firstLeaf = false;
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode n = queue.poll();

          if ((n.left != null || n.right != null) && firstLeaf) return false;
          if (n.left == null || n.right == null) firstLeaf = true;
          if (n.left == null && n.right != null) return false;

          if (n.left != null) queue.offer(n.left);
          if (n.right != null) queue.offer(n.right);
        }
      }

      return true;
    }
  }

  public static void main(String[] args) {
    CheckCompletenessOfBinaryTree_958 checkCompletenessOfBinaryTree_958 =
        new CheckCompletenessOfBinaryTree_958();
    Solution solution = checkCompletenessOfBinaryTree_958.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));
    System.out.println(solution.isCompleteTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, null, new TreeNode(6)));
    System.out.println(solution.isCompleteTree(tree));

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(5), null),
            new TreeNode(3, new TreeNode(7), new TreeNode(8)));
    System.out.println(solution.isCompleteTree(tree));

    tree = new TreeNode(1, new TreeNode(2, new TreeNode(5), null), new TreeNode(3));
    System.out.println(solution.isCompleteTree(tree));
  }
}
