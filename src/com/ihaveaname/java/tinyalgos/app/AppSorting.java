package com.ihaveaname.java.tinyalgos.app;

import java.util.*;

import static com.ihaveaname.java.tinyalgos.sorting.BubbleSort.bubbleSort;
import static com.ihaveaname.java.tinyalgos.sorting.CombSort.combSort;
import static com.ihaveaname.java.tinyalgos.sorting.Util.checkAscendingOrder;

public class AppSorting {
  public static void main(String[] args) {
    List input = new ArrayList<Integer>(1000);
    for (int i = 1000; i > 0; i--) input.add(i);
    assert checkAscendingOrder(bubbleSort(input, Integer::compareTo), Integer::compareTo);
    assert checkAscendingOrder(combSort(input, Integer::compareTo), Integer::compareTo);

    input = new ArrayList<Integer>(Arrays.asList(4, 23, 6, 78, 1, 54, 231, 9, 12));
    assert checkAscendingOrder(bubbleSort(input, Integer::compareTo), Integer::compareTo);
    assert checkAscendingOrder(combSort(input, Integer::compareTo), Integer::compareTo);

    input = new ArrayList<String>(Arrays.asList("c", "a", "e", "b", "d"));
    assert checkAscendingOrder(bubbleSort(input, String::compareTo), String::compareTo);
    assert checkAscendingOrder(combSort(input, String::compareTo), String::compareTo);
  }
}
