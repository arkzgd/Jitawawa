package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Utils.swap;

public class QuickSort {
  public static <T> int partition_Lomuto(ArrayList<T> input, int low, int high, Comparator<T> comparator) {
    int length = high - low;
    if (length <= 0) return -1;
    T pivot = input.get(high);
    int i = low;
    for (int j = low; j <= high; j++) {
      if (comparator.compare(input.get(j), pivot) < 0) {
        swap(input, i, j);
        i++;
      }
    }
    swap(input, i, high);

    return i;
  }

  private static <T> ArrayList<T> quickSort_array(ArrayList<T> input, int low, int high, Comparator<T> comparator) {
    int p = partition_Lomuto(input, low, high, comparator);
    if (p != -1) {
      quickSort_array(input, low, p - 1, comparator);
      quickSort_array(input, p + 1, high, comparator);
    }

    return input;
  }

  public static <T> List<T> quickSort(ArrayList<T> input, Comparator<T> comparator) {
    int length = input.size();

    quickSort_array(input, 0, length - 1, comparator);

    return input;
  }
}
