package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.sorting.Utils.nextGap;

public class ShellSort {
  public static <T> List<T> shellSort(ArrayList<T> input, Comparator<T> comparator) {
    int length = input.size();
    ArrayList<T> result = new ArrayList<>();

    for(int gap = length; gap > 1; gap = nextGap(gap)) {
      result = InsertSort.insertSort_with_gap(input, gap, comparator);
    }
    return InsertSort.insertSort_with_gap(result, 1, comparator);
  }
}
