package com.ihaveaname.java.playground;

public class PlayKekeEatsBanana {
  private static int eat(int[] piles, int hours) {
    int low = 1;
    int high = maxPile(piles);

    while (low < high) {
      int mid = low + ((high - low) >> 1);
      if (canEatup(piles, mid, hours)) low = mid + 1;
      else high = mid;
    }

    return low;
  }

  private static int maxPile(int[] piles) {
    int max = piles[0];

    for (int p : piles) {
      if (p > max) max = p;
    }

    return max;
  }

  private static boolean canEatup(int[] piles, int speed, int hours) {
    int sum = 0;

    for (int p : piles) sum += Math.ceil(p * 1.0f / speed);

    return sum > hours;
  }

  public static void main(String[] args) {
    int[] piles = new int[] {30, 11, 23, 4, 20};
    System.out.println("Result: " + eat(piles, 5));
  }
}
