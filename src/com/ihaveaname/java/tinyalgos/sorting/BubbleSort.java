package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Util.swap;

public class BubbleSort {
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
}
