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
      int mid = low + ((high - low) >> 1); // shifting is the lowest priority
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
    int[][] houses = {{1, 2, 3}, {1, 2, 3, 4}, {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}};
    int[][] heaters = {{2}, {1, 4}, {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}};

    for (int i = 0; i < houses.length; i++) {
      test(houses[i], heaters[i]);
    }
  }
}
