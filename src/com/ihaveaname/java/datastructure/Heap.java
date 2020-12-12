package com.ihaveaname.java.datastructure;

import java.util.List;

public interface Heap<T> {
  void insert(T v);
  void insert(List<T> values);
  T findMin();
  T deleteMin();
  boolean isEmpty();
  void makeEmpty();
  boolean isHeap();
}