package com.ihaveaname.java.leetcode;

import java.io.IOException;

public class MaxWidthRamp {
  public int maxWidthRamp(int[] A) {
    int answer = 0;

    int[] minSoFar = new int[A.length];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      min = Math.min(A[i], min);
      minSoFar[i] = min;
    }

    for (int i = A.length - 1; i > answer; i--) {
      int j = i - 1;
      while (j >= 0 && A[i] >= minSoFar[j]) j--;
      answer = Math.max(answer, i - j - 1);
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    MaxWidthRamp mwr = new MaxWidthRamp();

    int[] input = new int[] {6, 0, 8, 2, 1, 5};
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 4;

    input = new int[] {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 7;

    input = new int[] {0, 1};
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 1;

    input = new int[] {2, 4, 1, 3};
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 3;

    input = new int[] {9, 9, 3, 5, 4, 0, 2, 0, 4, 1};
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 6;

    input =
        new int[] {
          29, 28, 28, 26, 25, 24, 9, 23, 21, 9, 18, 17, 14, 12, 3, 11, 10, 8, 8, 10, 22, 6, 5, 20,
          5, 2, 1, 1, 1, 0
        };
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 17;

    input = Utils.readNumbersFromTxtFile("src/com/ihaveaname/java/leetcode/numbers_4.txt");
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 262;

    input = new int[] {1, 2, 1};
    System.out.println(mwr.maxWidthRamp(input));
    assert mwr.maxWidthRamp(input) == 2;
  }
}
