package com.ihaveaname.java.datastructure.tree;

public class BTreeNode<T> {
  public T v;
  public BTreeNode<T> leftTree;
  public BTreeNode<T> rightTree;

  public BTreeNode(BTreeNode<T> left, T v, BTreeNode<T> right) {
    this.v = v;
    this.leftTree = left;
    this.rightTree = right;
  }
}
