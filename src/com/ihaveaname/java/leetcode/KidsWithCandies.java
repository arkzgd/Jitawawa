package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>(candies.length);
    int mostCandy = 0;
    for (int candy : candies) {
      if (candy > mostCandy) mostCandy = candy;
    }

    for (int i = 0; i < candies.length; i++) {
      result.add(mostCandy - candies[i] <= extraCandies);
    }

    return result;
  }

  public static void main(String[] args) {
    KidsWithCandies kwc = new KidsWithCandies();

    int[] inputs = new int[]{2,3,5,1,3};
    System.out.println(kwc.kidsWithCandies(inputs, 3));

    inputs = new int[]{4, 2, 1, 1, 2};
    System.out.println(kwc.kidsWithCandies(inputs, 1));

    inputs = new int[]{12, 1, 12};
    System.out.println(kwc.kidsWithCandies(inputs, 10));
  }
}
