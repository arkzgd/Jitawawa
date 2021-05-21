package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBST {
  private void inorder(TreeNode tree, List<Integer> result) {
    if (tree != null) {
      inorder(tree.left, result);
      result.add(tree.val);
      inorder(tree.right, result);
    }
  }

  private void inorderAndMergeWith(TreeNode tree, List<Integer> withList, List<Integer> toList) {
    if (tree != null) {
      inorderAndMergeWith(tree.left, withList, toList);

      // A simple while loop to insert all eligible elements from withList to toList
      while (!withList.isEmpty() && withList.get(0) <= tree.val) {
        toList.add(withList.get(0));
        withList.remove(0);
      }
      toList.add(tree.val);

      inorderAndMergeWith(tree.right, withList, toList);
    }
  }

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> withList = new LinkedList<>();
    inorder(root1, withList);
    List<Integer> result = new LinkedList<>();
    inorderAndMergeWith(root2, withList, result);
    result.addAll(withList);

    return result;
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

    root1 =
        new TreeNode(
            0, null, new TreeNode(59, new TreeNode(57, null, null), new TreeNode(90, null, null)));
    root2 =
        new TreeNode(
            60,
            new TreeNode(17, new TreeNode(6, null, null), new TreeNode(20, null, null)),
            new TreeNode(
                74,
                new TreeNode(63, null, null),
                new TreeNode(97, new TreeNode(95, null, null), null)));
    System.out.println(allElementsInTwoBST.getAllElements(root1, root2));

    root1 = new TreeNode(0, new TreeNode(-10, null, null), new TreeNode(10, null, null));
    root2 =
        new TreeNode(
            5,
            new TreeNode(1, new TreeNode(0, null, null), new TreeNode(2, null, null)),
            new TreeNode(7, null, null));
    System.out.println(allElementsInTwoBST.getAllElements(root1, root2));
  }
}
