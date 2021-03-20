package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();

      if (root != null) queue.offer(root);
      while (!queue.isEmpty()) {
        int len = queue.size();
        for (int i = 0; i < len; i++) {
          TreeNode n = queue.poll();
          if (i == len - 1) result.add(n.val);
          if (n.left != null) queue.offer(n.left);
          if (n.right != null) queue.offer(n.right);
        }
      }

      return result;
    }
  }

  public static void main(String[] args) {
    BinaryTreeRightSideView_199 binaryTreeRightSideView_199 = new BinaryTreeRightSideView_199();
    Solution solution = binaryTreeRightSideView_199.new Solution();

    TreeNode tree = new TreeNode(
      1,
      new TreeNode(2, null, new TreeNode(5)),
      new TreeNode(3, null, new TreeNode(4))
    );
    System.out.println(solution.rightSideView(tree));

    tree = new TreeNode(1, null, new TreeNode(3));
    System.out.println(solution.rightSideView(tree));

    tree = null;
    System.out.println(solution.rightSideView(tree));
  }
}
