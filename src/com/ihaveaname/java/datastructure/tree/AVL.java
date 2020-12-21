package com.ihaveaname.java.datastructure.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AVL<T> {

  private AVLNode<T> root;
  private final Comparator<T> comparator;

  public AVL(Comparator<T> comparator) {
    root = null;
    this.comparator = comparator;
  }

  private int height(AVLNode<T> node) {
    return (node == null) ? -1 : node.height;
  }

  private int balanceFactor(AVLNode<T> node) {
    return (node == null) ? 0 : height(node.leftTree) - height(node.rightTree);
  }

  private AVLNode<T> balanceNode(AVLNode<T> node) {
    if (node == null) return null;

    int balance = balanceFactor(node);
    // System.out.println("Balancing: " + node.v + " of " + balance);
    if (balance > 1) {
      if (balanceFactor(node.leftTree) < 0) node = doubleRotateWithLeftChild(node);
      else node = rotateWithLeftChild(node);
    } else if (balance < -1) {
      if (balanceFactor(node.rightTree) > 0) node = doubleRotateWithRightChild(node);
      else node = rotateWithRightChild(node);
    }

    // System.out.println("Balanced: " + node.v + " of " + balanceFactor(node));
    return node;
  }

  private void updateNodeHeight(AVLNode<T> node) {
    if (node != null) node.height = Math.max(height(node.leftTree), height(node.rightTree)) + 1;
  }

  public void insert(T v) {
    root = insert(v, root);
  }

  private AVLNode<T> insert(T v, AVLNode<T> node) {
    if (node == null) return new AVLNode<>(null, v, null);

    int compareResult = comparator.compare(v, node.v);
    if (compareResult < 0) {
      node.leftTree = insert(v, node.leftTree);
    } else if (compareResult > 0) {
      node.rightTree = insert(v, node.rightTree);
    }

    updateNodeHeight(node);
    node = balanceNode(node);

    return node;
  }

  public void remove(T v) {
    root = remove(v, root);
  }

  private AVLNode<T> remove(T v, AVLNode<T> node) {
    if (node == null) return null;

    int compareResult = comparator.compare(node.v, v);
    if (compareResult > 0) {
      node.leftTree = remove(v, node.leftTree);
    } else if (compareResult < 0) {
      node.rightTree = remove(v, node.rightTree);
    } else {
      if (node.leftTree != null && node.rightTree != null) {
        AVLNode<T> rightMinNode = mostLeftChild(node.rightTree);
        node.v = rightMinNode.v;
        node.rightTree = remove(rightMinNode.v, node.rightTree);
      } else {
        node = (node.leftTree != null) ? node.leftTree : node.rightTree;
      }
    }

    updateNodeHeight(node);
    node = balanceNode(node);

    return node;
  }

  private AVLNode<T> mostLeftChild(AVLNode<T> node) {
    if (node == null) return null;

    AVLNode<T> lc = node;
    while (lc.leftTree != null) lc = lc.leftTree;

    return lc;
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

    int balanceFactor = Math.abs(balanceFactor(node));
    if (balanceFactor > 1)
      throw new IllegalStateException(
          "node ["
              + node.v
              + "] left height: "
              + height(node.leftTree)
              + " right height: "
              + height(node.rightTree));
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
