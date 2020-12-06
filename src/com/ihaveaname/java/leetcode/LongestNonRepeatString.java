package com.ihaveaname.java.leetcode;

public class LongestNonRepeatString {
  public static int solution(String input) {
    int length = input.length();
    int[] location = new int[256];
    int result = 0;

    int left = 0;
    int right = 0;

    for (; right < length; right++) {
      int loc = input.charAt(right);
      left = Math.max(left, location[loc]);
      result = Math.max(result, right - left + 1);
      location[loc] = right + 1;
    }

    return result;
  }

  public static void main(String[] args) {
    String[] ss = {"abcabcbb", "bbbbb", "pwwkew", "tmmzuxt"};

    for (int i = 0; i < ss.length; i++) {
      System.out.println(ss[i] + " -> " + solution(ss[i]));
    }
  }
}
