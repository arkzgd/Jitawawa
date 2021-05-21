package com.ihaveaname.java.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
  private void helper(NaryNode naryNode, List<Integer> result) {
    if (naryNode != null) {
      result.add(naryNode.val);
      for (NaryNode c : naryNode.children) helper(c, result);
    }
  }

  public List<Integer> preorder(NaryNode root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }
}
