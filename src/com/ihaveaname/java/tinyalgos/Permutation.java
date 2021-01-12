package com.ihaveaname.java.tinyalgos;

import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.util.*;

enum PermudationIndicator {
  LastPermutation,
  NotYetLastPermutation
}

public class Permutation<T> {
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

  public void nextPermutation(int[] nums) {
    // Leetcode solution, Leetcode tests including duplicated numbers, like [1, 5, 1]
    int length = nums.length;

    int i;
    for (i = length - 2; i >= 0 && nums[i] >= nums[i + 1]; i--);
    if (i == -1) {
      Arrays.sort(nums);
      return;
    }

    int j;
    for (j = length - 1; j > i && nums[j] <= nums[i]; j--);

    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;

    Arrays.sort(nums, i + 1, length);
  }

  public List<List<T>> permutations(ArrayList<T> input, Comparator<T> comparator) {
    List<List<T>> result = new ArrayList<>();

    // TODO: Stupid, you need deep copy and T shall be subclass of clonable
    do {
      result.add(input);
    } while (nextPermutation(input, comparator) == PermudationIndicator.NotYetLastPermutation);

    return result;
  }
}
