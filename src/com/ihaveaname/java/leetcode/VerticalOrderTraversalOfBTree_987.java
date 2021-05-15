package com.ihaveaname.java.leetcode;

import java.util.*;

public class VerticalOrderTraversalOfBTree_987 {
  class Solution {
    private Map<Integer, List<Integer>> map;

    private void helper(TreeNode root, int row, int col) {
      if (root != null) {
        if (!map.containsKey(col)) map.put(col, new LinkedList<>());
        map.get(col).add(root.val);
        helper(root.left, row + 1, col - 1);
        helper(root.right, row + 1, col + 1);
      }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
      map = new HashMap<>();
      List<List<Integer>> result = new ArrayList<>();
      helper(root, 0, 0);
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
        Collections.sort(e.getValue());
        if (e.getKey() < min) min = e.getKey();
        if (e.getKey() > max) max = e.getKey();
      }

      for (int i = min; i <= max; i++) {
        result.add(map.get(i));
      }

      return result;
    }
  }

  public static void main(String[] args) {
    VerticalOrderTraversalOfBTree_987 verticalOrderTraversalOfBTree_987 =
        new VerticalOrderTraversalOfBTree_987();
    Solution solution = verticalOrderTraversalOfBTree_987.new Solution();

    SerializeAndDeserializeBTree_297 serializeAndDeserializeBTree_297 =
        new SerializeAndDeserializeBTree_297();
    SerializeAndDeserializeBTree_297.Codec decoder = serializeAndDeserializeBTree_297.new Codec();

    TreeNode tree = decoder.deserialize("3,9,20,null,null,15,7");
    System.out.println(solution.verticalTraversal(tree));

    tree = decoder.deserialize("1,2,3,4,5,6,7");
    System.out.println(solution.verticalTraversal(tree));

    tree = decoder.deserialize("1,2,3,4,6,5,7");
    System.out.println(solution.verticalTraversal(tree));
  }
}
