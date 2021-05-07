package com.ihaveaname.java.leetcode;

import java.util.LinkedList;

public class SerializeAndDeserializeBTree_297 {
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      var sb = new StringBuilder();
      var queue = new LinkedList<TreeNode>();
      if (root != null) queue.offer(root);
      while (!queue.isEmpty()) {
        int length = queue.size();
        int nullCount = 0;
        boolean seenNotNull = false;
        for (int i = 0; i < length; i++) {
          TreeNode n = queue.poll();
          if (n == null) {
            nullCount++;
          } else {
            for (int k = 0; k < nullCount; k++) {
              sb.append(",null");
            }
            nullCount = 0;
            if (!sb.isEmpty()) sb.append(",");
            sb.append(n.val);
            queue.offer(n.left);
            queue.offer(n.right);
            if (n.left != null || n.right != null) seenNotNull = true;
          }
        }

        if (seenNotNull) {
          for (int k = 0; k < nullCount; k++) {
            sb.append(",null");
          }
        }
      }

      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      return null;
    }
  }

  public static void main(String[] args) {
    SerializeAndDeserializeBTree_297 serializeAndDeserializeBTree_297 =
        new SerializeAndDeserializeBTree_297();
    Codec encoder = serializeAndDeserializeBTree_297.new Codec();
    Codec decoder = serializeAndDeserializeBTree_297.new Codec();

    PrintBinaryTree_655 printBinaryTree_655 = new PrintBinaryTree_655();
    PrintBinaryTree_655.Solution printer = printBinaryTree_655.new Solution();

    TreeNode tree =
        new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
    var s = encoder.serialize(tree);
    System.out.println(s);
    System.out.println(printer.printTree(decoder.deserialize(s)));

    tree = new TreeNode(1);
    s = encoder.serialize(tree);
    System.out.println(s);
    System.out.println(printer.printTree(decoder.deserialize(s)));

    tree = null;
    s = encoder.serialize(tree);
    System.out.println(s);
    System.out.println(printer.printTree(decoder.deserialize(s)));

    tree = new TreeNode(1, new TreeNode(2), null);
    s = encoder.serialize(tree);
    System.out.println(s);
    System.out.println(printer.printTree(decoder.deserialize(s)));

    tree =
        new TreeNode(
            6,
            new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1))),
            new TreeNode(5, new TreeNode(0), null));
    s = encoder.serialize(tree);
    System.out.println(s);
    System.out.println(printer.printTree(decoder.deserialize(s)));
  }
}
