package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {
  public List<Integer> findAllTheLonelyNodes(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private void dfs(TreeNode node, List<Integer> result) {
    if (node == null) return;

    dfs(node.left, result);
    dfs(node.right, result);

    if (node.left != null && node.right == null) {
      result.add(node.left.val);
    }

    if (node.left == null && node.right != null) {
      result.add(node.right.val);
    }
  }

  public static void main(String[] args) {
    FindAllTheLonelyNodes fatln = new FindAllTheLonelyNodes();

    TreeNode tree =
        new TreeNode(
            1, new TreeNode(2, null, new TreeNode(4, null, null)), new TreeNode(3, null, null));
    System.out.println(fatln.findAllTheLonelyNodes(tree));

    tree =
        new TreeNode(
            7,
            new TreeNode(1, new TreeNode(6, null, null), null),
            new TreeNode(
                4,
                new TreeNode(5, null, null),
                new TreeNode(3, null, new TreeNode(2, null, null))));
    System.out.println(fatln.findAllTheLonelyNodes(tree));

    tree =
        new TreeNode(
            11,
            new TreeNode(
                99,
                new TreeNode(77, new TreeNode(55, new TreeNode(33, null, null), null), null),
                null),
            new TreeNode(
                88,
                null,
                new TreeNode(66, null, new TreeNode(44, null, new TreeNode(22, null, null)))));
    System.out.println(fatln.findAllTheLonelyNodes(tree));

    tree = new TreeNode(197, null, null);
    System.out.println(fatln.findAllTheLonelyNodes(tree));

    tree = new TreeNode(31, null, new TreeNode(78, null, new TreeNode(28, null, null)));
    System.out.println(fatln.findAllTheLonelyNodes(tree));
  }
}
