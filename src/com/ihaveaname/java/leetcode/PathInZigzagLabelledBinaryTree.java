package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
  class Solution {
    private int level(int label) {
      int l;
      for (l = 0; ; l++) {
        if (label >= (int) Math.pow(2, l) && label < (int) Math.pow(2, l + 1)) break;
      }

      return l + 1;
    }

    private int index(int label) {
      int l = level(label);
      if (l % 2 == 1) return label - 1;
      else {
        int si = (int) Math.pow(2, l - 1) - 1;
        int el = (int) Math.pow(2, l) - 1;
        return si + el - label;
      }
    }

    private int label(int index) {
      int l = level(index + 1);
      if (l % 2 == 1) return index + 1;
      else {
        int si = (int) Math.pow(2, l - 1) - 1;
        int el = (int) Math.pow(2, l) - 1;
        return el - (index - si);
      }
    }

    public List<Integer> pathInZigZagTree(int label) {
      Deque<Integer> result = new LinkedList<>();
      result.offerFirst(label);
      while (index(label) > 0) {
        int parent = (index(label) - 1) / 2;
        label = label(parent);
        result.offerFirst(label);
      }

      List<Integer> realResult = new ArrayList<>();
      realResult.addAll(result);
      return realResult;
    }
  }

  public static void main(String[] args) {
    PathInZigzagLabelledBinaryTree pathInZigzagLabelledBinaryTree =
        new PathInZigzagLabelledBinaryTree();
    Solution solution = pathInZigzagLabelledBinaryTree.new Solution();

    System.out.println(solution.pathInZigZagTree(14));
    System.out.println(solution.pathInZigZagTree(26));
    System.out.println(solution.pathInZigZagTree(1000000));
  }
}
