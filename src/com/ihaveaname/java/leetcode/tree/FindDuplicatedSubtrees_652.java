package com.ihaveaname.java.leetcode.tree;

import com.ihaveaname.java.leetcode.TreeNode;

import java.util.*;

public class FindDuplicatedSubtrees_652 {
  class RefSolutionDoingHashByItself {
    int idCnt = 1;
    Map<Signature, Integer> sigMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      // get hash for every subtree, and store in a map
      Map<Signature, Integer> map = new HashMap<>(); // hashValueId -> frequency
      List<TreeNode> res = new ArrayList<>();

      if (root == null) return res;
      getId(root, map, res);

      return res;
    }

    private int getId(TreeNode curNode, Map<Signature, Integer> map, List<TreeNode> res) {
      if (curNode == null) {
        return 0; // give null a ID 0
      }

      int leftSubTreeId = getId(curNode.left, map, res);
      int rightSubTreeId = getId(curNode.right, map, res);

      Signature signature = new Signature(curNode.val, leftSubTreeId, rightSubTreeId);

      // hash is hard to work because the hash function parameters collide with values in treeNode
      // change to ID so it is uniq
      // long curHash = leftSubTreeHash * 887 + rightSubTreeHash * 997 + curNode.val + 7919;
      if (map.containsKey(signature)) {
        if (map.get(signature) < 2) {
          res.add(curNode); // only record the first duplicate
        }
        map.put(signature, map.get(signature) + 1);
        return sigMap.get(signature);
      } else {
        map.put(signature, 1);
        idCnt++;
        sigMap.put(signature, idCnt);
        return idCnt;
      }
    }

    private class Signature {
      public int val;
      public int leftId;
      public int rightId;

      public Signature(int val, int leftId, int rightId) {
        this.val = val;
        this.leftId = leftId;
        this.rightId = rightId;
      }

      @Override
      public boolean equals(Object sig) {
        Signature s = (Signature) sig;
        return this.val == s.val && this.leftId == s.leftId && this.rightId == s.rightId;
      }

      @Override
      public int hashCode() {
        return leftId * 13 + rightId * 17 + val + 31;
      }
    }
  }

  class Solution {
    private HashMap<String, Integer> subtrees;
    private List<TreeNode> result;

    private String helper(TreeNode root) {
      if (root != null) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(root.val);
        stringBuffer.append(",");
        stringBuffer.append(helper(root.left));
        stringBuffer.append(",");
        stringBuffer.append(helper(root.right));

        String s = stringBuffer.toString();
        if (subtrees.containsKey(s)) {
          if (subtrees.get(s) == 1) result.add(root);
          subtrees.put(s, subtrees.get(s) + 1);
        } else {
          subtrees.put(s, 1);
        }

        return s;
      }

      return "*";
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      subtrees = new HashMap<>();
      result = new LinkedList<>();
      helper(root);

      return result;
    }
  }

  public static void main(String[] args) {
    FindDuplicatedSubtrees_652 findDuplicatedSubtrees_652 = new FindDuplicatedSubtrees_652();
    Solution solution = findDuplicatedSubtrees_652.new Solution();

    TreeNode tree =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree =
        new TreeNode(
            0,
            new TreeNode(0, new TreeNode(0), null),
            new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree = new TreeNode(0, new TreeNode(0), new TreeNode(0));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree = new TreeNode(2, new TreeNode(1), new TreeNode(1));
    System.out.println(solution.findDuplicateSubtrees(tree));

    tree =
        new TreeNode(
            2, new TreeNode(2, new TreeNode(3), null), new TreeNode(2, new TreeNode(3), null));
    System.out.println(solution.findDuplicateSubtrees(tree));
  }
}
