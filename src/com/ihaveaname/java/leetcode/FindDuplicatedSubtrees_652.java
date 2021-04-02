package com.ihaveaname.java.leetcode;

import java.util.*;

public class FindDuplicatedSubtrees_652 {
  class Solution {
    private Set<String> subtrees;
    private Map<String, TreeNode> result;

    private String helper(TreeNode root) {
      if (root != null) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(root.val);
        stringBuffer.append(",");
        stringBuffer.append(helper(root.left));
        stringBuffer.append(",");
        stringBuffer.append(helper(root.right));

        String s = stringBuffer.toString();
        if (subtrees.contains(s)) {
          if (!result.containsKey(s)) result.put(s, root);
        } else subtrees.add(s);

        return s;
      }

      return "*";
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      subtrees = new HashSet<>();
      result = new HashMap<>();
      helper(root);

      List<TreeNode> l = new ArrayList<>();
      l.addAll(result.values());
      return l;
    }
  }

  public static void main(String[] args) {
    FindDuplicatedSubtrees_652 findDuplicatedSubtrees_652 = new FindDuplicatedSubtrees_652();
    Solution solution = findDuplicatedSubtrees_652.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree =
        new TreeNode(
            0,
            new TreeNode(0, new TreeNode(0), null),
            new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree = new TreeNode(0, new TreeNode(0), new TreeNode(0));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree = new TreeNode(2, new TreeNode(1), new TreeNode(1));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree =
        new TreeNode(
            2, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null));
    System.out.println(solution.findDuplicateSubtrees(tree));
  }
}
