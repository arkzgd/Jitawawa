package com.ihaveaname.java.leetcode.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortIntegersByThePowerOfValue_1387 {
  class Solution {
    private static int[] dp;

    static {
      dp = new int[(int) 1e6];
      Arrays.fill(dp, -1);
    }

    private int power(int v) {
      int result = 0;
      if (dp[v] != -1) result = dp[v];
      else {
        int p = 0;
        if (v > 1) {
          if (v % 2 == 0) p = power(v / 2) + 1;
          else p = power(3 * v + 1) + 1;
          dp[v] = p;
          result = p;
        } else {
          dp[1] = 0;
        }
      }

      return result;
    }

    public int getKth(int lo, int hi, int k) {
      Integer[] array = new Integer[hi - lo + 1];
      for (int i = lo; i <= hi; i++) array[i - lo] = i;
      Arrays.parallelSort(
          array,
          new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              int o1p = power(o1);
              int o2p = power(o2);
              if (o1p > o2p) return 1;
              else if (o1p == o2p) return o1 - o2;
              else return -1;
            }
          });

      return array[k - 1];
    }
  }

  public static void main(String[] args) {
    SortIntegersByThePowerOfValue_1387 sortIntegersByThePowerOfValue_1387 =
        new SortIntegersByThePowerOfValue_1387();
    Solution solution = sortIntegersByThePowerOfValue_1387.new Solution();

    int lo = 12, hi = 15, k = 2;
    System.out.println(solution.getKth(lo, hi, k));

    lo = 1;
    hi = 1;
    k = 1;
    System.out.println(solution.getKth(lo, hi, k));

    lo = 7;
    hi = 11;
    k = 4;
    System.out.println(solution.getKth(lo, hi, k));

    lo = 10;
    hi = 20;
    k = 5;
    System.out.println(solution.getKth(lo, hi, k));

    lo = 1;
    hi = 1000;
    k = 777;
    System.out.println(solution.getKth(lo, hi, k));
  }
}
