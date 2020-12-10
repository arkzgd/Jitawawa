package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BinaryHeap;
import com.ihaveaname.java.datastructure.Heap;

public class AppBinaryHeap {
  public static void main(String[] args) {
    Heap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
    assert heap.isEmpty();

    heap.insert(1);
    assert !heap.isEmpty();

    heap.insert(2);
    heap.insert(0);
    heap.insert(4);

    assert heap.findMin() == 0;
  }
}
