package com.ihaveaname.java.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
  class Solution {
    public List<List<Integer>> levelOrder(NaryNode root) {
      Deque<NaryNode> queue = new LinkedList<>();
      List<List<Integer>> result = new ArrayList<>();

      if (root != null) queue.offer(root);

      while (!queue.isEmpty()) {
        int len = queue.size();
        List<Integer> levelResult = new ArrayList<>();
        for (int count = 0; count < len; count++) {
          NaryNode n = queue.poll();
          levelResult.add(n.val);
          for (NaryNode c : n.children) queue.offer(c);
        }
        result.add(levelResult);
      }

      return result;
    }
  }
}
