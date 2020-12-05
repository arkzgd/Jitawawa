package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Util.nextGap;
import static com.ihaveaname.java.tinyalgos.sorting.Util.swap;

public class CombSort {
  public static <T> List<T> combSort(List<T> input, Comparator<T> comparator) {
    T[] array = (T[]) input.toArray();

    int length = array.length;
    int gap = length;
    boolean sorted = false;

    while (sorted == false) {
      if (gap == 1) {
        sorted = true;
      }
      for (int i = 0; i < length - gap; i++) {
        if (comparator.compare(array[i], array[i + gap]) > 0)  {
          swap(array, i, i + gap);
          sorted =  false;
        }
      }
      gap = nextGap(gap);
    }

    ArrayList<T> result = new ArrayList<>();
    result.addAll(Arrays.asList(array));

    return result;
  }
}
