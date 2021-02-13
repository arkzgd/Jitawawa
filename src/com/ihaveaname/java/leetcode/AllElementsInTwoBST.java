package com.ihaveaname.java.leetcode;

import scala.reflect.internal.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsInTwoBST {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    while (!stack1.empty() || !stack2.empty() || root1 != null || root2 != null) {
      while (root1 != null) {
        stack1.push(root1);
        root1 = root1.left;
      }

      while (root2 != null) {
        stack2.push(root2);
        root2 = root2.left;
      }

      root1 = stack1.empty() ? null : stack1.peek();
      root2 = stack2.empty() ? null : stack2.peek();
      if (root1 != null && root2 != null) {
        if (root1.val == root2.val) {
          result.add(root1.val);
          result.add(root2.val);
          stack1.pop();
          stack2.pop();
          root1 = root1.right;
          root2 = root2.right;
        } else if (root1.val < root2.val) {
          result.add(root1.val);
          stack1.pop();
          root1 = root1.right;
          root2 = null;
        } else if (root1.val > root2.val) {
          root1 = null;
          result.add(root2.val);
          stack2.pop();
          root2 = root2.right;
        }
      } else if (root1 != null) {
        result.add(root1.val);
        stack1.pop();
        root1 = root1.right;
      } else if (root2 != null) {
        result.add(root2.val);
        stack2.pop();
        root2 = root2.right;
      }
    }

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
