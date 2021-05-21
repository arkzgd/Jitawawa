package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.SerializeAndDeserializeBTree_297;
import com.ihaveaname.java.leetcode.TreeNode;

public class BinaryTreeMaxPathSum_124 {
  class Solution {
    private int max = Integer.MIN_VALUE;

    private int helper(TreeNode root) {
      if (root != null) {
        int lc = helper(root.left);
        int rc = helper(root.right);
        int subSum = lc + root.val + rc;
        int[] sums = new int[] {root.val, lc + root.val, rc + root.val};
        int maxSum = Integer.MIN_VALUE;
        for (int sum : sums) {
          if (sum > maxSum) maxSum = sum;
        }
        max = Math.max(max, Math.max(subSum, maxSum));
        return maxSum;
      }

      return 0;
    }

    public int maxPathSum(TreeNode root) {
      max = Integer.MIN_VALUE;
      helper(root);
      return max;
    }
  }

  public static void main(String[] args) {
    BinaryTreeMaxPathSum_124 binaryTreeMaxPathSum_124 = new BinaryTreeMaxPathSum_124();
    Solution solution = binaryTreeMaxPathSum_124.new Solution();

    SerializeAndDeserializeBTree_297 serializeAndDeserializeBTree_297 =
        new SerializeAndDeserializeBTree_297();
    SerializeAndDeserializeBTree_297.Codec decoder = serializeAndDeserializeBTree_297.new Codec();

    System.out.println(solution.maxPathSum(decoder.deserialize("1,2,3")));
    System.out.println(solution.maxPathSum(decoder.deserialize("-10,9,20,null,null,15,7")));
    System.out.println(solution.maxPathSum(decoder.deserialize("2,-1")));
    System.out.println(solution.maxPathSum(decoder.deserialize("1,-2,3")));
    System.out.println(
        solution.maxPathSum(
            decoder.deserialize("9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6")));
    System.out.println(
        solution.maxPathSum(decoder.deserialize("5,4,8,11,null,13,4,7,2,null,null,null,1")));
  }
}
