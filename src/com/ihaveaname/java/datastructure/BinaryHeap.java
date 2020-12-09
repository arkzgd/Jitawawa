package com.ihaveaname.java.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinaryHeap<T> implements Heap<T> {

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
  public void insert(T v) {}

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
    this.comparator = comparator;
    List<T> storage = new ArrayList<>(capacity);
    array = (T[]) storage.toArray();
    Arrays.fill(array, null);
  }

  private void persolateDown(int hole) {
    int size = currentSize();
    T v = array[size - 1];
    int current = hole;
    int lchild = hole * 2;
    int rchild = hole * 2 + 1;
    while (true) {
      if (lchild >= size) {
        return;
      } else if (rchild >= size) {
        if (comparator.compare(v, array[lchild]) > 0) {
          array[current] = array[lchild];
          current = lchild;
        }
      } else {
        if (comparator.compare(array[current], array[lchild]) > 0) {
          array[current] = array[lchild];
          current = lchild;
        } else if (comparator.compare(array[current], array[rchild]) > 0) {
          array[current] = array[rchild];
          current = rchild;
        } else {
          array[current] = v;
          if (current < size - 1) {
            array[size - 1] = null;
          }
          return;
        }
      }
    }
  }

  private void persolateUp(int hole) {}

  private void buildHeap(T[] items, Comparator<T> comparator) {}

  private void enlargeArray(int newCapacity) {
    List<T> newStorage = new ArrayList<>(newCapacity);
    T[] newArray = (T[]) newStorage.toArray();
    Arrays.fill(newArray, null);

    System.arraycopy(array, 0, newArray, 0, currentSize());
    array = newArray;
  }
}
