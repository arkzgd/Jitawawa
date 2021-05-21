package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

public class ConvertSortedArrayToBST {
  private TreeNode helper(int[] nums, int left, int right) {
    if (left >= right) return null;
    if (right - left == 1) return new TreeNode(nums[left], null, null);
    else {
      int mid = left + ((right - left) >> 1);
      TreeNode node = new TreeNode(nums[mid]);
      node.left = helper(nums, left, mid);
      node.right = helper(nums, mid + 1, right);
      return node;
    }
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length);
  }

  public static void main(String[] args) {
    ConvertSortedArrayToBST convertSortedArrayToBST = new ConvertSortedArrayToBST();
    int[] nums = new int[]{-10, -3, 0, 5, 9};
    TreeNode tree = convertSortedArrayToBST.sortedArrayToBST(nums);
    System.out.println(tree);

    nums = new int[]{-10, -3};
    tree = convertSortedArrayToBST.sortedArrayToBST(nums);
    System.out.println(tree);

    nums = new int[]{-10};
    tree = convertSortedArrayToBST.sortedArrayToBST(nums);
    System.out.println(tree);

    nums = new int[]{};
    tree = convertSortedArrayToBST.sortedArrayToBST(nums);
    System.out.println(tree);
  }
}
