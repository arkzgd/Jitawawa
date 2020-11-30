package com.ihaveaname.java.tinyalgos.leetcode;

import java.util.*;

public class ThreeSum {
  public static List<List<Integer>> solution(Integer[] input, Integer target) {
    Map<Integer, List<List<Integer>>> sumMap = partialSumMap(input);
    List<List<Integer>> result = new ArrayList<>();

    int length = input.length;
    for (int i = 0; i < length; i++) {
      int t = target - input[i];
      if (sumMap.containsKey(t)) {
        List<List<Integer>> l = sumMap.get(t);
        for (int k = 0; k < l.size(); k++) {
          if (!l.get(k).contains(input[i])) {
            List<Integer> ll = new ArrayList<>(3);
            ll.add(input[i]);
            ll.addAll(l.get(k));
            result.add(ll);
          }
        }
      }
    }

    return result;
  }

  private static Map<Integer, List<List<Integer>>> partialSumMap(Integer[] input) {
    Map<Integer, List<List<Integer>>> result = new HashMap<>();
    int length = input.length;

    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        Integer k = input[i] + input[j];
        List<Integer> l = new ArrayList<>(2);
        l.add(input[i]);
        l.add(input[j]);
        if (result.containsKey(k)) {
          List el = result.get(k);
          el.add(l);
          result.put(k, el);
        } else {
          List<List<Integer>> el = new ArrayList<>();
          el.add(l);
          result.put(k, el);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Integer[] array = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> result = solution(array, 0);
    System.out.println(result);

    result = solution(array, -1);
    System.out.println(result);
  }
}
