package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BinaryHeap;

public class AppBinaryHeapBigTopWithDup {
  public static void main(String[] args) {
    BinaryHeap<Integer> heap = new BinaryHeap<>((o1, o2) -> o2 - o1);

    assert heap.isEmpty();
    assert heap.isHeap();

    int numElements = 10;
    for (int i = 1; i <= numElements; i++) for (int j = i; j <= numElements; j++) heap.insert(j);

    assert heap.isHeap();
    while (!heap.isEmpty()) {
      System.out.print(heap.deleteMin() + " ");
      assert heap.isHeap();
    }
  }
}
