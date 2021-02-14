package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
  private TreeNode cloneTree(TreeNode root) {
    if (root != null) {
      TreeNode newRoot = new TreeNode(root.val);
      newRoot.left = cloneTree(root.left);
      newRoot.right = cloneTree(root.right);

      return newRoot;
    }

    return null;
  }

  private void helper(TreeNode root, TreeNode currentNode, List<TreeNode> result, int remains) {
    if (remains == 0) {
      result.add(cloneTree(root));
      return;
    }

    currentNode.left = new TreeNode(0);
    currentNode.right = new TreeNode(0);
    remains -= 2;

    if (remains == 0) {
      result.add(cloneTree(root));
      return;
    }

    helper(root, currentNode.left, result, remains);
    currentNode.left.left = null;
    currentNode.left.right = null;
    helper(root, currentNode.right, result, remains);
  }

  public List<TreeNode> allPossibleFBT(int N) {
    List<TreeNode> result = new ArrayList<>();
    if (N % 2 == 0) return result;
    else {
      if (N == 1) {
        result.add(new TreeNode(0));
        return result;
      }

      TreeNode root = new TreeNode(0);
      helper(root, root, result, N - 1);
    }

    return result;
  }

  public static void main(String[] args) {
    AllPossibleFullBinaryTrees allPossibleFullBinaryTrees = new AllPossibleFullBinaryTrees();

    System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(1));
    System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(3));
  }
}
