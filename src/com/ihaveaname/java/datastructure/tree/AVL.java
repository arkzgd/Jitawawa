package com.ihaveaname.java.datastructure.tree;

import java.util.Comparator;

public class AVL<T> {

  private AVLNode<T> root;
  private Comparator<T> comparator;

  public AVL(Comparator<T> comparator) {
    root = null;
    this.comparator = comparator;
  }

  private int height(AVLNode<T> node) {
    return (node == null) ? -1 : node.height;
  }

  public void insert(T v) {
    root = insert(v, root);
  }

  private AVLNode<T> insert(T v, AVLNode<T> node) {
    if (node == null) return new AVLNode<>(null, v, null);

    int compareResult = comparator.compare(v, node.v);
    if (compareResult < 0) {
      node.leftTree = insert(v, node.leftTree);
      if (height(node.leftTree) - height(node.rightTree) == 2) {
        if (comparator.compare(v, node.leftTree.v) < 0) node = rotateWithLeftChild(node);
        else node = doubleRotateWithLeftChild(node);
      }
    } else if (compareResult > 0) {
      node.rightTree = insert(v, node.rightTree);
      if (height(node.leftTree) - height(node.rightTree) == -2) {
        if (comparator.compare(v, node.rightTree.v) < 0) node = doubleRotateWithRightChild(node);
        else node = rotateWithRightChild(node);
      }
    }

    node.height = Math.max(height(node.leftTree), height(node.rightTree)) + 1;

    return node;
  }

  private AVLNode<T> rotateWithLeftChild(AVLNode<T> node) {
    return node;
  }

  private AVLNode<T> doubleRotateWithLeftChild(AVLNode<T> node) {
    return node;
  }

  private AVLNode<T> rotateWithRightChild(AVLNode<T> node) {
    return node;
  }

  private AVLNode<T> doubleRotateWithRightChild(AVLNode<T> node) {
    return node;
  }
}
