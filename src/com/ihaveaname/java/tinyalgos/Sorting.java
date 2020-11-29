package com.ihaveaname.java.tinyalgos;

import java.util.*;

public class Sorting {

  public static <T> List<T> bubbleSort(List<T> input, Comparator<T> comparator) {
    T[] array = (T[]) input.toArray();
    int length = array.length;
    boolean swapped;

    for (int i = 0; i < length; i++) {
      do {
        swapped = false;
        for (int j = i; j < length - 1; j++) {
          if (comparator.compare(array[j], array[j + 1]) > 0) swapped = swap(array, j, j + 1);
        }
      } while (swapped);
    }

    ArrayList<T> result = new ArrayList<>();
    result.addAll(Arrays.asList(array));

    return result;
  }

  private static <T> boolean checkAscendingOrder(List<T> input, Comparator<T> comparator) {
    for (int i = 0; i < input.size() - 1; i++) {
      if (comparator.compare(input.get(i), input.get(i + 1)) > 0) return false;
    }

    return true;
  }

  private static <T> boolean swap(T[] array, int i, int j) {
    boolean sanity = 0 <= i && i < array.length && 0 <= j && j < array.length;
    if (i != j && sanity) {
      T v = array[i];
      array[i] = array[j];
      array[j] = v;
      return true;
    }
    else
      return false;
  }

  public static void main(String[] args) {
    List input = new ArrayList<Integer>(10000);
    for (int i = 10000; i > 0; i--) input.add(i);
    assert checkAscendingOrder(bubbleSort(input, Integer::compareTo), Integer::compareTo);

    input = new ArrayList<Integer>(Arrays.asList(4, 23, 6, 78, 1, 54, 231, 9, 12));
    assert checkAscendingOrder(bubbleSort(input, Integer::compareTo), Integer::compareTo);

    input = new ArrayList<String>(Arrays.asList("c", "a", "e", "b", "d"));
    assert checkAscendingOrder(bubbleSort(input, String::compareTo), String::compareTo);
  }
}
