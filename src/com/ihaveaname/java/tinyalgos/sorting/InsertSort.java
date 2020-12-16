package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertSort {
  public static <T> List<T> insertSort(ArrayList<T> input, Comparator<T> comparator) {
    return insertSort_with_gap(input, 1, comparator);
  }

  public static <T> ArrayList<T> insertSort_with_gap(ArrayList<T> input, int gap, Comparator<T> comparator) {
    int length = input.size();
    for (int i = gap; i < length; i++) {
      T v = input.get(i);
      int j = i;
      while (j >= gap) {
        if (comparator.compare(input.get(j - gap), v) > 0) {
          input.set(j, input.get(j - gap));
          j -= gap;
        } else break;
      }
      input.set(j, v);
    }

    return input;
  }

  public static void main(String[] args) {}
}
