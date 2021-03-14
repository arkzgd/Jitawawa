package com.ihaveaname.java.leetcode;

public class CompleteBinaryTreeInserter_919 {
  class CBTInserter {
    private TreeNode root;
    private TreeNode offBalanced;

    private int lowestOffBalance(TreeNode root) {
      if (root != null) {
        int lh = lowestOffBalance(root.left);
        int rh = lowestOffBalance(root.right);
        if (lh - rh >= 1 && offBalanced == null) offBalanced = root;
        return Math.max(lh, rh) + 1;
      }

      return 0;
    }

    private TreeNode getNextInsertTo(TreeNode root) {
      offBalanced = null;
      lowestOffBalance(root);
      if (offBalanced != null) {
        if (offBalanced.right == null) return offBalanced;
        else {
          TreeNode n = offBalanced.right;
          while (n.left != null) n = n.left;
          return n;
        }
      } else {
        while (root.left != null) root = root.left;
        return root;
      }
    }

    public CBTInserter(TreeNode root) {
      this.root = root;
    }

    public int insert(int v) {
      TreeNode nextInsertTo = getNextInsertTo(root);
      if (nextInsertTo.left != null) nextInsertTo.right = new TreeNode(v);
      else nextInsertTo.left = new TreeNode(v);

      return nextInsertTo.val;
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
  }
}
