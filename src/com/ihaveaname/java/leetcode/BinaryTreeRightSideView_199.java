package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
  class Solution {
    private void dfs(TreeNode root, int level, List<Integer> result) {
      if (root != null) {
        if (level == result.size()) result.add(root.val);
        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);
      }
    }

    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();

      dfs(root, 0, result);

      return result;
    }
  }

  public static void main(String[] args) {
    BinaryTreeRightSideView_199 binaryTreeRightSideView_199 = new BinaryTreeRightSideView_199();
    Solution solution = binaryTreeRightSideView_199.new Solution();

    TreeNode tree =
        new TreeNode(
            1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
    System.out.println(solution.rightSideView(tree));

    tree = new TreeNode(1, null, new TreeNode(3));
    System.out.println(solution.rightSideView(tree));

    tree = null;
    System.out.println(solution.rightSideView(tree));
  }
}
