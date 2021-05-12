package com.ihaveaname.java.leetcode;

public class RecoverBST_99 {
  class Solution {
    public void recoverTree(TreeNode root) {}
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
  }
}
