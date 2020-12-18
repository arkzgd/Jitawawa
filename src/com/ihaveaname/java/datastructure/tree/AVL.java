package com.ihaveaname.java.datastructure.tree;

import java.util.Comparator;

public class AVL<T> extends BST<AVLNode<T>> {

  public AVL(Comparator<AVLNode<T>> comparator) {
    super(comparator);
  }

  public void updateBalanceFactor() {
    updateBalanceFactor(tree.root);
  }

  private void updateBalanceFactor(BTreeNode<AVLNode<T>> root) {
    if (root == null) return;

    root.v.balanceFactor = height(root.leftTree) - height(root.rightTree);
    updateBalanceFactor(root.leftTree);
    updateBalanceFactor(root.rightTree);
  }
}
