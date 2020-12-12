package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppBTree {
  public static void main(String[] args) {
    BTree<Integer> iBTree = new BTree<>();

    Integer[] input = {3, 4, null, null, 20, 15, 7};
    ArrayList<Integer> nodes = new ArrayList<>();
    nodes.addAll(Arrays.asList(input));
    BTree.BTreeNode<Integer> tree = iBTree.buildBTree(nodes);

    List<Integer> traversed = iBTree.traverse_pre_order(tree);
    System.out.println(traversed);

    List<Integer> dfsed = iBTree.dfs(tree);
    System.out.println(dfsed);

    List<Integer> dfsed_non_recursive = iBTree.dfs_non_recursive(tree);
    System.out.println(dfsed_non_recursive);

    int h = iBTree.height_dfs(tree);
    System.out.println("tree has height: " + h);

    h = iBTree.height_dfs_non_recursive(tree);
    System.out.println("tree has height: " + h);

    ArrayList<ArrayList<Integer>> ll = iBTree.bfs(tree);
    System.out.println("tree traversed by level: " + Arrays.toString(ll.toArray()));

    ll = iBTree.bfs_with_queue(tree);
    System.out.println("tree traversed by level: " + Arrays.toString(ll.toArray()));
  }
}
