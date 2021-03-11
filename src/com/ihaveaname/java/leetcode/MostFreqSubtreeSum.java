package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFreqSubtreeSum {
  class Solution {
    private HashMap<Integer, Integer> theMap = new HashMap<>();
    private ArrayList<Integer> result = new ArrayList<>();

    private int helper(TreeNode root) {
      if (root == null) return 0;
      int left = helper(root.left);
      int right = helper(root.right);
      int sum = root.val + left + right;
      if (!theMap.containsKey(sum)) theMap.put(sum, 0);
      theMap.put(sum, theMap.get(sum) + 1);
      return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
      theMap.clear();
      result.clear();
      helper(root);
      int max = 0;
      for (Map.Entry<Integer, Integer> entry : theMap.entrySet()) {
        if (entry.getValue() > max) {
          max = entry.getValue();
          result.clear();
          result.add(entry.getKey());
        } else if (entry.getValue() == max) {
          result.add(entry.getKey());
        }
      }

      int[] r = new int[result.size()];
      int count = 0;
      for (Integer i : result) r[count++] = i;

      return r;
    }
  }

  public static void main(String[] args) {
    MostFreqSubtreeSum mostFreqSubtreeSum = new MostFreqSubtreeSum();
    Solution solution = mostFreqSubtreeSum.new Solution();

    TreeNode tree = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
    System.out.println(Arrays.toString(solution.findFrequentTreeSum(tree)));

    tree = new TreeNode(5, new TreeNode(2), new TreeNode(-5));
    System.out.println(Arrays.toString(solution.findFrequentTreeSum(tree)));
  }
}
