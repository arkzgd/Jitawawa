package com.ihaveaname.java.leetcode;

public class ValidateBinarySearchTree_98 {
  class Solution {
    TreeNode prev;

    private boolean helper(TreeNode root) {
      if (root != null) {
        boolean lr = helper(root.left);
        boolean cr;
        if (prev != null) cr = prev.val < root.val;
        else cr = true;
        prev = root;
        boolean rr = helper(root.right);

        return lr && cr && rr;
      }

      return true;
    }

    public boolean isValidBST(TreeNode root) {
      prev = null;
      return helper(root);
    }
  }

  public static void main(String[] args) {
    ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
    Solution solution = validateBinarySearchTree_98.new Solution();

    SerializeAndDeserializeBTree_297 serializeAndDeserializeBTree_297 = new SerializeAndDeserializeBTree_297();
    SerializeAndDeserializeBTree_297.Codec decoder = serializeAndDeserializeBTree_297.new Codec();

    TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    System.out.println(solution.isValidBST(tree));

    tree = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
    System.out.println(solution.isValidBST(tree));

    tree = decoder.deserialize("5,4,6,null,null,3,7");
    System.out.println(solution.isValidBST(tree));
  }
}
