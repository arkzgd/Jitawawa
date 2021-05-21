package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class FindElements {
  private TreeNode root;

  private void helper(TreeNode root, int val) {
    if (root != null) {
      root.val = val;
      helper(root.left, 2 * val + 1);
      helper(root.right, 2 * val + 2);
    }
  }

  public FindElements(TreeNode root) {
    helper(root, 0);
    this.root = root;
    existenceMap = new HashMap<>();
  }

  private Map<Integer, TreeNode> existenceMap;

  private int parent(int target) {
    if (target == 0) return target;
    if (target % 2 == 1) return (target - 1) / 2;
    else return (target - 2) / 2;
  }

  private TreeNode find_helper(int target) {
    if (!existenceMap.containsKey(target)) {
      if (target == 0) {
        existenceMap.put(target, root);
      } else {
        int p = parent(target);
        TreeNode pNode = find_helper(p);
        if (target % 2 == 1) {
          if (pNode != null) existenceMap.put(target, pNode.left);
          else existenceMap.put(target, null);
        } else {
          if (pNode != null) existenceMap.put(target, pNode.right);
          else existenceMap.put(target, null);
        }
      }
    }

    return existenceMap.get(target);
  }

  public boolean find(int target) {
    return find_helper(target) != null;
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(-1, null, new TreeNode(-1, null, null));
    FindElements findElements = new FindElements(tree);
    System.out.println(findElements.find(1));
    System.out.println(findElements.find(2));

    tree =
        new TreeNode(
            -1,
            new TreeNode(-1, new TreeNode(-1, null, null), new TreeNode(-1, null, null)),
            new TreeNode(-1, null, null));
    findElements = new FindElements(tree);
    System.out.println(findElements.find(1));
    System.out.println(findElements.find(3));
    System.out.println(findElements.find(5));

    tree =
        new TreeNode(
            -1, null, new TreeNode(-1, new TreeNode(-1, new TreeNode(-1, null, null), null), null));
    findElements = new FindElements(tree);
    System.out.println(findElements.find(2));
    System.out.println(findElements.find(3));
    System.out.println(findElements.find(4));
    System.out.println(findElements.find(5));

  }
}
