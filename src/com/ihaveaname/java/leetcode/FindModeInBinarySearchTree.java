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
    if (traversed.isEmpty()) return new int[0];

    List<Integer> result = new ArrayList<>();
    int low = 0;
    int high = 0;
    int curMax = 0;
    do {
      if (!traversed.get(high).equals(traversed.get(low))) {
        int size = high - low;
        if (size > curMax) {
          result.clear();
          result.add(traversed.get(low));
          curMax = size;
        } else if (size == curMax) {
          result.add(traversed.get(low));
        }
        low = high;
      }

      if (high == traversed.size() - 1) {
        if (traversed.get(high).equals(traversed.get(low))) {
          int size = high - low + 1;
          if (size > curMax) {
            result.clear();
            result.add(traversed.get(low));
          } else if (size == curMax) {
            result.add(traversed.get(low));
          }
        }
      }

      high++;
    } while (high < traversed.size());

    int[] realResult = new int[result.size()];
    for (int i = 0; i < realResult.length; i++) realResult[i] = result.get(i);

    return realResult;
  }

  public int[] findModeTest(List<Integer> traversed) {

    if (traversed.isEmpty()) return new int[0];

    List<Integer> result = new ArrayList<>();
    int low = 0;
    int high = 0;
    int curMax = 1;
    do {
      if (!traversed.get(high).equals(traversed.get(low))) {
        int size = high - low;
        if (size > curMax) {
          result.clear();
          result.add(traversed.get(low));
          curMax = size;
        } else if (size == curMax) {
          result.add(traversed.get(low));
        }
        low = high;
      }

      if (high == traversed.size() - 1) {
        if (traversed.get(high).equals(traversed.get(low))) {
          int size = high - low + 1;
          if (size > curMax) {
            result.clear();
            result.add(traversed.get(low));
          } else if (size == curMax) {
            result.add(traversed.get(low));
          }
        }
      }

      high++;
    } while (high < traversed.size());

    int[] realResult = new int[result.size()];
    for (int i = 0; i < realResult.length; i++) realResult[i] = result.get(i);

    return realResult;
  }

  public static void main(String[] args) {
    FindModeInBinarySearchTree fmibst = new FindModeInBinarySearchTree();

    TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(2, null, null), null));
    System.out.println(Arrays.toString(fmibst.findMode(tree)));

    tree = new TreeNode(1, null, new TreeNode(2, null, null));
    System.out.println(Arrays.toString(fmibst.findMode(tree)));

    tree = new TreeNode(1, new TreeNode(1, null, null), new TreeNode(2, null, null));
    System.out.println(Arrays.toString(fmibst.findMode(tree)));

    tree = new TreeNode(2147483647, null, null);
    System.out.println(Arrays.toString(fmibst.findMode(tree)));

    List<Integer> traversed = Arrays.asList(-20, -19, -18, -17, -14, -14, -10, -9, -1, 0, 1, 9, 10, 14, 14, 17, 17, 17, 18, 18, 18, 20);
    System.out.println(Arrays.toString(fmibst.findModeTest(traversed)));
  }
}
