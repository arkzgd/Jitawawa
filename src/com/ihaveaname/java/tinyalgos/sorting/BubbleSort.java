package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Utils.swap;

public class BubbleSort {
  public static <T> List<T> bubbleSort(ArrayList<T> input, Comparator<T> comparator) {
    int length = input.size();
    boolean swapped;

    for (int i = 0; i < length; i++) {
      do {
        swapped = false;
        for (int j = i; j < length - 1; j++) {
          if (comparator.compare(input.get(j), input.get(j + 1)) > 0) swapped = swap(input, j, j + 1);
        }
      } while (swapped);
    }

    return input;
  }
}
