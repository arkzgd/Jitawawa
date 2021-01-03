package com.ihaveaname.java.leetcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.ihaveaname.java.leetcode.Utils.readNumbersFromTxtFile;

public class MaxValueInTheWindow {

  public int[] findMax_heap(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    int resulti = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, ((o1, o2) -> o2 - o1));

    for (int i = 0; i < nums.length; i++) {
      int v = nums[i];
      pq.removeIf(o -> (o < v) ? true : false);
      pq.offer(v);
      if (i >= k && pq.peek() == nums[i - k]) pq.poll();
      if (i >= k - 1) result[resulti++] = pq.peek();
    }

    return result;
  }

  public int[] findMax_deque(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    int resulti = 0;

    Deque<Integer> queue = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.pollLast();
      queue.offerLast(nums[i]);
      if (i >= k && queue.peekFirst() == nums[i - k]) queue.pollFirst();
      if (i >= k - 1) result[resulti++] = queue.peekFirst();
    }

    return result;
  }

  public int[] findMax_dp(int[] nums, int k) {
    if (nums.length == 0 || nums.length < k || k == 0) {
      return new int[0];
    }

    int len = nums.length;
    int[] leftmax = new int[len];
    int[] rightmax = new int[len];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i = i + k) {
      int end = i + k - 1 < len ? i + k - 1 : len - 1;
      max = nums[i];
      leftmax[i] = max;
      for (int j = i + 1; j <= end; j++) {
        if (nums[j] > max) {
          max = nums[j];
        }
        leftmax[j] = max;
      }

      max = nums[end];
      rightmax[end] = max;
      for (int j = end - 1; j >= i; j--) {
        if (nums[j] > max) {
          max = nums[j];
        }
        rightmax[j] = max;
      }
    }

    int[] res = new int[len - k + 1];
    for (int start = 0; start < len - k + 1; start++) {
      int end = start + k - 1;
      res[start] = Math.max(rightmax[start], leftmax[end]);
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    MaxValueInTheWindow mvitm = new MaxValueInTheWindow();

    int[] input1 = {1, 3, -1, -3, 5, 3, 6, 7};
    System.out.println(Arrays.toString(mvitm.findMax_dp(input1, 3)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input1, 3)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input1, 3)));

    int[] input2 = {1};
    System.out.println(Arrays.toString(mvitm.findMax_dp(input2, 1)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input2, 1)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input2, 1)));

    int[] input3 = {1, -1};
    System.out.println(Arrays.toString(mvitm.findMax_dp(input3, 1)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input3, 1)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input3, 1)));

    int[] input4 = {9, 11};
    System.out.println(Arrays.toString(mvitm.findMax_dp(input4, 2)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input4, 2)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input4, 2)));

    int[] input5 = {4, -2};
    System.out.println(Arrays.toString(mvitm.findMax_dp(input5, 2)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input5, 2)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input5, 2)));

    int[] input6 = readNumbersFromTxtFile("src/com/ihaveaname/java/leetcode/numbers_1.txt");
    System.out.println(Arrays.toString(mvitm.findMax_dp(input6, 45)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input6, 45)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input6, 45)));

    int[] input7 = readNumbersFromTxtFile("src/com/ihaveaname/java/leetcode/numbers_2.txt");
    System.out.println(Arrays.toString(mvitm.findMax_dp(input7, 10007)));
    System.out.println(Arrays.toString(mvitm.findMax_deque(input7, 10007)));
    System.out.println(Arrays.toString(mvitm.findMax_heap(input7, 10007)));
  }
}
