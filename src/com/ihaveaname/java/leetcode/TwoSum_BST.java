package com.ihaveaname.java.leetcode;

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

  private TreeNode treeRoot;

  public boolean findTarget(TreeNode root, int k) {
    treeRoot = root;
    return search(root, k);
  }

  private boolean search(TreeNode root, int k) {
    if (root != null) {
      int target = k - root.val;
      if (target < root.val) {
        if (search_in_tree(treeRoot, target)) return true;
      } else if (target > root.val) {
        if (search_in_tree(treeRoot, target)) return true;
      }

      if (search(root.left, k)) return true;
      if (search(root.right, k)) return true;
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
