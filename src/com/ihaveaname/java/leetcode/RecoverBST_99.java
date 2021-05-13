package com.ihaveaname.java.leetcode;

public class RecoverBST_99 {
  class Solution {
    TreeNode prev;
    boolean goodStanding;

    private boolean helper(TreeNode root) {
      if (root != null && goodStanding) {
        boolean lr = helper(root.left);
        boolean cr;
        if (prev != null) {
          cr = prev.val < root.val;
          if (!cr) {
            int t = prev.val;
            prev.val = root.val;
            root.val = t;
            goodStanding = false;
            return false;
          }
        }
        prev = root;
        boolean rr = helper(root.right);

        return lr && rr;
      }

      return true;
    }

    public void recoverTree(TreeNode root) {
      do {
        prev = null;
        goodStanding = true;
      } while (!helper(root));
    }
  }

  public static void main(String[] args) {
    RecoverBST_99 recoverBST_99 = new RecoverBST_99();
    Solution solution = recoverBST_99.new Solution();

    SerializeAndDeserializeBTree_297 serializeAndDeserializeBTree_297 =
        new SerializeAndDeserializeBTree_297();
    SerializeAndDeserializeBTree_297.Codec decoder = serializeAndDeserializeBTree_297.new Codec();

    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

    TreeNode tree = decoder.deserialize("1,3,null,null,2");
    System.out.println(printer.printTree(tree));
    solution.recoverTree(tree);
    System.out.println(printer.printTree(tree));

    tree = decoder.deserialize("3,1,4,null,null,2");
    System.out.println(printer.printTree(tree));
    solution.recoverTree(tree);
    System.out.println(printer.printTree(tree));

    tree = decoder.deserialize("2,4,1,null,null,3");
    System.out.println(printer.printTree(tree));
    solution.recoverTree(tree);
    System.out.println(printer.printTree(tree));
  }
}
