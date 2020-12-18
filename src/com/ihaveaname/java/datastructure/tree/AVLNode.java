package com.ihaveaname.java.datastructure.tree;

import java.util.Comparator;

public class AVLNode<V> {
  private int balanceFactor;
  private V v;

  public AVLNode(V v) {
    this.v = v;
  }

  public int getBalanceFactor() {
    return balanceFactor;
  }

  public void setBalanceFactor(int balanceFactor) {
    this.balanceFactor = balanceFactor;
  }

  public V getV() {
    return v;
  }

  public void setV(V v) {
    this.v = v;
  }
}