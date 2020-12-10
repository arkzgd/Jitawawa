package com.ihaveaname.java.datastructure;

public interface Heap<T> {
  void insert(T v);
  T findMin();
  T deleteMin();
  boolean isEmpty();
  void makeEmpty();
  boolean isHeap();
}