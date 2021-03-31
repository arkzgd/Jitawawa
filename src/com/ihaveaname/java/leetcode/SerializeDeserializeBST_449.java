package com.ihaveaname.java.leetcode;

public class SerializeDeserializeBST_449 {
  public class Codec {
    private class Builder {
      private int partition(int[] preorder, int low, int high) {
        int i = low;
        for (; i <= high; i++) if (preorder[i] > preorder[low]) break;
        return i;
      }

      private TreeNode helper(int[] preorder, int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(preorder[low], null, null);

        TreeNode t = new TreeNode(preorder[low]);
        int m = partition(preorder, low, high);
        t.left = helper(preorder, low + 1, m - 1);
        t.right = helper(preorder, m, high);
        return t;
      }

      public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) return null;
        else return helper(preorder, 0, preorder.length - 1);
      }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root != null) {
        String r = Integer.toString(root.val);
        if (root.left != null) {
          r = r + "," + serialize(root.left);
        }
        if (root.right != null) {
          r = r + "," + serialize(root.right);
        }

        return r;
      }

      return "";
    }

    private int[] stringToIntArray(String data) {
      if (data.isEmpty()) return null;

      String[] ss = data.split(",");
      int[] result = new int[ss.length];
      int index = 0;

      for (String s : ss) {
        result[index++] = Integer.parseInt(s);
      }

      return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      Builder builder = new Builder();

      return builder.bstFromPreorder(stringToIntArray(data));
    }
  }

  public static void main(String[] args) {
    SerializeDeserializeBST_449 serializeDeserializeBST_449 = new SerializeDeserializeBST_449();
    Codec ser = serializeDeserializeBST_449.new Codec();
    Codec dser = serializeDeserializeBST_449.new Codec();

    SameTree sameTree = new SameTree();

    TreeNode tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    String s = ser.serialize(tree);
    System.out.println(s);
    TreeNode ans = dser.deserialize(s);
    System.out.println(sameTree.isSameTree(tree, ans));

    tree = null;
    s = ser.serialize(tree);
    System.out.println(s);
    ans = dser.deserialize(s);
    System.out.println(sameTree.isSameTree(tree, ans));
  }
}
