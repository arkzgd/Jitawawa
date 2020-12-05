package com.ihaveaname.java.tinyalgos.app;

import java.util.*;

import static com.ihaveaname.java.tinyalgos.sorting.BubbleSort.bubbleSort;
import static com.ihaveaname.java.tinyalgos.sorting.CombSort.combSort;
import static com.ihaveaname.java.tinyalgos.sorting.InsertSort.insertSort;
import static com.ihaveaname.java.tinyalgos.sorting.ShellSort.shellSort;
import static com.ihaveaname.java.tinyalgos.sorting.Util.checkAscendingOrder;

public class AppSorting {

  private static <T> void validate(List<T> input, List<T> sorted, Comparator<T> comparator) {
    assert sorted.size() == input.size();
    assert checkAscendingOrder(sorted, comparator);
    System.out.println(sorted);
  }

  public static void main(String[] args) {
    List input = new ArrayList<Integer>(1000);
    for (int i = 1000; i > 0; i--) input.add(i);

    List sorted = bubbleSort(input, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    sorted = combSort(input, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    sorted = insertSort(input, 1, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    sorted = shellSort(input, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    input = new ArrayList<Integer>(Arrays.asList(4, 23, 6, 78, 1, 54, 231, 9, 12));

    sorted = bubbleSort(input, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    sorted = combSort(input, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    sorted = insertSort(input, 1, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    sorted = shellSort(input, Integer::compareTo);
    validate(input, sorted, Integer::compareTo);

    input = new ArrayList<>(Arrays.asList("c", "a", "e", "b", "d"));

    sorted = bubbleSort(input, String::compareTo);
    validate(input, sorted, String::compareTo);

    sorted = combSort(input, String::compareTo);
    validate(input, sorted, String::compareTo);

    sorted = insertSort(input, 1, String::compareTo);
    validate(input, sorted, String::compareTo);

    sorted = shellSort(input, String::compareTo);
    validate(input, sorted, String::compareTo);
  }
}
