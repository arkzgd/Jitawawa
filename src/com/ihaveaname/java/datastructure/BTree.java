package com.ihaveaname.java.datastructure;

import java.util.*;
import java.util.Stack;

public class BTree<T> {

  public static class BTreeNode<T> {
    T v;
    BTreeNode<T> leftTree;
    BTreeNode<T> rightTree;

    public BTreeNode(BTreeNode<T> left, T v, BTreeNode<T> right) {
      this.v = v;
      this.leftTree = left;
      this.rightTree = right;
    }
  }

  private boolean isOddValue(int value) {
    return (value % 2) == 1;
  }

  private ArrayList<T> getLeftSubTreeNodes(ArrayList<T> nodes) {
    ArrayList<T> result = new ArrayList<>();

    if (isOddValue(nodes.size()) && nodes.size() > 1) {
      int len = (nodes.size() - 1) >> 1;
      result.addAll(nodes.subList(1, len + 1));
    }

    return result;
  }

  private ArrayList<T> getRightSubTreeNodes(ArrayList<T> nodes) {
    ArrayList<T> result = new ArrayList<>();

    if (isOddValue(nodes.size()) && nodes.size() > 1) {
      int len = (nodes.size() - 1) >> 1;
      result.addAll(nodes.subList(len + 1, nodes.size()));
    }

    return result;
  }

  public BTreeNode<T> buildBTree(ArrayList<T> nodes) {
    if (nodes.size() == 0) return null;

    if (nodes.get(0) == null) return null;

    ArrayList<T> l = getLeftSubTreeNodes(nodes);
    ArrayList<T> r = getRightSubTreeNodes(nodes);
    return new BTreeNode<>(buildBTree(l), nodes.get(0), buildBTree(r));
  }

  public ArrayList<T> traverse_pre_order(BTreeNode<T> tree) {
    ArrayList<T> result = new ArrayList<>();

    if (tree != null) {
      result.add(tree.v);

      result.addAll(traverse_pre_order(tree.leftTree));
      result.addAll(traverse_pre_order(tree.rightTree));
    }

    return result;
  }

  public ArrayList<T> dfs(BTreeNode<T> tree) {
    ArrayList<T> result = new ArrayList<>();

    if (tree == null) return result;
    else result.add(tree.v);

    result.addAll(dfs(tree.leftTree));
    result.addAll(dfs(tree.rightTree));

    return result;
  }

  public ArrayList<T> dfs_non_recursive(BTreeNode<T> tree) {
    ArrayList<T> result = new ArrayList<>();
    java.util.Stack<BTreeNode<T>> stack = new java.util.Stack<>();

    if (tree == null) return result;

    stack.push(tree);

    while (!stack.empty()) {
      BTreeNode<T> current = stack.pop();
      if (current != null) {
        result.add(current.v);
        stack.push(current.rightTree);
        stack.push(current.leftTree);
      }
    }

    return result;
  }

  public int height_dfs(BTreeNode<T> tree) {
    if (tree == null) return 0;

    return Math.max(height_dfs(tree.leftTree), height_dfs(tree.rightTree)) + 1;
  }

  public int height_dfs_non_recursive(BTreeNode<T> tree) {
    class Pair {
      int level;
      BTreeNode<T> node;

      Pair(int level, BTreeNode<T> node) {
        this.level = level;
        this.node = node;
      }
    }

    if (tree == null) {
      return 0;
    }

    int level = 1;
    java.util.Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(level, tree));

    int waterMark = 1;
    while (!stack.empty()) {
      Pair current = stack.pop();
      if (current.node != null) {
        stack.push(new Pair(current.level + 1, current.node.leftTree));
        stack.push(new Pair(current.level + 1, current.node.rightTree));
        if (current.level + 1 > waterMark
            && current.node.leftTree != null
            && current.node.rightTree != null) waterMark++;
      }
    }

    return waterMark;
  }

  public ArrayList<ArrayList<T>> bfs(BTreeNode<T> tree) {
    ArrayList<ArrayList<T>> result = new ArrayList<>();

    bfs_recursive(tree, 0, result);

    return result;
  }

  private void bfs_recursive(BTreeNode<T> tree, int level, ArrayList<ArrayList<T>> result) {
    if (tree == null) {
      return;
    }

    if (result.size() == level) result.add(new ArrayList<>());

    result.get(level).add(tree.v);

    bfs_recursive(tree.leftTree, level + 1, result);
    bfs_recursive(tree.rightTree, level + 1, result);
  }

  public ArrayList<ArrayList<T>> bfs_with_queue(BTreeNode<T> tree) {
    ArrayList<ArrayList<T>> result = new ArrayList<>();
    Queue<BTreeNode<T>> queue = new LinkedList<>();

    if (tree == null) return result;

    queue.offer(tree);

    while (!queue.isEmpty()) {
      int length = queue.size();
      ArrayList<T> thisLevel = new ArrayList<>();
      for (int i = 0; i < length; i++) {
        BTreeNode<T> node = queue.poll();
        if (node != null) {
          thisLevel.add(node.v);
          queue.offer(node.leftTree);
          queue.offer(node.rightTree);
        }
      }
      if (!thisLevel.isEmpty()) result.add(thisLevel);
    }

    return result;
  }
}
