package com.ihaveaname.java.datastructure.tree;

import com.ihaveaname.java.datastructure.Utils;

import java.util.*;
import java.util.Stack;

public class BTree<T> {

  BTreeNode<T> root = null;

  private ArrayList<T> getLeftSubTreeNodes(ArrayList<T> nodes) {
    ArrayList<T> result = new ArrayList<>();

    if (Utils.isOddValue(nodes.size()) && nodes.size() > 1) {
      int len = (nodes.size() - 1) >> 1;
      result.addAll(nodes.subList(1, len + 1));
    }

    return result;
  }

  private ArrayList<T> getRightSubTreeNodes(ArrayList<T> nodes) {
    ArrayList<T> result = new ArrayList<>();

    if (Utils.isOddValue(nodes.size()) && nodes.size() > 1) {
      int len = (nodes.size() - 1) >> 1;
      result.addAll(nodes.subList(len + 1, nodes.size()));
    }

    return result;
  }

  public void buildBTree(ArrayList<T> nodes) {
    root = buildTree(nodes);
  }

  private BTreeNode<T> buildTree(ArrayList<T> nodes) {
    if (nodes.size() == 0) return null;
    if (nodes.get(0) == null) return new BTreeNode<>(null, null, null);

    ArrayList<T> l = getLeftSubTreeNodes(nodes);
    ArrayList<T> r = getRightSubTreeNodes(nodes);
    root = new BTreeNode<>(buildTree(l), nodes.get(0), buildTree(r));

    return root;
  }

  BTreeNode<T> insertAsRoot(BTreeNode<T> newNode) {
    root = newNode;
    return root;
  }

  BTreeNode<T> insertAsLeftChild(BTreeNode<T> of, BTreeNode<T> newNode) {
    if (of != null) of.leftTree = newNode;
    return newNode;
  }

  BTreeNode<T> insertAsRightChild(BTreeNode<T> of, BTreeNode<T> newNode) {
    if (of != null) of.rightTree = newNode;
    return newNode;
  }

  public ArrayList<T> traverse_pre_order() {
    return traverse_pre_order(root);
  }

  private ArrayList<T> traverse_pre_order(BTreeNode<T> tree) {
    ArrayList<T> result = new ArrayList<>();

    if (tree != null) {
      result.add(tree.v);

      result.addAll(traverse_pre_order(tree.leftTree));
      result.addAll(traverse_pre_order(tree.rightTree));
    }

    return result;
  }

  public ArrayList<T> traverse_in_order() {
    return traverse_in_order(root);
  }

  private ArrayList<T> traverse_in_order(BTreeNode<T> tree) {
    ArrayList<T> result = new ArrayList<>();

    if (tree != null) {
      result.addAll(traverse_in_order(tree.leftTree));
      result.add(tree.v);
      result.addAll(traverse_in_order(tree.rightTree));
    }

    return result;
  }

  public ArrayList<T> dfs() {
    return dfs(root);
  }

  private ArrayList<T> dfs(BTreeNode<T> tree) {
    ArrayList<T> result = new ArrayList<>();

    if (tree == null) return result;
    else result.add(tree.v);

    result.addAll(dfs(tree.leftTree));
    result.addAll(dfs(tree.rightTree));

    return result;
  }

  public ArrayList<T> dfs_non_recursive() {
    return dfs_non_recursive(root);
  }

  private ArrayList<T> dfs_non_recursive(BTreeNode<T> tree) {
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

  public int height_dfs() {
    return height_dfs(root);
  }

  protected int height_dfs(BTreeNode<T> tree) {
    if (tree == null) return 0;

    return Math.max(height_dfs(tree.leftTree), height_dfs(tree.rightTree)) + 1;
  }

  public int height_dfs_non_recursive() {
    return height_dfs_non_recursive(root);
  }

  protected int height_dfs_non_recursive(BTreeNode<T> tree) {
    class Frame {
      int level;
      BTreeNode<T> node;

      Frame(int level, BTreeNode<T> node) {
        this.level = level;
        this.node = node;
      }
    }

    if (tree == null) {
      return 0;
    }

    java.util.Stack<Frame> stack = new Stack<>();
    stack.push(new Frame(1, tree));

    int waterMark = 1;
    while (!stack.empty()) {
      Frame current = stack.pop();
      if (current.node != null) {
        waterMark = Math.max(waterMark, current.level);
        stack.push(new Frame(current.level + 1, current.node.leftTree));
        stack.push(new Frame(current.level + 1, current.node.rightTree));
      }
    }

    return waterMark;
  }

  public ArrayList<ArrayList<T>> bfs() {
    return bfs(root);
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

  public ArrayList<ArrayList<T>> bfs_with_queue() {
    return bfs_with_queue(root);
  }

  private ArrayList<ArrayList<T>> bfs_with_queue(BTreeNode<T> tree) {
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
