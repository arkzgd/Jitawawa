package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class LongestNonRepeatString {
  public static int solution(String input) {
    int length = input.length();
    int[] location = new int[128];
    Arrays.fill(location, -1);
    int result = 0;

    int left = 0;
    int right = 0;

    for (; right < length; right++) {
      int loc = input.charAt(right) - 'a';
      if (location[loc] == -1) {
        location[loc] = right;
        result = Math.max(result, right - left + 1);
      } else {
        left = Math.max(left, location[loc]) + 1;
        location[loc] = right;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    String[] ss = {"abcabcbb", "bbbbb", "pwwkew"};

    for (int i = 0; i < ss.length; i++) {
      System.out.println(ss[i] + " -> " + solution(ss[i]));
    }
  }
}
