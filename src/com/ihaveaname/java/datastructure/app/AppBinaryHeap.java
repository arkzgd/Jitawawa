package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BinaryHeap;
import com.ihaveaname.java.datastructure.Heap;
import com.ihaveaname.java.tinyalgos.sorting.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppBinaryHeap {
  public static void main(String[] args) {
    Heap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
    assert heap.isEmpty();

    for (int v = 2000; v > 0; v--) {
      heap.insert(v);
      assert heap.isHeap();
    }

    assert heap.findMin() == 1;

    List<Integer> sorted = new ArrayList<>(2000);
    while (!heap.isEmpty()) {
      sorted.add(heap.deleteMin());
    }
    assert Util.checkAscendingOrder(sorted, Integer::compareTo);

    heap.makeEmpty();
    assert heap.isEmpty();
  }
}
