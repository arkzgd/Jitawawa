package com.ihaveaname.java.datastructure.tree;

public class AVLNode<V> {
  public int height;
  public V v;
  public AVLNode<V> leftTree;
  public AVLNode<V> rightTree;

  public AVLNode(AVLNode<V> leftTree, V v, AVLNode<V> rightTree) {
    this.v = v;
    this.leftTree = leftTree;
    this.rightTree = rightTree;
    this.height = 0;
  }
}
