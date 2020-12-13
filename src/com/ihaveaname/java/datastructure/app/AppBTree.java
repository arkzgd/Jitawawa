package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppBTree {
  public static void main(String[] args) {
    BTree<Integer> iBTree = new BTree<>();

    /*
     *   Construct a tree as below.
     *   input is a complete binary tree traversed in pre-order.
     *            1
     *           2 3
     *         4 5 6 7
     *     8 9 n n n n n n
     */
    Integer[] input = {1, 2, 4, 8, 9, 5, null, null, 3, 6, null, null, 7, null, null};
    ArrayList<Integer> nodes = new ArrayList<>();
    nodes.addAll(Arrays.asList(input));
    BTree.BTreeNode<Integer> tree = iBTree.buildBTree(nodes);

    List<Integer> traversed = iBTree.traverse_pre_order(tree);
    assert Arrays.equals(input, traversed.toArray());
    System.out.println(traversed);

    List<Integer> dfsed = iBTree.dfs(tree);
    assert Arrays.equals(input, dfsed.toArray());
    System.out.println(dfsed);

    List<Integer> dfsed_non_recursive = iBTree.dfs_non_recursive(tree);
    assert Arrays.equals(input, dfsed_non_recursive.toArray());
    System.out.println(dfsed_non_recursive);

    int h = iBTree.height_dfs(tree);
    assert h == 4;
    System.out.println("tree has height: " + h);

    h = iBTree.height_dfs_non_recursive(tree);
    assert h == 4;
    System.out.println("tree has height: " + h);

    ArrayList<ArrayList<Integer>> ll = iBTree.bfs(tree);
    System.out.println("tree traversed by level: " + Arrays.toString(ll.toArray()));

    ll = iBTree.bfs_with_queue(tree);
    System.out.println("tree traversed by level: " + Arrays.toString(ll.toArray()));
  }
}
