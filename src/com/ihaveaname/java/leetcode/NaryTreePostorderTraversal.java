package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
  private void helper(Node node, List<Integer> result) {
    if (node != null) {
      for (Node c : node.children) helper(c, result);
      result.add(node.val);
    }
  }

  public List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }
}
