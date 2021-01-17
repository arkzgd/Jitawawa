package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingTheLeaderboard {
  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    ArrayList<Integer> ranks = new ArrayList<>();
    ranks.addAll(ranked);

    int slow = 0;
    int fast;
    for (fast = 0; fast < ranks.size(); fast++) {
      if (ranks.get(fast) != ranks.get(slow)) ranks.set(++slow, ranks.get(fast));
    }
    for (int i = 0; i <= slow; i++) System.out.print(" " + ranks.get(i));
    System.out.println();

    List<Integer> result = new ArrayList<>();
    for (Integer p : player) {
      int low = 0;
      int high = slow + 1;
      while (low < high) {
        int mid = low + (high - low) / 2;
        if (ranks.get(mid) < p) high = mid;
        else low = mid + 1;
      }
      System.out.println("p = " + p + " low = " + low + " high = " + high + " slow = " + slow);
      if (low > slow) result.add(slow + 2); // p is the smallest element. Rank = index + 1
      else {
        if (low == 0) result.add(1); // p is the largest. Rank = 1
        else {
          if (ranks.get(low - 1) == p) result.add(low);
          else result.add(low + 1);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
    List<Integer> player = Arrays.asList(5, 25, 50, 120);
    System.out.println(climbingLeaderboard(ranked, player));

    ranked = Arrays.asList(100, 90, 90, 80, 75, 60);
    player = Arrays.asList(50, 65, 77, 90, 102);
    System.out.println(climbingLeaderboard(ranked, player));
  }
}
