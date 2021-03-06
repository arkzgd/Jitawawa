package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.SerializeAndDeserializeBTree_297;
import com.ihaveaname.java.leetcode.TreeNode;

public class LongestUnivaluePath_687 {
  class Solution {
    private int max;

    public int helper(TreeNode root) {
      if (root != null) {
        int lc = 0;
        int rc = 0;
        if (root.left != null) {
          lc = helper(root.left);
          if (root.left.val == root.val) lc++;
          else lc = 0;
        }
        if (root.right != null) {
          rc = helper(root.right);
          if (root.right.val == root.val) rc++;
          else rc = 0;
        }
        max = Math.max(max, lc + rc);

        return Math.max(lc, rc);
      }

      return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
      max = 0;
      helper(root);

      return max;
    }
  }

  public static void main(String[] args) {
    LongestUnivaluePath_687 longestUnivaluePath_687 = new LongestUnivaluePath_687();
    Solution solution = longestUnivaluePath_687.new Solution();

    SerializeAndDeserializeBTree_297 serializeAndDeserializeBTree_297 =
        new SerializeAndDeserializeBTree_297();
    SerializeAndDeserializeBTree_297.Codec decoder = serializeAndDeserializeBTree_297.new Codec();

    TreeNode tree = decoder.deserialize("5,4,5,1,1,5");
    System.out.println(solution.longestUnivaluePath(tree));

    tree = decoder.deserialize("1,4,5,4,4,5");
    System.out.println(solution.longestUnivaluePath(tree));

    tree = decoder.deserialize("1,null,1,1,1,1,1,1");
    System.out.println(solution.longestUnivaluePath(tree));
  }
}
