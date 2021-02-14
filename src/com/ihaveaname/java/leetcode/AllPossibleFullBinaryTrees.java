package com.ihaveaname.java.leetcode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

  private Map<Integer, List<TreeNode>> cache = new LinkedHashMap<>();

  private void addToCache(int N, TreeNode n) {
    if (cache.containsKey(N)) {
      cache.get(N).add(n);
    } else {
      List<TreeNode> l = new ArrayList<>();
      l.add(n);
      cache.put(N, l);
    }
  }

  private void leaves(TreeNode root, List<TreeNode> result) {
    if (root != null) {
      if (root.left == null && root.right == null) result.add(root);
      else {
        leaves(root.left, result);
        leaves(root.right, result);
      }
    }
  }

  private void helper(int N) {
    for (int i = 1; i <= N; i++) {
      if (i == 1) {
        addToCache(i, new TreeNode(0));
        continue;
      }
      if (i % 2 == 0) {
        cache.put(i, new ArrayList<>());
        continue;
      }
      for (TreeNode root : cache.get(i - 2)) {
        List<TreeNode> leaves = new ArrayList<>();
        leaves(root, leaves);
        for (TreeNode leaf : leaves) {
          leaf.left = new TreeNode(0);
          leaf.right = new TreeNode(0);
          addToCache(i, cloneTree(root));
          leaf.left = null;
          leaf.right = null;
        }
      }
    }
  }

  public List<TreeNode> allPossibleFBT(int N) {
    helper(N);
    List<TreeNode> result = cache.get(N);
    return result;
  }

  public static void main(String[] args) {
    AllPossibleFullBinaryTrees allPossibleFullBinaryTrees = new AllPossibleFullBinaryTrees();

    System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(9).size());
    Solution solution = new Solution();
    System.out.println(solution.allPossibleFBT(9).size());
  }
}
