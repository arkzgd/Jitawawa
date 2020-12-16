package com.ihaveaname.java.leetcode;

public class KekeEatsBanana {
  private static int eat(int[] piles, int hours) {
    int low = 1;
    int high = maxPile(piles);

    while (low < high) {
      int mid = low + ((high - low) >> 1);
      if (canEatup(piles, mid, hours)) high = mid;
      else {
        // the key is to have low = mid + 1, otherwise, it will be loop forever because
        // mid will always be low if high = low + 1
        low = mid + 1;
      }
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

    return sum <= hours;
  }

  public static void main(String[] args) {
    int[] piles = new int[] {30, 11, 23, 4, 20};
    System.out.println("Result: " + eat(piles, 5));
    System.out.println("Result: " + eat(piles, 6));
    System.out.println("Result: " + eat(piles, 7));
    System.out.println("Result: " + eat(piles, 4)); // This actually has no satisfying answer
  }
}
