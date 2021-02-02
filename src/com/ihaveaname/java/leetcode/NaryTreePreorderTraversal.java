package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}

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
