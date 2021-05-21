package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
  class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      int level = 0;
      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      if (root != null) queue.offer(root);

      while (!queue.isEmpty()) {
        int size = queue.size();
        if (level % 2 == 0) {
          List<Integer> l = new ArrayList<>();
          for (int i = 0; i < size; i++) {
            TreeNode n = queue.poll();
            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
            l.add(n.val);
          }
          level++;
          result.add(l);
        } else {
          Stack<Integer> stack = new Stack<>();
          List<Integer> l = new ArrayList<>();
          for (int i = 0; i < size; i++) {
            TreeNode n = queue.poll();
            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
            stack.push(n.val);
          }
          while (!stack.isEmpty()) l.add(stack.pop());
          level++;
          result.add(l);
        }
      }

      return result;
    }
  }

  public static void main(String[] args) {
    BinaryTreeZigzagLevelOrderTraversal_103 binaryTreeZigzagLevelOrderTraversal_103 =
        new BinaryTreeZigzagLevelOrderTraversal_103();
    Solution solution = binaryTreeZigzagLevelOrderTraversal_103.new Solution();

    TreeNode tree =
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    System.out.println(solution.zigzagLevelOrder(tree));
  }
}
