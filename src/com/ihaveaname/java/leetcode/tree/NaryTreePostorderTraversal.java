package com.ihaveaname.java.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
  private void helper(NaryNode naryNode, List<Integer> result) {
    if (naryNode != null) {
      for (NaryNode c : naryNode.children) helper(c, result);
      result.add(naryNode.val);
    }
  }

  public List<Integer> postorder(NaryNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }
}
