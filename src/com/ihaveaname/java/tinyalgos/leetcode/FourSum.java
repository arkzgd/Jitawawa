package com.ihaveaname.java.tinyalgos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ihaveaname.java.tinyalgos.leetcode.Utils.sort;

public class FourSum {
  public static List<List<Integer>> solution(Integer[] input, Integer target) {
    List<List<Integer>> result = new ArrayList<>();
    int length = input.length;
    int fixed = 0;

    while (fixed <= length - 3 && input[fixed] < target) {
      Integer targetOfThree = target - input[fixed];
      List<List<Integer>> resultsOfThree = ThreeSum.solution(Arrays.copyOfRange(input, fixed + 1, length - 1), targetOfThree);
      if (resultsOfThree.size() > 0) {
        for (int l = 0; l < resultsOfThree.size(); l++) {
          List<Integer> ll = resultsOfThree.get(l);
          List<Integer> nl = new ArrayList<>(1);
          nl.add(input[fixed]);
          nl.addAll(ll);
          result.add(nl);
        }
      }

      while (fixed < length - 3 && input[fixed] == input[fixed + 1]) fixed++;
      fixed++;
    }

    return result;
  }

  public static void main(String[] args) {
    Integer[] array = {-1, 0, 1, 2, -1, -4, -9, 9, 8, -2, 3, 6};

    for (int i = 4; i > -5; i--) {
      System.out.println(i + "-> " + solution(sort(array), i));
    }
  }
}
