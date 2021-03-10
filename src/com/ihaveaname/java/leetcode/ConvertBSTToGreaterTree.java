package com.ihaveaname.java.leetcode;

public class ConvertBSTToGreaterTree {
  class Solution {
    private int sum;

    private TreeNode helper(TreeNode root) {
      if (root != null) {
        TreeNode right = helper(root.right);
        TreeNode thisNode = new TreeNode(root.val + sum);
        thisNode.right = right;
        sum += root.val;
        thisNode.left = helper(root.left);
        return thisNode;
      }

      return root;
    }

    public TreeNode convertBST(TreeNode root) {
      sum = 0;
      return helper(root);
    }
  }

  public static void main(String[] args) {
    ConvertBSTToGreaterTree convertBSTToGreaterTree = new ConvertBSTToGreaterTree();
    Solution solution = convertBSTToGreaterTree.new Solution();

    TreeNode tree =
        new TreeNode(
            4,
            new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
            new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
    tree = solution.convertBST(tree);
    System.out.println(tree);

    tree = new TreeNode(0, null, new TreeNode(1));
    tree = solution.convertBST(tree);
    System.out.println(tree);

    tree = new TreeNode(1, new TreeNode(0), new TreeNode(2));
    tree = solution.convertBST(tree);
    System.out.println(tree);

    tree = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
    tree = solution.convertBST(tree);
    System.out.println(tree);
  }
}
