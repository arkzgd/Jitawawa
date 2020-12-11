package com.ihaveaname.java.datastructure;

import java.util.*;

public class BinaryHeap<T> implements Heap<T> {

  int capacity;
  private Comparator<T> comparator;

  public BinaryHeap(Comparator<T> comparator) {
    initialize(DEFAULT_CAPACITY, comparator);
  }

  public BinaryHeap(int initialCapacity, Comparator<T> comparator) {
    initialize(initialCapacity, comparator);
  }

  public BinaryHeap(T[] items, Comparator<T> comparator) {
    initialize(items.length, comparator);
    buildHeap(items, comparator);
  }

  @Override
  public void insert(T v) {
    if (currentSize() == capacity) enlargeArray(currentSize() * 2);

    array[currentSize()] = v;
    persolateUp(currentSize() - 1);
  }

  @Override
  public T findMin() {
    if (isEmpty()) throw new IllegalStateException("BinaryHeap is empty");

    return array[0];
  }

  @Override
  public T deleteMin() {
    T min = findMin();
    persolateDown(0);

    return min;
  }

  @Override
  public boolean isEmpty() {
    return currentSize() == 0;
  }

  @Override
  public void makeEmpty() {
    initialize(DEFAULT_CAPACITY, comparator);
  }

  private static final int DEFAULT_CAPACITY = 10;

  private int currentSize() {
    return Math.toIntExact(Arrays.stream(array).takeWhile(t -> t != null).count());
  }

  private T[] array;

  private void initialize(int capacity, Comparator<T> comparator) {
    this.capacity = capacity;
    this.comparator = comparator;
    List<T> storage = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) storage.add(null);
    array = (T[]) storage.toArray();
  }

  private int calcLeftChild(int current) {
    return 2 * current + 1;
  }

  private void persolateDown(int hole) {
    int size = currentSize();
    T v = array[size - 1];
    int current = hole;
    int child = calcLeftChild(current);

    while (child < size) {
      if (child + 1 < size && comparator.compare(array[child], array[child + 1]) > 0) child++;

      if (comparator.compare(v, array[child]) > 0) {
        array[current] = array[child];
        current = child;
        child = calcLeftChild(current);
      } else break;
    }

    array[current] = v;
    if (current != size - 1 || size == 1) array[size - 1] = null;
  }

  private int calcParent(int current) {
    if (current % 2 == 0) return (current - 1) / 2;
    else return current / 2;
  }

  private void persolateUp(int hole) {
    if (hole == 0) return;

    T v = array[hole];
    int current = hole;
    int parent;

    do {
      parent = calcParent(current);
      if (comparator.compare(v, array[parent]) < 0) {
        array[current] = array[parent];
        current = parent;
      } else break;
    } while (parent > 0);

    array[current] = v;
  }

  private void buildHeap(T[] items, Comparator<T> comparator) {
    for (T e : items) insert(e);
  }

  private void enlargeArray(int newCapacity) {
    List<T> newStorage = new ArrayList<>(newCapacity);
    for (int i = 0; i < newCapacity; i++) newStorage.add(null);
    T[] newArray = (T[]) newStorage.toArray();

    System.arraycopy(array, 0, newArray, 0, currentSize());
    array = newArray;
    capacity = newCapacity;
  }

  @Override
  public boolean isHeap() {
    for (int i = 0; i < currentSize(); i++) {
      int lchild = i * 2 + 1;
      int rchild = i * 2 + 2;
      if (lchild < currentSize()) {
        if (rchild < currentSize()) {
          if (comparator.compare(array[rchild], array[i]) < 0) return false;
        } else {
          if (comparator.compare(array[lchild], array[i]) < 0) return false;
        }
      }
    }

    return true;
  }
}
