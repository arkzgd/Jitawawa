package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertSort {
  public static <T> List<T> insertSort(List<T> input, int gap, Comparator<T> comparator) {
    List<T> result = new ArrayList<>();

    T[] sorted = insertSort((T[]) input.toArray(), gap, comparator);

    result.addAll(Arrays.asList(sorted));
    return result;
  }

  public static <T> T[] insertSort(T[] input, int gap, Comparator<T> comparator) {
    int length = input.length;
    for (int i = gap; i < length; i++) {
      T v = input[i];
      int j = i;
      while (j >= gap) {
        if (comparator.compare(input[j - gap], v) > 0) {
          input[j] = input[j - gap];
          j -= gap;
        } else break;
      }
      input[j] = v;
    }

    return input;
  }

  public static void main(String[] args) {}
}
