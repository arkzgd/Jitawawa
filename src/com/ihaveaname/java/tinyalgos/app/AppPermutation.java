package com.ihaveaname.java.tinyalgos.app;

import com.ihaveaname.java.tinyalgos.Permutation;

import java.util.ArrayList;

public class AppPermutation {
  public static void main(String[] args) {
    Permutation<Integer> permutation = new Permutation<>();
    ArrayList<Integer> input = new ArrayList<>();
    int numElements = 4;
    for (int i = 1; i <= numElements; i++) input.add(i);
    System.out.println(permutation.permutations(input, Integer::compareTo));
  }
}
