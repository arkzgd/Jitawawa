package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
  private void preOrder(TreeNode root, List<Integer> result) {
    if (root == null) return;
    result.add(root.val);
    preOrder(root.left, result);
    preOrder(root.right, result);
  }

  private void postOrder(TreeNode root, List<Integer> result) {
    if (root == null) return;
    postOrder(root.left, result);
    postOrder(root.right, result);
    result.add(root.val);
  }

  private TreeNode buildTree(int[] pre, int[] post, int root) {
    if (root < 0 || root > pre.length - 1) return null;

    TreeNode node = new TreeNode(pre[root]);
    int lc, rc;
    lc = root + 1;

    int i;
    for (i = post.length - 1; post[i] != pre[root]; i--)
      ;

    if (i > 0) {
      int j = post[i - 1];
      for (rc = pre.length - 1; pre[rc] != j; rc--)
        ;
    }
    else rc = -1;

    if (lc < rc) {
      node.left = buildTree(pre, post, lc);
      node.right = buildTree(pre, post, rc);
    }
    else if (rc == lc) {
      node.left = buildTree(pre, post, lc);
      node.right = null;
    }

    return node;
  }

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return buildTree(pre, post, 0);
  }

  public static void main(String[] args) {
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

    ConstructBinaryTreeFromPreorderAndPostorderTraversal cfpp = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
    int[] pre = new int[] {1, 2, 4, 5, 3, 6, 7};
    int[] post = new int[] {4, 5, 2, 6, 7, 3, 1};

    TreeNode root = cfpp.constructFromPrePost(pre, post);
    System.out.println(printer.printTree(root));

    List<Integer> result = new ArrayList<>();
    cfpp.preOrder(root, result);
    System.out.println(result);

    result.clear();
    cfpp.postOrder(root, result);
    System.out.println(result);
  }
}
