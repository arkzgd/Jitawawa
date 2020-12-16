package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Utils.nextGap;
import static com.ihaveaname.java.tinyalgos.sorting.Utils.swap;

public class CombSort {
  public static <T> List<T> combSort(ArrayList<T> input, Comparator<T> comparator) {
    int length = input.size();
    int gap = length;
    boolean sorted = false;

    while (sorted == false) {
      if (gap == 1) {
        sorted = true;
      }
      for (int i = 0; i < length - gap; i++) {
        if (comparator.compare(input.get(i), input.get(i + gap)) > 0) {
          swap(input, i, i + gap);
          sorted = false;
        }
      }
      gap = nextGap(gap);
    }

    return input;
  }
}
