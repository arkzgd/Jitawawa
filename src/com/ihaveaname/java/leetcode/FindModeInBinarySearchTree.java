package com.ihaveaname.java.leetcode;

import java.util.*;

public class FindModeInBinarySearchTree {

  private List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    if (root != null) stack.push(root);

    while (!stack.empty()) {
      while (root != null) {
        stack.push(root.left);
        root = root.left;
      }

      root = stack.pop();
      if (root != null) {
        result.add(root.val);
        stack.push(root.right);
        root = root.right;
      }
    }

    return result;
  }

  public int[] findMode(TreeNode root) {
    List<Integer> traversed = inOrder(root);
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (Integer i : traversed) {
      if (map.containsKey(i)) map.put(i, map.get(i) + 1);
      else map.put(i, 1);
    }

    List<Integer> result = new ArrayList<>();
    int curMax = 0;
    for (Integer k : map.keySet()) {
      if (map.get(k) > curMax) {
        curMax = map.get(k);
        result.clear();
        result.add(k);
      } else if (map.get(k) == curMax) result.add(k);
    }

    int[] realResult = new int[result.size()];
    for (int i = 0; i < realResult.length; i++) {
      realResult[i] = result.get(i);
    }

    return realResult;
  }

  public static void main(String[] args) {
    FindModeInBinarySearchTree fmibst = new FindModeInBinarySearchTree();

    TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(2, null, null), null));
    System.out.println(Arrays.toString(fmibst.findMode(tree)));
  }
}
