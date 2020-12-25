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

  public boolean solution(TreeNode root, int k) {
    return search(root, root, k);
  }

  private boolean search(TreeNode treeRoot, TreeNode root, int k) {
    if (root != null) {
      int target = k - root.val;
      if (search_in_tree(treeRoot, target) && target != root.val) return true;
      if (search(treeRoot, root.left, k)) return true;
      if (search(treeRoot, root.right, k)) return true;
    }

    return false;
  }

  private boolean search_in_tree(TreeNode root, int k) {
    TreeNode current = root;
    while (current != null) {
      if (current.val > k) current = current.left;
      else if (current.val < k) current = current.right;
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
    System.out.println(twoSum.solution(root, 9));
    System.out.println(twoSum.solution(root, 28));
    System.out.println(twoSum.solution(root, 11));
    System.out.println(twoSum.solution(root, 10));
    System.out.println(twoSum.solution(root, 14));
  }
}
