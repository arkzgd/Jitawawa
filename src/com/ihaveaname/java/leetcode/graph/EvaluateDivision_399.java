package com.ihaveaname.java.leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision_399 {
  class Solution {
    private Map<String, Map<String, Double>> toGraph(
        List<List<String>> equations, double[] values) {
      int length = equations.size();
      Map<String, Map<String, Double>> result = new HashMap<>();
      for (int i = 0; i < length; i++) {
        List<String> pair = equations.get(i);
        double v = values[i];
        if (!result.containsKey(pair.get(0))) {
          Map<String, Double> map = new HashMap<String, Double>();
          result.put(pair.get(0), map);
        }
        result.get(pair.get(0)).put(pair.get(1), v);

        if (!result.containsKey(pair.get(1))) {
          Map<String, Double> map = new HashMap<String, Double>();
          result.put(pair.get(1), map);
        }
        result.get(pair.get(1)).put(pair.get(0), 1 / v);
      }

      return result;
    }

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
      var graph = toGraph(equations, values);
      return null;
    }
  }

  public static void main(String[] args) {
    EvaluateDivision_399 evaluateDivision_399 = new EvaluateDivision_399();
    Solution solution = evaluateDivision_399.new Solution();

    List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
    double[] values = new double[] {2.0, 3.0};
    List<List<String>> queries =
        List.of(
            List.of("a", "c"),
            List.of("b", "a"),
            List.of("a", "e"),
            List.of("a", "a"),
            List.of("x", "x"));
    System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
  }
}
