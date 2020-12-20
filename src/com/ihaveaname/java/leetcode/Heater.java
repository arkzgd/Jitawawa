package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class Heater {

  public static int solutionHeater(int[] houses, int[] heaters) {
    Arrays.sort(heaters);

    int minRadius = -1;
    for (int h : houses) {
      int closestHeater = findClosestHeater(h, heaters);
      minRadius = Math.max(closestHeater, minRadius);
    }
    return minRadius;
  }

  private static int findClosestHeater(int house, int[] heaters) {
    if (heaters.length == 0) return -1;

    int result = -1;
    if (house <= heaters[0]) return Math.abs(house - heaters[0]);
    if (house >= heaters[heaters.length - 1]) return Math.abs(house - heaters[heaters.length - 1]);

    int low = 0;
    int high = heaters.length - 1;
    while (low <= high) {
      int mid = low + (high - low) >> 1;
      if (heaters[mid] <= house && heaters[mid + 1] >= house) {
        result = Math.min(Math.abs(heaters[mid] - house), Math.abs(heaters[mid + 1] - house));
        break;
      } else {
        if (heaters[mid + 1] < house) {
          low = mid + 1;
        } else {
          high = mid;
        }
      }
    }

    return result;
  }

  private static void test(int[] houses, int[] heaters) {
    int radius = solutionHeater(houses, heaters);
    System.out.println("min radius = " + radius);
  }

  public static void main(String[] args) {
    int[] houses = {1, 5};
    int[] heaters = {2};
    test(houses, heaters);
  }
}
