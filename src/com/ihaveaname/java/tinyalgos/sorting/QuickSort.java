package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Utils.swap;

public class QuickSort {
  public static <T> int partition_Lomuto(T[] input, int low, int high, Comparator<T> comparator) {
    int length = high - low;
    if (length <= 0) return -1;
    T pivot = input[high];
    int i = low;
    for (int j = low; j <= high; j++) {
      if (comparator.compare(input[j], pivot) < 0) {
        swap(input, i, j);
        i++;
      }
    }
    swap(input, i, high);

    return i;
  }

  private static <T> T[] quickSort_array(T[] input, int low, int high, Comparator<T> comparator) {
    int p = partition_Lomuto(input, low, high, comparator);
    if (p != -1) {
      quickSort_array(input, low, p - 1, comparator);
      quickSort_array(input, p + 1, high, comparator);
    }

    return input;
  }

  public static <T> List<T> quickSort(List<T> input, Comparator<T> comparator) {
    T[] array = (T[]) input.toArray();
    int length = array.length;
    List<T> result = new ArrayList<>(length);

    array = quickSort_array(array, 0, length - 1, comparator);

    result.addAll(Arrays.asList(array));
    return result;
  }
}
