package com.ihaveaname.java.leetcode;

public class FlipEquivalentBinaryTree {
  class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
      if (root1 == null && root2 == null) return true;
      else if (root1 != null && root2 != null) {
        if (root1.val != root2.val) return false;
        else if (root1.left == null
            && root2.left == null
            && root1.right == null
            && root2.right == null) return true;

        if (root1.left != null
            && root1.right != null
            && root2.left != null
            && root2.right != null) {
          if (root1.left.val == root2.right.val && root1.right.val == root2.left.val)
            return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
          else if (root1.left.val == root2.left.val && root1.right.val == root2.right.val)
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        } else if (root1.left != null && root2.right != null && root1.left.val == root2.right.val)
          return flipEquiv(root1.left, root2.right);
        else if (root1.right != null && root2.left != null && root1.right.val == root2.left.val)
          return flipEquiv(root1.right, root2.left);
      }

      return false;
    }
  }

  public static void main(String[] args) {
    FlipEquivalentBinaryTree flipEquivalentBinaryTree = new FlipEquivalentBinaryTree();
    Solution solution = flipEquivalentBinaryTree.new Solution();

    TreeNode tree1 =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), new TreeNode(8))),
            new TreeNode(3, new TreeNode(6), null));
    TreeNode tree2 =
        new TreeNode(
            1,
            new TreeNode(3, null, new TreeNode(6)),
            new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(8), new TreeNode(7))));
    System.out.println(solution.flipEquiv(tree1, tree2));

    tree1 = null;
    tree2 = null;
    System.out.println(solution.flipEquiv(tree1, tree2));

    tree1 = null;
    tree2 = new TreeNode(1);
    System.out.println(solution.flipEquiv(tree1, tree2));

    tree1 = new TreeNode(0, null, new TreeNode(1));
    tree2 = null;
    System.out.println(solution.flipEquiv(tree1, tree2));

    tree1 = new TreeNode(0, null, new TreeNode(1));
    tree2 = new TreeNode(0, new TreeNode(1), null);
    System.out.println(solution.flipEquiv(tree1, tree2));

    tree1 = new TreeNode(0, null, new TreeNode(1));
    tree2 = new TreeNode(0, null, new TreeNode(1));
    System.out.println(solution.flipEquiv(tree1, tree2));
  }
}
