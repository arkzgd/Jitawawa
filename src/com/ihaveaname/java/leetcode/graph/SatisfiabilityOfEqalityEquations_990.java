package com.ihaveaname.java.leetcode.graph;

public class SatisfiabilityOfEqalityEquations_990 {
  class Solution {
    public boolean equationsPossible(String[] equations) {
      return false;
    }
  }

  public static void main(String[] args) {
    SatisfiabilityOfEqalityEquations_990 satisfiabilityOfEqalityEquations_990 =
        new SatisfiabilityOfEqalityEquations_990();
    Solution solution = satisfiabilityOfEqalityEquations_990.new Solution();

    String[] input = new String[] {"a==b", "b!=a"};
    System.out.println(solution.equationsPossible(input));
  }
}
