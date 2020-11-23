package com.ihaveaname.java.playground;

import java.util.ArrayList;
import java.util.List;

public class PlaySearchMinElementInShiftedArray {

  private static ArrayList<Integer> shiftArray(List<Integer> array, int shift) {
    if (shift % array.size() == 0) return new ArrayList<>(array);

    List firstPortion = array.subList(0, shift % array.size());
    List secondPortion = array.subList(shift % array.size(), array.size());
    ArrayList result = new ArrayList();
    result.addAll(secondPortion);
    result.addAll(firstPortion);

    return result;
  }

  private static boolean isShifted(ArrayList<Integer> array) {
    return array.size() > 0 && array.get(0) > array.get(array.size() - 1);
  }

  private static Integer findMin(ArrayList<Integer> array) {
    if (!isShifted(array))
      if (array.size() > 0) {
        return array.get(0);
      } else {
        return null;
      }

    int low = 0;
    int high = array.size() - 1;

    while (low < high) {
      int mid = low + (high - low >> 1);
      if (array.get(mid) > array.get(low)) low = mid;
      else
        high = mid;
    }

    return array.get(low + 1);
  }

  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>(100);
    for (int i = 1; i <= 5; i++) {
      al.add(i);
    }

    for (int i = 0; i < 5; i++) {
      ArrayList<Integer> shifted = shiftArray(al, i);
      System.out.println(shifted);
      Integer min = findMin(shiftArray(shifted, i));
      assert (min == 1);
      System.out.println(min);
    }
  }
}
