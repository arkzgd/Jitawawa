package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.*;

public class FindModeInBinarySearchTree {

  private void log(TreeNode pre, TreeNode current) {
    if (pre == null) System.out.print("pre: null");
    else System.out.print("pre: " + pre.val + "@" + pre.hashCode());
    System.out.print(" -> ");
    if (current == null) System.out.print("root: null");
    else System.out.print("root: " + current.val + "@" + current.hashCode());
    System.out.println(" while [count: " + count + " currMax: " + currMax + "]");
  }

  private TreeNode pre;
  private int count;
  private int currMax;
  private List<Integer> result;

  private void inOrder(TreeNode root) {
    if (root == null) return;

    inOrder(root.left);

    if (pre == null) count = 1;

    if (pre != null && pre.val == root.val) count++;
    else if (pre != null && pre.val != root.val) {
      if (count > currMax) {
        currMax = count;
        result.clear();
        result.add(pre.val);
      } else if (count == currMax) {
        result.add(pre.val);
      }
      count = 1;
    }
    pre = root;

    inOrder(root.right);
  }

  public int[] findMode(TreeNode root) {
    pre = null;
    count = 1;
    currMax = Integer.MIN_VALUE;
    result = new ArrayList<>();

    inOrder(root);
    if (pre != null) {
      if (count > currMax) {
        currMax = count;
        result.clear();
        result.add(pre.val);
      } else if (count == currMax) {
        result.add(pre.val);
      }
    }

    int[] resultArray = new int[result.size()];
    for (int i = 0; i < result.size(); i++) resultArray[i] = result.get(i);
    return resultArray;
  }

  public static void main(String[] args) {
    FindModeInBinarySearchTree fmibst = new FindModeInBinarySearchTree();

    TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(2, null, null), null));
    assert (Arrays.equals(fmibst.findMode(tree), new int[]{2}));

    tree = new TreeNode(1, null, new TreeNode(2, null, null));
    assert (Arrays.equals(fmibst.findMode(tree), new int[]{1, 2}));

    tree = new TreeNode(1, new TreeNode(1, null, null), new TreeNode(2, null, null));
    assert (Arrays.equals(fmibst.findMode(tree), new int[]{1}));

    tree = new TreeNode(2147483647, null, null);
    assert (Arrays.equals(fmibst.findMode(tree), new int[]{2147483647}));

    tree =
        new TreeNode(
            6,
            new TreeNode(
                2,
                new TreeNode(0, null, null),
                new TreeNode(4, new TreeNode(2, null, null), new TreeNode(6, null, null))),
            new TreeNode(8, new TreeNode(7, null, null), new TreeNode(9, null, null)));
    assert (Arrays.equals(fmibst.findMode(tree), new int[]{2, 6}));

    tree =
        new TreeNode(
            3,
            new TreeNode(2, null, null),
            new TreeNode(
                3,
                new TreeNode(3, null, null),
                new TreeNode(
                    4,
                    new TreeNode(4, null, null),
                    new TreeNode(5, new TreeNode(5, null, null), new TreeNode(6, null, null)))));
    assert (Arrays.equals(fmibst.findMode(tree), new int[]{3}));
  }
}
