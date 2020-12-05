package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.InsertSort.insertSort;
import static com.ihaveaname.java.tinyalgos.sorting.Util.nextGap;

public class ShellSort {
  public static <T> List<T> shellSort(List<T> input, Comparator<T> comparator) {
    int length = input.size();
    List<T> result = new ArrayList<>(length);
    T[] array = (T[]) input.toArray();

    for(int gap = length; gap > 1; gap = nextGap(gap)) {
      array = insertSort(array, gap, comparator);
    }
    array = insertSort(array, 1, comparator);

    result.addAll(Arrays.asList(array));
    return result;
  }
}
