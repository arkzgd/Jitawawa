package com.ihaveaname.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TwoSum_BST {

  static class TreeNode {
    int val;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode left;

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean findTarget(TreeNode root, int k) {
    return search(root, k);
  }

  private boolean search(TreeNode root, int k) {
    Queue<TreeNode> levelQueue = new LinkedList<>();
    if (root != null) levelQueue.offer(root);

    TreeNode node;
    while ((node = levelQueue.poll()) != null) {
      if (k < 2 * node.val) {
        if (search_in_tree(node.left, k - node.val)) return true;
      } else if (k > 2 * node.val) {
        if (search_in_tree(root, k - node.val)) return true;
      }

      if (node.left != null) levelQueue.offer(node.left);
      if (node.right != null) levelQueue.offer(node.right);
    }

    return false;
  }

  private boolean search_in_tree(TreeNode root, int k) {
    while (root != null) {
      if (root.val > k) root = root.left;
      else if (root.val < k) root = root.right;
      else return true;
    }

    return false;
  }

  public static void main(String[] args) {
    TwoSum_BST twoSum = new TwoSum_BST();
    TreeNode root =
        new TreeNode(
            5,
            new TreeNode(3, new TreeNode(2, null, null), new TreeNode(4, null, null)),
            new TreeNode(6, null, new TreeNode(7, null, null)));
    System.out.println(twoSum.findTarget(root, 9));
    System.out.println(twoSum.findTarget(root, 28));
    System.out.println(twoSum.findTarget(root, 11));
    System.out.println(twoSum.findTarget(root, 10));
    System.out.println(twoSum.findTarget(root, 14));
  }
}
