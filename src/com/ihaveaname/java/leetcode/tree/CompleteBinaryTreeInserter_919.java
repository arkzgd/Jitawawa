package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter_919 {
  class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
      this.root = root;
      queue = new LinkedList<>();
      if (root != null) queue.offer(root);
      while (!queue.isEmpty()) {
        TreeNode n = queue.peek();
        if (n.left != null) queue.offer(n.left);
        if (n.right != null) queue.offer(n.right);
        if (n.left != null && n.right != null) queue.poll();
        else break;
      }
    }

    public int insert(int v) {
      TreeNode n = queue.peek();
      if (n != null) {
        TreeNode newNode = new TreeNode(v);
        if (n.left == null) n.left = newNode;
        else if (n.right == null) n.right = newNode;
        queue.offer(newNode);
        if (n.left != null && n.right != null) queue.poll();
      }

      return n.val;
    }

    public TreeNode get_root() {
      return root;
    }
  }

  public static void main(String[] args) {
    CompleteBinaryTreeInserter_919 completeBinaryTreeInserter_919 =
        new CompleteBinaryTreeInserter_919();

    TreeNode tree = new TreeNode(1);
    CBTInserter cbtInserter = completeBinaryTreeInserter_919.new CBTInserter(tree);
    System.out.println(cbtInserter.insert(2));
    System.out.println(cbtInserter.get_root().val);
    System.out.println("========");

    tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), null));
    cbtInserter = completeBinaryTreeInserter_919.new CBTInserter(tree);
    System.out.println(cbtInserter.insert(7));
    System.out.println(cbtInserter.insert(8));
    System.out.println(cbtInserter.get_root().val);
    System.out.println("========");

    tree = new TreeNode(1);
    cbtInserter = completeBinaryTreeInserter_919.new CBTInserter(tree);
    System.out.println(cbtInserter.insert(2));
    System.out.println(cbtInserter.insert(3));
    System.out.println(cbtInserter.insert(4));
    System.out.println(cbtInserter.insert(5));
    System.out.println(cbtInserter.get_root().val);
    System.out.println("========");

    tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    cbtInserter = completeBinaryTreeInserter_919.new CBTInserter(tree);
    System.out.println(cbtInserter.insert(6));
    System.out.println(cbtInserter.insert(7));
    System.out.println(cbtInserter.insert(8));
    System.out.println(cbtInserter.insert(9));
    System.out.println(cbtInserter.insert(10));
    System.out.println(cbtInserter.insert(11));
    System.out.println(cbtInserter.insert(12));
    System.out.println(cbtInserter.get_root().val);
    System.out.println("========");

    tree = new TreeNode(1, new TreeNode(2), null);
    cbtInserter = completeBinaryTreeInserter_919.new CBTInserter(tree);
    System.out.println(cbtInserter.insert(3));
    System.out.println(cbtInserter.insert(4));
    System.out.println(cbtInserter.get_root().val);
    System.out.println("========");

    tree = new TreeNode(1, new TreeNode(2), null);
    cbtInserter = completeBinaryTreeInserter_919.new CBTInserter(tree);
    System.out.println(cbtInserter.insert(3));
    System.out.println(cbtInserter.insert(4));
    System.out.println(cbtInserter.insert(5));
    System.out.println(cbtInserter.insert(6));
    System.out.println(cbtInserter.get_root().val);
  }
}
