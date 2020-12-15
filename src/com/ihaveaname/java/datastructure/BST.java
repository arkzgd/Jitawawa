package com.ihaveaname.java.datastructure;

import com.ihaveaname.java.datastructure.BTree.BTreeNode;

import java.util.Comparator;
import java.util.List;

public class BST<T> {
  private Comparator<T> comparator;

  private BTree<T> tree;

  public BST(Comparator<T> comparator) {
    tree = new BTree<>();
    this.comparator = comparator;
  }

  public boolean isBST() {
    return isBST(tree.root);
  }

  private boolean isBST(BTreeNode<T> root) {
    if (root == null) return true;

    BTreeNode<T> leftMax;
    if (root.leftTree != null) leftMax = findMax(root.leftTree);
    else leftMax = null;

    BTreeNode<T> rightMin;
    if (root.rightTree != null) rightMin = findMin(root.rightTree);
    else rightMin = null;

    Boolean leftTreeComplied =
        leftMax == null || (leftMax != null && comparator.compare(leftMax.v, root.v) < 0);
    Boolean rightTreeComplied =
        rightMin == null || (rightMin != null && comparator.compare(rightMin.v, root.v) > 0);

    return leftTreeComplied && rightTreeComplied && isBST(root.leftTree) && isBST(root.rightTree);
  }

  public T insert(T v) {
    Pair<BTreeNode<T>, BTreeNode<T>> found = find(v);

    if (found.v != null) return found.v.v;

    BTreeNode<T> newNode = new BTreeNode(null, v, null);
    if (found.u == null) return tree.insertAsRoot(newNode).v;
    else {
      if (comparator.compare(found.u.v, v) > 0) return tree.insertAsLeftChild(found.u, newNode).v;
      else return tree.insertAsRightChild(found.u, newNode).v;
    }
  }

  private BTreeNode<T> findMin(BTreeNode<T> ofRoot) {
    BTreeNode<T> lc = ofRoot;
    while (lc.leftTree != null) lc = lc.leftTree;

    return lc;
  }

  private BTreeNode<T> findMax(BTreeNode<T> ofRoot) {
    BTreeNode<T> rc = ofRoot;
    while (rc.rightTree != null) rc = rc.rightTree;

    return rc;
  }

  public void remove(T v) {
    tree.root = remove(v, tree.root);
  }

  private BTreeNode<T> remove(T v, BTreeNode<T> root) {
    if (root == null) return null;

    int compareResult = comparator.compare(root.v, v);
    if (compareResult > 0) {
      root.leftTree = remove(v, root.leftTree);
    } else if (compareResult < 0) {
      root.rightTree = remove(v, root.rightTree);
    } else if (root.leftTree != null && root.rightTree != null) {
      T rightMin = findMin(root.rightTree).v;
      Pair<BTreeNode<T>, BTreeNode<T>> found = find(rightMin);
      root.v = rightMin;
      BTreeNode<T> parent = found.u;
      BTreeNode<T> node = found.v;
      if (node == parent.leftTree) {
        parent.leftTree = node.rightTree;
      }
      else {
        parent.rightTree = node.rightTree;
      }
    } else {
      root = (root.leftTree != null) ? root.leftTree : root.rightTree;
    }

    return root;
  }

  private Pair<BTreeNode<T>, BTreeNode<T>> find(T v) {
    BTreeNode<T> p = tree.root, parent = null;

    while (p != null && comparator.compare(p.v, v) != 0) {
      parent = p;
      if (comparator.compare(p.v, v) > 0) {
        p = p.leftTree;
      } else p = p.rightTree;
    }

    return new Pair<>(parent, p);
  }

  public boolean contains(T v) {
    return find(v).v != null;
  }

  public List<T> traverse_in_order() {
    return tree.traverse_in_order();
  }
}
