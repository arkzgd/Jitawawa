package com.ihaveaname.java.datastructure.tree;

public class AVLNode<V> {
  public int balanceFactor;
  public V v;

  public AVLNode(V v) {
    this.v = v;
  }
}