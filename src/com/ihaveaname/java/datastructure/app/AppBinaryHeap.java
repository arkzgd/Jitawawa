package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BinaryHeap;
import com.ihaveaname.java.datastructure.Heap;
import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppBinaryHeap {
  public static void main(String[] args) {
    Heap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
    assert heap.isEmpty();

    int numElements = 500000;

    for (int v = numElements; v > 0; v--) {
      heap.insert(v);
      assert heap.isHeap();
    }

    assert heap.findMin() == 1;

    List<Integer> sorted = new ArrayList<>(numElements);
    while (!heap.isEmpty()) {
      sorted.add(heap.deleteMin());
    }
    assert Utils.checkAscendingOrder(sorted, Integer::compareTo);
    assert heap.isEmpty();

    List<Integer> input = new ArrayList<>(numElements);
    for (int i = 1; i <= numElements; i++) input.add(i);
    Collections.shuffle(input);
    System.out.println(input);

    heap = new BinaryHeap<>(input, Integer::compareTo);
    assert heap.isHeap();
    sorted.clear();
    while (!heap.isEmpty()) {
      sorted.add(heap.deleteMin());
    }
    assert Utils.checkAscendingOrder(sorted, Integer::compareTo);
    System.out.println(sorted);
    assert heap.isEmpty();

    heap = new BinaryHeap<>(numElements, Integer::compareTo);
    for (int e: input) heap.insert(e);
    sorted.clear();
    while (!heap.isEmpty()) {
      sorted.add(heap.deleteMin());
    }
    assert Utils.checkAscendingOrder(sorted, Integer::compareTo);
    System.out.println(sorted);
    assert heap.isEmpty();

    heap.makeEmpty();
    assert heap.isEmpty();
    heap.insert(input);
    assert heap.isHeap();

    sorted.clear();
    while (!heap.isEmpty()) {
      sorted.add(heap.deleteMin());
    }
    assert Utils.checkAscendingOrder(sorted, Integer::compareTo);
    System.out.println(sorted);
    assert heap.isEmpty();
  }
}
