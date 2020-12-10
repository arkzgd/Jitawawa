package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BinaryHeap;
import com.ihaveaname.java.datastructure.Heap;

public class AppBinaryHeap {
  public static void main(String[] args) {
    Heap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
    assert heap.isEmpty();

    for (int v = 20; v > 0; v--) {
      heap.insert(v);
      assert heap.isHeap();
    }

    assert heap.findMin() == 1;

    heap.makeEmpty();
    assert heap.isEmpty();
  }
}
