package com.ihaveaname.java.tinyalgos.leetcode;

import java.util.*;

public class ThreeSum {
  public static List<List<Integer>> solution(Integer[] input, Integer target) {
    Map<Integer, List<Integer>> map = arrayToMap(input);
    List<Integer> keySet = new ArrayList(map.keySet());
    int keySetLength = keySet.size();
    List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> keys = new ArrayList<>();
    for (int i = 0; i < keySetLength; i++) {
      for (int j = 0; j < keySetLength; j++) {
        for (int k = 0; k < keySetLength; k++) {
          if (keySet.get(i) + keySet.get(j) + keySet.get(k) == target) {
            List<Integer> list = new ArrayList<>(3);
            list.add(keySet.get(i));
            list.add(keySet.get(j));
            list.add(keySet.get(k));
            keys.add(list);
          }
        }
      }
    }

    Set<List<Integer>> s = new HashSet<>();
    for (int k = 0; k < keys.size(); k++) {
      List<Integer> key = keys.get(k);
      Integer a = key.get(0);
      List<Integer> al = map.get(a);
      int all = al.size();
      Integer b = key.get(1);
      List<Integer> bl = map.get(b);
      int bll = bl.size();
      Integer c = key.get(2);
      List<Integer> cl = map.get(c);
      int cll = cl.size();

      for (int ai = 0; ai < all; ai++)
        for (int bi = 0; bi < bll; bi++)
          for (int ci = 0; ci < cll; ci++) {
            Set<Integer> l = new HashSet<>();
            l.add(al.get(ai));
            l.add(bl.get(bi));
            l.add(cl.get(ci));

            if (l.size() == 3) s.add(new ArrayList<>(l));
          }
    }

    result.addAll(s);
    return result;
  }

  private static Map<Integer, List<Integer>> arrayToMap(Integer[] input) {
    Map<Integer, List<Integer>> result = new HashMap<>();
    int length = input.length;

    for (int i = 0; i < length; i++) {
      if (result.containsKey(input[i])) result.get(input[i]).add(i);
      else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        result.put(input[i], list);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Integer[] array = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = solution(array, 0);

    for (int i = 0; i < result.size(); i++) {
      System.out.println(array[result.get(i).get(0)] + " " + array[result.get(i).get(1)] + " " + array[result.get(i).get(2)]);
    }
  }
}
