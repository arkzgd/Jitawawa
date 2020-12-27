package com.ihaveaname.java.datastructure;

import java.util.List;

public interface Heap<T> {
  void insert(T v);
  void insert(List<T> values);
  T getTop();
  T deleteTop();
  int size();
  boolean isEmpty();
  void clear();
  boolean isHeap();
}