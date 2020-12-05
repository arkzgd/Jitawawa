package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertSort {
  public static <T> List<T> insertSort(List<T> input, Comparator<T> comparator) {
    List<T> result = new ArrayList<>();

    T[] array = (T[]) input.toArray();
    int length = array.length;
    for (int i = 1; i < length; i++) {
      T v = array[i];
      int j = i - 1;
      while (j >= 0) {
        if (comparator.compare(array[j], v) >= 0) {
          array[j + 1] = array[j];
          j--;
        } else break;
      }
      if (j < 0) j = 0;
      array[j] = v;
    }

    result.addAll(Arrays.asList(array));
    return result;
  }

  public static void main(String[] args) {}
}
