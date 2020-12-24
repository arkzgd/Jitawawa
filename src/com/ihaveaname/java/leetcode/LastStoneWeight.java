package com.ihaveaname.java.leetcode;

import java.util.Arrays;

public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    Arrays.sort(stones);
    int length = getLength(stones);

    while (length > 2) {
      int r = stones[stones.length - 1] - stones[stones.length - 2];
      stones[stones.length - 2] = 0;
      stones[stones.length - 1] = r;
      Arrays.sort(stones);
      length = getLength(stones);
    }

    if (length == 1) return stones[stones.length - 1];
    else return stones[stones.length - 1] - stones[stones.length - 2];
  }

  private int getLength(int[] stones) {
    int count = 0;
    for (int i : stones) if (i > 0) count++;
    return count;
  }

  public static void main(String[] args) {
    LastStoneWeight lsw = new LastStoneWeight();
    int[] stones = {2, 7, 4, 1, 8, 1};
    System.out.println(lsw.lastStoneWeight(stones));
  }
}
