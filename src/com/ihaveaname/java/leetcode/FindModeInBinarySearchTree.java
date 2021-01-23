package com.ihaveaname.java.leetcode;

import javax.swing.*;
import java.util.*;

public class FindModeInBinarySearchTree {

  private void log(TreeNode pre, TreeNode current) {
    if (pre == null) System.out.print("pre: null");
    else System.out.print("pre: " + pre.val);
    System.out.print(" -> ");
    if (current == null) System.out.print("root: null");
    else System.out.print("root: " + current.val);
    System.out.println(" , count: " + count + " currMax: " + currMax);
  }

  TreeNode pre = null;
  int count = 1;
  int currMax = 1;
  List<Integer> result = new ArrayList<>();

  private void inOrder(TreeNode root) {
    if (root == null) return;

    inOrder(root.left);

    if (pre != null) {
      if (pre.val == root.val) {
        count++;
      } else {
        if (count > currMax) {
          currMax = count;
          result.clear();
          result.add(pre.val);
          count = 1;
        } else {
          result.add(pre.val);
          count = 1;
        }
      }
    }
    pre = root;

    inOrder(root.right);
  }

  public int[] findMode(TreeNode root) {
    pre = null;
    count = 1;
    currMax = 1;
    result.clear();

    inOrder(root);
    int[] resultArray = new int[result.size()];
    for (int i = 0; i < result.size(); i++) resultArray[i] = result.get(i);
    return resultArray;
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
  }
}
