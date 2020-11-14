package com.ihaveaname.java.tinyalgos;

import java.util.*;

public class BTree<V> {

  public static class BTreeNode<V> {
    V v;
    BTreeNode<V> leftTree;
    BTreeNode<V> rightTree;

    public BTreeNode(BTreeNode<V> left, V v, BTreeNode<V> right) {
      this.v = v;
      this.leftTree = left;
      this.rightTree = right;
    }
  }

  private boolean isOddValue(int value) {
    return (value % 2) == 1;
  }

  private V[] getLeftSubTreeNodes(V[] nodes) {
    List<V> result = new ArrayList<>();

    if (!isOddValue(nodes.length)) return (V[]) result.toArray();
    else {
      if (nodes.length == 1) return (V[]) result.toArray();
      int len = (nodes.length - 1) >> 1;
      return Arrays.copyOfRange(nodes, 1, len + 1);
    }
  }

  private V[] getRightSubTreeNodes(V[] nodes) {
    List<V> result = new ArrayList<>();

    if (!isOddValue(nodes.length)) return (V[]) result.toArray();
    else {
      if (nodes.length == 1) return (V[]) result.toArray();
      int len = (nodes.length - 1) >> 1;
      return Arrays.copyOfRange(nodes, len + 1, nodes.length);
    }
  }

  public BTreeNode<V> buildBTree(V[] nodes) {
    if (nodes.length == 0) return null;

    if (nodes[0] == null) return null;

    V[] l = getLeftSubTreeNodes(nodes);
    V[] r = getRightSubTreeNodes(nodes);
    return new BTreeNode<>(buildBTree(l), nodes[0], buildBTree(r));
  }

  public V[] traverse_pre_order(BTreeNode<V> tree) {
    List<V> result = new ArrayList<>();

    if (tree != null) {
      result.add(tree.v);

      Collections.addAll(result, traverse_pre_order(tree.leftTree));
      Collections.addAll(result, traverse_pre_order(tree.rightTree));
    }

    return (V[]) result.toArray();
  }

  public V[] dfs(BTreeNode<V> tree) {
    List<V> result = new ArrayList<>();

    if (tree == null) return (V[]) result.toArray();
    else result.add(tree.v);

    Collections.addAll(result, dfs(tree.leftTree));
    Collections.addAll(result, dfs(tree.rightTree));

    return (V[]) result.toArray();
  }

  public V[] dfs_non_recursive(BTreeNode<V> tree) {
    List<V> result = new ArrayList<>();
    Stack<BTreeNode<V>> stack = new Stack<>();

    if (tree == null) return (V[]) result.toArray();

    stack.push(tree);

    while (!stack.empty()) {
      BTreeNode<V> current = stack.pop();
      if (current != null) {
        result.add(current.v);
        stack.push(current.rightTree);
        stack.push(current.leftTree);
      }
    }

    return (V[]) result.toArray();
  }

  public int height_dfs(BTreeNode<V> tree) {
    if (tree == null) return 0;

    return Math.max(height_dfs(tree.leftTree), height_dfs(tree.rightTree)) + 1;
  }

  public int height_dfs_non_recursive(BTreeNode<V> tree) {
    class Pair {
      int level;
      BTreeNode<V> node;

      Pair(int level, BTreeNode<V> node) {
        this.level = level;
        this.node = node;
      }
    }

    if (tree == null) {
      return 0;
    }

    int level = 1;
    Stack<Pair> stack = new Stack<>();
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

  public ArrayList<ArrayList<V>> bfs(BTreeNode<V> tree) {
    ArrayList<ArrayList<V>> result = new ArrayList<>();

    bfs_recursive(tree, 0, result);

    return result;
  }

  private void bfs_recursive(BTreeNode<V> tree, int level, ArrayList<ArrayList<V>> result) {
    if (tree == null) {
      return;
    }

    if (result.size() == level) result.add(new ArrayList<>());

    result.get(level).add(tree.v);

    bfs_recursive(tree.leftTree, level + 1, result);
    bfs_recursive(tree.rightTree, level + 1, result);
  }

  public ArrayList<ArrayList<V>> bfs_with_queue(BTreeNode<V> tree) {
    ArrayList<ArrayList<V>> result = new ArrayList<>();
    Queue<BTreeNode<V>> queue = new LinkedList<>();

    if (tree == null) return result;

    queue.offer(tree);

    while (!queue.isEmpty()) {
      int length = queue.size();
      ArrayList<V> thisLevel = new ArrayList<>();
      for (int i = 0; i < length; i++) {
        BTreeNode<V> node = queue.poll();
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
