package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();

      if (root != null) queue.offer(root);
      while (!queue.isEmpty()) {
        int len = queue.size();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < len; i++) {
          TreeNode n = queue.poll();
          l.add(n.val);
          if (n.left != null) queue.offer(n.left);
          if (n.right != null) queue.offer(n.right);
        }
        result.add(l);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversal_102 binaryTreeLevelOrderTraversal_102 =
        new BinaryTreeLevelOrderTraversal_102();
    Solution solution = binaryTreeLevelOrderTraversal_102.new Solution();

    TreeNode tree =
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    System.out.println(solution.levelOrder(tree));
  }
}
