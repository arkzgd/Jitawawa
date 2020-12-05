package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

  public static List<Integer> solution(Integer[] input, Integer target) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>(2);

    for (int i = 0; i < input.length; i++) {
      if (map.containsKey(target - input[i])) {
        result.add(map.get(target - input[i]));
        result.add(i);
        break;
      }
      else
        map.put(input[i], i);
    }

    return result;
  }

  public static void main(String[] args) {
    Integer[] input = {2, 7, 11, 15};
    System.out.println(solution(input, 9));
    System.out.println(solution(input, 18));
    System.out.println(solution(input, 19));
  }
}
