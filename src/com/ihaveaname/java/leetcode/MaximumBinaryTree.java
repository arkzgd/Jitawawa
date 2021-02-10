package com.ihaveaname.java.leetcode;

public class MaximumBinaryTree {
  private int findMax(int[] nums, int low, int high) {
    int max = Integer.MIN_VALUE;
    int maxIndex = low;
    for (int i = low; i <= high; i++)
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      }
    return maxIndex;
  }

  private TreeNode helper(int[] nums, int low, int high) {
    if (low > high) return null;
    if (low == high) return new TreeNode(nums[low], null, null);

    int m = findMax(nums, low, high);
    TreeNode t = new TreeNode(nums[m]);
    t.left = helper(nums, low, m - 1);
    t.right = helper(nums, m + 1, high);

    return t;
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();

    int[] nums = new int[] {3, 2, 1};
    System.out.println(maximumBinaryTree.constructMaximumBinaryTree(nums));

    nums = new int[] {3, 2, 1, 6, 0, 5};
    System.out.println(maximumBinaryTree.constructMaximumBinaryTree(nums));
  }
}
