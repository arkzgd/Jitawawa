package com.ihaveaname.java.tinyalgos.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utils {
  public static <T> boolean swap(T[] array, int i, int j) {
    boolean sanity = 0 <= i && i < array.length && 0 <= j && j < array.length;
    if (i != j && sanity) {
      T v = array[i];
      array[i] = array[j];
      array[j] = v;
      return true;
    } else return false;
  }

  public static <T> boolean swap(ArrayList<T> list, int i, int j) {
    boolean sanity = 0 <= i && i < list.size() && 0 <= j && j < list.size();
    if (i != j && sanity) {
      T v = list.get(i);
      list.set(i, list.get(j));
      list.set(j, v);
      return true;
    } else return false;
  }

  public static <T> boolean checkAscendingOrder(List<T> input, Comparator<T> comparator) {
    for (int i = 0; i < input.size() - 1; i++) {
      if (comparator.compare(input.get(i), input.get(i + 1)) > 0) return false;
    }

    return true;
  }

  public static int nextGap(int gap) {
    int n = gap * 10 / 13;
    if (n < 1) return 1;
    else return n;
  }
}
