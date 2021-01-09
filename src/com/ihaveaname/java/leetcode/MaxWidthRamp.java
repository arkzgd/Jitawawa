package com.ihaveaname.java.leetcode;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthRamp {
  // 为什么这个算法还是比较慢？
  //  1. 使用了数组，线性搜索最后一个比A[i]小的元素（当前最长的ramp）
  //  2. 对于每一个A[i]，搜索minSoFar的代价为O(n)
  // 如何继续优化？
  //  减少搜索minSoFar的时间复杂度：要么缩短minSoFar的长度；要么采取更聪明的搜索算法。
  //    注意：minSoFar是一个降序数组；而且每次的搜索也不需要 i - 1 开始
  //  试试用二分查找来处理minSoFar...
  public int maxWidthRamp(int[] A) {
    int answer = 0;

    int[] minSoFar = new int[A.length];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
        min = Math.min(min, A[i]);
        minSoFar[i] = min;
    }

    int j = minSoFar.length - 1;
    for (int i = A.length - 1; i > answer; i--) {
      int low = 0, high = j;
      while (low < high) {
        int mid = low + (high - low) / 2;
        if (A[i] >= minSoFar[mid]) high = mid;
        else low = mid + 1;
      }

      answer = Math.max(answer, i - high);
      j = high;
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
