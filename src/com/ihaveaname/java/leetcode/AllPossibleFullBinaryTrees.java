package com.ihaveaname.java.leetcode;

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

  public AllPossibleFullBinaryTrees() {
    cache.clear();
  }

  private List<TreeNode> helper(int N) {
    if (!cache.containsKey(N)) {
      if (N == 1) {
        addToCache(N, new TreeNode(0));
        return cache.get(N);
      }

      for (int i = 1; i < N - 1; i += 2) {
        int j = N - 1 - i;
        List<TreeNode> leftRoots = helper(i);
        List<TreeNode> rightRoots = helper(j);
        for (TreeNode ln : leftRoots)
          for (TreeNode rn : rightRoots) {
            addToCache(N, new TreeNode(0, ln, rn));
          }
      }
    }

    return cache.get(N);
  }

  public List<TreeNode> allPossibleFBT(int N) {
    if (N % 2 == 0) return new ArrayList<TreeNode>();
    helper(N);
    List<TreeNode> result = cache.get(N);
    return result;
  }

  public static void main(String[] args) {
    AllPossibleFullBinaryTrees allPossibleFullBinaryTrees = new AllPossibleFullBinaryTrees();
    System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(7).size());

    AllPossibleFullBinaryTrees_RefSolution allPossibleFullBinaryTreesRefSolution =
        new AllPossibleFullBinaryTrees_RefSolution();
    System.out.println(allPossibleFullBinaryTreesRefSolution.allPossibleFBT(7).size());
  }
}
