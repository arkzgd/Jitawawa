package com.ihaveaname.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeafSimilarTree {
  private void helper(TreeNode root, Queue<Integer> queue) {
    if (root != null) {
      if (root.left == null && root.right == null) queue.offer(root.val);

      helper(root.left, queue);
      helper(root.right, queue);
    }
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    Queue<Integer> queue1 = new LinkedList<>();
    helper(root1, queue1);
    Queue<Integer> queue2 = new LinkedList<>();
    helper(root2, queue2);
    if (queue1.size() != queue2.size()) return false;
    while (!queue1.isEmpty() && !queue2.isEmpty())
      if (queue1.poll().compareTo(queue2.poll()) != 0) return false;
    return true;
  }

  public static void main(String[] args) {
    LeafSimilarTree lst = new LeafSimilarTree();

    TreeNode tree1 = new TreeNode(1, null, null);
    TreeNode tree2 = new TreeNode(1, null, null);
    assert lst.leafSimilar(tree1, tree2);

    tree1 = new TreeNode(1, null, null);
    tree2 = new TreeNode(2, null, null);
    assert !lst.leafSimilar(tree1, tree2);

    tree1 = new TreeNode(1, new TreeNode(2, null, null), null);
    tree2 = new TreeNode(2, new TreeNode(2, null, null), null);
    assert lst.leafSimilar(tree1, tree2);

    tree1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    tree2 = new TreeNode(1, new TreeNode(3, null, null), new TreeNode(2, null, null));
    assert !lst.leafSimilar(tree1, tree2);

    tree1 =
        new TreeNode(
            3,
            new TreeNode(
                5,
                new TreeNode(6, null, null),
                new TreeNode(2, new TreeNode(7, null, null), new TreeNode(4, null, null))),
            new TreeNode(1, new TreeNode(9, null, null), new TreeNode(8, null, null)));
    tree2 =
        new TreeNode(
            3,
            new TreeNode(5, new TreeNode(6, null, null), new TreeNode(7, null, null)),
            new TreeNode(
                1,
                new TreeNode(4, null, null),
                new TreeNode(2, new TreeNode(9, null, null), new TreeNode(8, null, null))));
    assert lst.leafSimilar(tree1, tree2);
  }
}
