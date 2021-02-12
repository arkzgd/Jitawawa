package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBST {
  private void helper(TreeNode root, List<Integer> result) {
    if (root != null) {
      helper(root.left, result);
      result.add(root.val);
      helper(root.right, result);
    }
  }

  private List<Integer> merge(ArrayList<Integer> l, ArrayList<Integer> r) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < l.size() && j < r.size()) {
      if (l.get(i) < r.get(j)) {
        result.add(l.get(i));
        i++;
      } else if (l.get(i) > r.get(j)) {
        result.add(r.get(j));
        j++;
      } else {
        result.add(l.get(i));
        result.add(r.get(j));
        i++;
        j++;
      }
    }

    if (i == l.size()) {
      result.addAll(r.subList(j, r.size()));
    } else if (j == r.size()) {
      result.addAll(l.subList(i, l.size()));
    }

    return result;
  }

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> lr = new ArrayList<>();
    helper(root1, lr);
    ArrayList<Integer> rr = new ArrayList<>();
    helper(root2, rr);
    return merge(lr, rr);
  }

  public static void main(String[] args) {
    AllElementsInTwoBST allElementsInTwoBST = new AllElementsInTwoBST();

    TreeNode root1 = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(4, null, null));
    TreeNode root2 = new TreeNode(1, new TreeNode(0, null, null), new TreeNode(3, null, null));
    System.out.println(allElementsInTwoBST.getAllElements(root1, root2));

    root1 = new TreeNode(0, new TreeNode(-10, null, null), new TreeNode(10, null, null));
    root2 =
        new TreeNode(
            5,
            new TreeNode(1, new TreeNode(0, null, null), new TreeNode(2, null, null)),
            new TreeNode(7, null, null));
    System.out.println(allElementsInTwoBST.getAllElements(root1, root2));

    System.out.println(allElementsInTwoBST.getAllElements(null, root2));

    System.out.println(allElementsInTwoBST.getAllElements(root1, null));
  }
}
