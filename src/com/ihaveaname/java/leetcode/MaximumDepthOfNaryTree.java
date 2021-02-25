package com.ihaveaname.java.leetcode;

public class MaximumDepthOfNaryTree {
  public int maxDepth(Node root) {
    int max = 0;
    if (root != null) {
      for (Node c : root.children) {
        int d = maxDepth(c);
        if (d > max) max = d;
      }
      return max + 1;
    }

    return 0;
  }
}