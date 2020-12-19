package com.ihaveaname.java.datastructure.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

  // Right Rotate
  private AVLNode<T> rotateWithLeftChild(AVLNode<T> node) {
    AVLNode<T> l = node.leftTree;

    node.leftTree = l.rightTree;
    l.rightTree = node;

    node.height = Math.max(height(node.leftTree), height(node.rightTree)) + 1;
    l.height = Math.max(height(l.leftTree), height(l.rightTree)) + 1;

    return l;
  }

  // Node's Left Child, Left Rotate with its Right Child
  // Node Right Rotate with its new Left Child
  private AVLNode<T> doubleRotateWithLeftChild(AVLNode<T> node) {
    node.leftTree = rotateWithRightChild(node.leftTree);
    return rotateWithLeftChild(node);
  }

  // Left Rotate
  private AVLNode<T> rotateWithRightChild(AVLNode<T> node) {
    AVLNode<T> r = node.rightTree;

    node.rightTree = r.leftTree;
    r.leftTree = node;

    node.height = Math.max(height(node.leftTree), height(node.rightTree)) + 1;
    r.height = Math.max(height(r.leftTree), height(r.rightTree)) + 1;

    return r;
  }

  // Node's Right Child, Right Rotate with its Left Child
  // Node Left Rotate with its new Right Child
  private AVLNode<T> doubleRotateWithRightChild(AVLNode<T> node) {
    node.rightTree = rotateWithLeftChild(node.rightTree);
    return rotateWithRightChild(node);
  }

  public List<AVLNode<T>> traverse_in_order() {
    List<AVLNode<T>> result = new ArrayList<>();

    traverse_in_order(result, root);

    return result;
  }

  private void traverse_in_order(List<AVLNode<T>> result, AVLNode<T> node) {
    if (node == null) return;

    traverse_in_order(result, node.leftTree);
    result.add(node);
    traverse_in_order(result, node.rightTree);
  }

  public boolean isAVL() {
    return isAVL(root);
  }

  private boolean isAVL(AVLNode<T> node) {
    if (node == null) return true;

    int balanceFactor = Math.abs(height(node.leftTree) - height(node.rightTree));
    return (balanceFactor <= 1) && isAVL(node.leftTree) && isAVL(node.rightTree);
  }

  public BST<T> toBST() {
    return new BST<>(toBST(root), comparator);
  }

  private BTreeNode<T> toBST(AVLNode<T> node) {
    if (node == null) return null;

    return new BTreeNode<>(toBST(node.leftTree), node.v, toBST(node.rightTree));
  }
}
