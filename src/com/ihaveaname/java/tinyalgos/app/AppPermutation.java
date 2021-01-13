package com.ihaveaname.java.tinyalgos.app;

import com.ihaveaname.java.tinyalgos.Permutation;

import java.util.ArrayList;
import java.util.List;

public class AppPermutation {
  public static void main(String[] args) {
    Permutation<Integer> permutation =
        new Permutation<>() {
          public List<List<Integer>> permutations(ArrayList<Integer> input) {
            List<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> clone = new ArrayList<>(input.size());
            for (int e : input) clone.add(e);
            result.add(clone);
            PermudationIndicator ind;
            do {
              ind = nextPermutation(input, Integer::compareTo);
              clone = new ArrayList<>(input.size());
              for (int e : input) clone.add(e);
              result.add(clone);
            } while (ind == PermudationIndicator.NotYetLastPermutation);

            return result;
          }
        };

    int numElements = 3;
    ArrayList<Integer> input = new ArrayList<>(numElements);
    for (int i = 1; i <= numElements; i++) input.add(i);

    System.out.println(permutation.permutations(input));
  }
}
