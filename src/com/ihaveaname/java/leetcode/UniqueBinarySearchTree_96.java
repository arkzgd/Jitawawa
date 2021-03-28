package com.ihaveaname.java.leetcode;

public class UniqueBinarySearchTree_96 {
  class Solution {
    public int numTrees(int n) {
      if (n == 0) return 1;
      if (n == 1) return 1;
      if (n == 2) return 2;
      int count = 0;
      for (int i = 0; i < n; i++) count += (numTrees(i) * numTrees(n - 1 - i));

      return count;
    }
  }

  public static void main(String[] args) {
    UniqueBinarySearchTree_96 uniqueBinarySearchTree_96 = new UniqueBinarySearchTree_96();
    Solution solution = uniqueBinarySearchTree_96.new Solution();

    System.out.println(solution.numTrees(3));
    System.out.println(solution.numTrees(4));
    System.out.println(solution.numTrees(5));
    System.out.println(solution.numTrees(6));
    System.out.println(solution.numTrees(7));
    System.out.println(solution.numTrees(19));
  }
}
