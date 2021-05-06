package com.ihaveaname.java.leetcode;

import java.util.ArrayList;

public class RecoverATreeFromPreorderTraversal_1028 {
  class Solution {
    private ArrayList<int[]> splitString(String S) {
      int i = 0;
      int start = 0;
      ArrayList<int[]> result = new ArrayList<>();
      while (i < S.length()) {
        int[] pair = new int[2];
        while (i < S.length() && S.charAt(i) == '-') i++;
        pair[0] = i - start;
        start = i;
        while (i < S.length() && S.charAt(i) != '-') i++;
        pair[1] = Integer.parseInt(S.substring(start, i));
        start = i;
        result.add(pair);
      }

      return result;
    }

    private TreeNode helper(ArrayList<int[]> store, int low, int high) {
      if (low <= high) {
        TreeNode root = new TreeNode(store.get(low)[1]);
        if (low == high) return root;

        int level = store.get(low)[0] + 1;
        int lc = low + 1;
        while (lc <= high && store.get(lc)[0] != level) lc++;
        int rc = lc + 1;
        while (rc <= high && store.get(rc)[0] != level) rc++;
        root.left = helper(store, lc, rc - 1);
        root.right = helper(store, rc, high);

        return root;
      }

      return null;
    }

    public TreeNode recoverFromPreorder(String S) {
      var store = splitString(S);
      TreeNode root = helper(store, 0, store.size() - 1);
      return root;
    }
  }

  public static void main(String[] args) {
    RecoverATreeFromPreorderTraversal_1028 recoverATreeFromPreorderTraversal_1028 =
        new RecoverATreeFromPreorderTraversal_1028();
    Solution solution = recoverATreeFromPreorderTraversal_1028.new Solution();
    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

    String s = "1-2--3--4-5--6--7";
    System.out.println(printer.printTree(solution.recoverFromPreorder(s)));

    s = "1-401--349---90--88";
    System.out.println(printer.printTree(solution.recoverFromPreorder(s)));

    s = "1-2--3---4-5--6---7";
    System.out.println(printer.printTree(solution.recoverFromPreorder(s)));
  }
}
