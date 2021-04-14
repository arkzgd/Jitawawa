package com.ihaveaname.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SumRootToLeafNumbers_129 {
  class Solution {
    private Deque<Integer> addUpNumber(TreeNode root) {
      if (root != null) {
        if (root.left == null && root.right == null) {
          Deque<Integer> t = new LinkedList<>();
          t.offer(root.val);
          return t;
        } else {
          Deque<Integer> l = addUpNumber(root.left);
          l.offerFirst(root.val);
          Deque<Integer> r = addUpNumber(root.right);
          r.offerFirst(root.val);

          Deque<Integer> merged = new LinkedList<>();
          int c = 0;
          while (!l.isEmpty() && !r.isEmpty()) {
            int li = l.pollLast();
            int ri = r.pollLast();
            c = (li + ri + c) / 10;
            merged.offerFirst((li + ri + c) % 10);
          }
          while (!l.isEmpty()) {
            int li = l.pollLast();
            c = (li + c) / 10;
            merged.offerFirst((li + c) % 10);
          }
          while (!r.isEmpty()) {
            int ri = r.pollLast();
            c = (ri + c) / 10;
            merged.offerFirst((ri + c) % 10);
          }
          merged.offerFirst(c);

          return merged;
        }
      }

      return new LinkedList<>();
    }

    public int sumNumbers(TreeNode root) {
      Deque<Integer> q = addUpNumber(root);
      int index = 0;
      int result = 0;
      while (!q.isEmpty()) {
        result += Math.pow(10, index) * q.pollLast();
        index++;
      }

      return result;
    }
  }

  public static void main(String[] args) {
    SumRootToLeafNumbers_129 sumRootToLeafNumbers_129 = new SumRootToLeafNumbers_129();
    Solution solution = sumRootToLeafNumbers_129.new Solution();

    TreeNode tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(solution.sumNumbers(tree));

    tree = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
    System.out.println(solution.sumNumbers(tree));
  }
}
