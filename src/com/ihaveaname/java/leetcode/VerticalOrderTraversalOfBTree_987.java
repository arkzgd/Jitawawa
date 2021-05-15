package com.ihaveaname.java.leetcode;

import java.util.*;

public class VerticalOrderTraversalOfBTree_987 {
  class Solution {
    private List<Map<Integer, List<Integer>>> map;

    private void helper(TreeNode root, int row, int col) {
      if (root != null) {
        if (row == map.size()) map.add(new HashMap<>());
        if (!map.get(row).containsKey(col)) map.get(row).put(col, new LinkedList<>());
        map.get(row).get(col).add(root.val);
        helper(root.left, row + 1, col - 1);
        helper(root.right, row + 1, col + 1);
      }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
      map = new ArrayList<>();
      helper(root, 0, 0);

      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int row = 0; row < map.size(); row++) {
        Map<Integer, List<Integer>> m = map.get(row);
        for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
          Collections.sort(e.getValue());
          if (e.getKey() < min) min = e.getKey();
          if (e.getKey() > max) max = e.getKey();
        }
      }

      List<List<Integer>> result = new ArrayList<>(max - min + 1);
      for (int col = min; col <= max; col++) result.add(new ArrayList<>());

      for (int col = min; col <= max; col++) {
        for (Map<Integer, List<Integer>> e : map) {
          if (e.containsKey(col)) result.get(col - min).addAll(e.get(col));
        }
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
