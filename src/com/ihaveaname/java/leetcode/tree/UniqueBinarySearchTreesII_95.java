package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
  class Solution {
    private List<TreeNode> generateTrees(int[] values, int low, int high) {
      if (low > high) return new LinkedList<>();
      else if (low == high) {
        List<TreeNode> l = new LinkedList<>();
        l.add(new TreeNode(values[low]));
        return l;
      } else {
        List<TreeNode> merged = new LinkedList<>();
        for (int i = low; i <= high; i++) {
          List<TreeNode> left = generateTrees(values, low, i - 1);
          List<TreeNode> right = generateTrees(values, i + 1, high);

          if (!left.isEmpty() && !right.isEmpty()) {
            for (TreeNode lc : left) {
              for (TreeNode rc : right) {
                TreeNode root = new TreeNode(values[i]);
                root.left = lc;
                root.right = rc;
                merged.add(root);
              }
            }
          } else if (!right.isEmpty()) {
            for (TreeNode rc : right) {
              TreeNode root = new TreeNode(values[i], null, rc);
              merged.add(root);
            }
          } else if (!left.isEmpty()) {
            for (TreeNode lc : left) {
              TreeNode root = new TreeNode(values[i], lc, null);
              merged.add(root);
            }
          }
        }

        return merged;
      }
    }

    public List<TreeNode> generateTrees(int n) {
      int[] values = new int[n + 1];
      for (int i = 1; i <= n; i++) values[i] = i;
      return generateTrees(values, 1, n);
    }
  }

  public static void main(String[] args) {
    UniqueBinarySearchTreesII_95 uniqueBinarySearchTreesII_95 = new UniqueBinarySearchTreesII_95();
    Solution solution = uniqueBinarySearchTreesII_95.new Solution();
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

//    for (TreeNode t : solution.generateTrees(1)) System.out.println(printer.printTree(t));
//    for (TreeNode t : solution.generateTrees(2)) System.out.println(printer.printTree(t));
//    for (TreeNode t : solution.generateTrees(3)) System.out.println(printer.printTree(t));

    for (TreeNode t : solution.generateTrees(4)) System.out.println(printer.printTree(t));
  }
}
