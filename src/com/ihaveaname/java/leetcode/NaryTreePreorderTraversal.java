package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
  private void helper(Node node, List<Integer> result) {
    if (node != null) {
      result.add(node.val);
      for (Node c : node.children) helper(c, result);
    }
  }

  public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }
}
