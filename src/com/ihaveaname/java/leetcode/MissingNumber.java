package com.ihaveaname.java.leetcode;

public class MissingNumber {
  // n Numbers, each element is within range [0, n]; i.e., n + 1 possibilities fall into n buckets

  // This may overflow when calculating the sum of Arithmetic Sequence
  int missingNumber_arithmethic_seq(int[] nums) {
    int expectedSum = (0 + nums.length) * (nums.length + 1) / 2;
    int actualSum = 0;
    for (int e : nums) actualSum += e;

    return expectedSum - actualSum;
  }

  // Using Arithmetic Sequence sum as well, but subtracting while accumulating
  int missingNumber_arithemetic_seq_sub_while_accumulating(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
      result += (i - nums[i]);
    }

    return result;
  }

  // n ^ n = 0
  // n ^ 0 = n
  // Exchangeable and Combinable
  int missingNumber_xor(int[] nums) {
    int actualResult = nums.length;
    for (int i = 0; i < nums.length; i++) actualResult ^= (i ^ nums[i]);

    return actualResult;
  }

  public static void main(String[] args) {
    MissingNumber mn = new MissingNumber();

    int[] inputs = new int[] {3, 0, 1};
    System.out.println(mn.missingNumber_arithmethic_seq(inputs));
    System.out.println(mn.missingNumber_xor(inputs));
    System.out.println(mn.missingNumber_arithemetic_seq_sub_while_accumulating(inputs));

    inputs = new int[] {0, 1};
    System.out.println(mn.missingNumber_arithmethic_seq(inputs));
    System.out.println(mn.missingNumber_xor(inputs));
    System.out.println(mn.missingNumber_arithemetic_seq_sub_while_accumulating(inputs));

    inputs = new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(mn.missingNumber_arithmethic_seq(inputs));
    System.out.println(mn.missingNumber_xor(inputs));
    System.out.println(mn.missingNumber_arithemetic_seq_sub_while_accumulating(inputs));

    inputs = new int[] {0};
    System.out.println(mn.missingNumber_arithmethic_seq(inputs));
    System.out.println(mn.missingNumber_xor(inputs));
    System.out.println(mn.missingNumber_arithemetic_seq_sub_while_accumulating(inputs));
  }
}
