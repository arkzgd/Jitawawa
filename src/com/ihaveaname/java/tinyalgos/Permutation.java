package com.ihaveaname.java.tinyalgos;

import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.lang.reflect.Array;
import java.util.*;

public abstract class Permutation<T> {
  public enum PermudationIndicator {
    LastPermutation,
    NotYetLastPermutation
  }

  public PermudationIndicator nextPermutation(ArrayList<T> array, Comparator<T> comparator) {
    int length = array.size();
    int i;
    for (i = length - 2; i >= 0 && comparator.compare(array.get(i), array.get(i + 1)) > 0; i--)
      ;
    if (i == -1) return PermudationIndicator.LastPermutation;

    int j;
    for (j = length - 1; j > i && comparator.compare(array.get(j), array.get(i)) < 0; j--)
      ;

    Utils.swap(array, i, j);
    Utils.reverse(array, i + 1, length - 1);
    if (Utils.checkAscendingOrder(array, comparator.reversed()))
      return PermudationIndicator.LastPermutation;
    return PermudationIndicator.NotYetLastPermutation;
  }

  public abstract List<List<T>> permutations(ArrayList<T> input);
}
