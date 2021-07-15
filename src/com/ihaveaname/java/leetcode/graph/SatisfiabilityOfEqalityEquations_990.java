package com.ihaveaname.java.leetcode.graph;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SatisfiabilityOfEqalityEquations_990 {
  class Solution {
    public boolean equationsPossible(String[] equations) {
      int[] parent = new int[26];
      for (int i = 0; i < 26; i++) {
        parent[i] = i;
      }
      int[] ranks = new int[26];
      Arrays.fill(ranks, 1);

      List<String> nonEquations = new ArrayList<>();

      for (String equation : equations) {
        if (equation.contains("==")) {
          findAndUnion(parent, ranks, equation);
        } else {
          nonEquations.add(equation);
        }
      }

      return validateNonEquations(parent, nonEquations);
    }

    private void findAndUnion(int[] parent, int[] ranks, String equation) {
      char left_operand = equation.charAt(0);
      char right_operand = equation.charAt(3);
      union(parent, ranks, left_operand, right_operand);
    }

    private int findParent(int[] parent, char oprand) {
      int i = oprand - 'a';
      if (parent[i] != i) {
        parent[i] = findParent(parent, (char) ('a' + parent[i]));
      }

      return parent[i];
    }

    private void union(int[] parent, int[] ranks, char left_operand, char right_operand) {
      int lp = findParent(parent, left_operand);
      int rp = findParent(parent, right_operand);

      if (lp != rp) {
        if (ranks[lp] > ranks[rp]) {
          parent[rp] = lp;
          ranks[lp] += ranks[rp];
        } else {
          parent[lp] = rp;
          ranks[rp] += ranks[lp];
        }
      }
    }

    private boolean validateNonEquations(int[] parent, List<String> nonEquations) {
      for (String nonEquation : nonEquations) {
        int lp = findParent(parent, nonEquation.charAt(0));
        int rp = findParent(parent, nonEquation.charAt(3));
        if (lp == rp) return false;
      }

      return true;
    }
  }

  public static void main(String[] args) {
    SatisfiabilityOfEqalityEquations_990 satisfiabilityOfEqalityEquations_990 =
        new SatisfiabilityOfEqalityEquations_990();
    Solution solution = satisfiabilityOfEqalityEquations_990.new Solution();

    String[] input = new String[] {"a==b", "b!=a"};
    System.out.println(solution.equationsPossible(input));

    input = new String[] {"b==a", "a==b"};
    System.out.println(solution.equationsPossible(input));

    input = new String[] {"a==b", "b==c", "a==c"};
    System.out.println(solution.equationsPossible(input));

    input = new String[] {"a==b", "b!=c", "c==a"};
    System.out.println(solution.equationsPossible(input));

    input = new String[] {"c==c", "b==d", "x!=z"};
    System.out.println(solution.equationsPossible(input));
  }
}
