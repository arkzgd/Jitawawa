package com.ihaveaname.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatString {
  public static int solution_best(String input) {
    int[] location = new int[256];
    int result = 0;

    for (int left = 0, right = 0; right < input.length(); right++) {
      left = Math.max(left, location[input.charAt(right)]);
      result = Math.max(result, right - left + 1);
      location[input.charAt(right)] = right + 1;
    }

    return result;
  }

  public static int solution_classic(String input) {
    int result = 0;

    for (int left = 0, right = 0; right < input.length(); right++) {
      for (int k = left; k < right; k++) {
        if (input.charAt(k) == input.charAt(right)) {
          left = k + 1;
          break;
        }
      }
      result = Math.max(result, right - left + 1);
    }

    return result;
  }

  public static int solution_smarter(String input) {
    int result = 0;
    Map<Character, Integer> occurrence = new HashMap<>();

    for (int left = 0, right = 0; right < input.length(); right++) {
      if (occurrence.containsKey(input.charAt(right))) {
        left = Math.max(left, occurrence.get(input.charAt(right)));
      }

      occurrence.put(input.charAt(right), right + 1);
      result = Math.max(result, right - left + 1);
    }

    return result;
  }

  public static void main(String[] args) {
    String[] ss = {"abcabcbb", "bbbbb", "pwwkew", "tmmzuxt"};

    for (int i = 0; i < ss.length; i++) {
      System.out.println(ss[i] + " -> " + solution_best(ss[i]));
    }

    for (int i = 0; i < ss.length; i++) {
      System.out.println(ss[i] + " -> " + solution_classic(ss[i]));
    }

    for (int i = 0; i < ss.length; i++) {
      System.out.println(ss[i] + " -> " + solution_smarter(ss[i]));
    }
  }
}
