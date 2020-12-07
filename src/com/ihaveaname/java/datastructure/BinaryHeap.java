package com.ihaveaname.java.datastructure;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable> implements Heap<T> {

  public BinaryHeap() {
    initialize(DEFAULT_CAPACITY);
  }

  public BinaryHeap(int initialCapacity) {
    initialize(initialCapacity);
  }

  public BinaryHeap(T[] items) {
    initialize(items.length);
    buildHeap(items);
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
    initialize(DEFAULT_CAPACITY);
  }

  private static final int DEFAULT_CAPACITY = 10;

  private int currentSize() {
    return Math.toIntExact(Arrays.stream(array).takeWhile(t -> t != null).count());
  }

  private T[] array;

  private void initialize(int capacity) {
    array = (T[]) new Object[Math.toIntExact(capacity)];
    Arrays.fill(array, null);
  }

  private void persolateDown(int hole) {}

  private void persolateUp(int hole) {}

  private void buildHeap(T[] items) {}

  private void enlargeArray(int newSize) {
    T[] newArray = (T[]) new Object[Math.toIntExact(newSize)];
    Arrays.fill(newArray, null);

    System.arraycopy(array, 0, newArray, 0, currentSize());
    array = newArray;
  }
}
