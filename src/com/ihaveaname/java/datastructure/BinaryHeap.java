package com.ihaveaname.java.datastructure;

import java.util.*;

public class BinaryHeap<T> implements Heap<T> {

  private Comparator<T> comparator;
  private ArrayList<T> array;
  private static final int DEFAULT_CAPACITY = 10;

  public BinaryHeap(Comparator<T> comparator) {
    initialize(DEFAULT_CAPACITY, comparator);
  }

  public BinaryHeap(int initialCapacity, Comparator<T> comparator) {
    initialize(initialCapacity, comparator);
  }

  public BinaryHeap(List<T> items, Comparator<T> comparator) {
    initialize(items.size(), comparator);
    buildHeap(items, comparator);
  }

  @Override
  public void insert(T v) {
    array.add(v);
    persolateUp(array.size() - 1);
  }

  @Override
  public void insert(List<T> values) {
    for (T v : values) insert(v);
  }

  @Override
  public T getTop() {
    if (isEmpty()) throw new IllegalStateException("BinaryHeap is empty");

    return array.get(0);
  }

  @Override
  public T deleteTop() {
    T min = getTop();
    persolateDown(0);

    return min;
  }

  @Override
  public int size() {
    return array.size();
  }

  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public void clear() {
    initialize(DEFAULT_CAPACITY, comparator);
  }

  private void initialize(int capacity, Comparator<T> comparator) {
    this.comparator = comparator;
    array = new ArrayList<>(capacity);
  }

  private int calcChild(int current) {
    return 2 * current + 1;
  }

  private void persolateDown(int hole) {
    int size = array.size();
    T v = array.get(size - 1);
    array.remove(size - 1);
    size = array.size();
    if (size == 0) return;

    int current = hole;
    int child = calcChild(current);

    while (child < size) {
      if (child + 1 < size && comparator.compare(array.get(child), array.get(child + 1)) > 0)
        child++;

      if (comparator.compare(v, array.get(child)) > 0) {
        array.set(current, array.get(child));
        current = child;
        child = calcChild(current);
      } else break;
    }

    array.set(current, v);
  }

  private int calcParent(int current) {
    if (current % 2 == 0) return (current - 1) / 2;
    else return current / 2;
  }

  private void persolateUp(int hole) {
    if (hole == 0) return;

    T v = array.get(hole);
    int current = hole;
    int parent;

    do {
      parent = calcParent(current);
      if (comparator.compare(v, array.get(parent)) < 0) {
        array.set(current, array.get(parent));
        current = parent;
      } else break;
    } while (parent > 0);

    array.set(current, v);
  }

  private void buildHeap(List<T> items, Comparator<T> comparator) {
    for (T e : items) insert(e);
  }

  @Override
  public boolean isHeap() {
    for (int i = 0; i < array.size(); i++) {
      int lchild = i * 2 + 1;
      int rchild = i * 2 + 2;
      if (lchild < array.size()) {
        if (rchild < array.size()) {
          if (comparator.compare(array.get(rchild), array.get(i)) < 0) return false;
        } else {
          if (comparator.compare(array.get(lchild), array.get(i)) < 0) return false;
        }
      }
    }

    return true;
  }
}
