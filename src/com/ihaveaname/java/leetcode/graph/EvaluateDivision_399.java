package com.ihaveaname.java.leetcode.graph;

import java.util.*;

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
          Map<String, Double> map = new HashMap<>();
          result.put(pair.get(1), map);
        }
        result.get(pair.get(1)).put(pair.get(0), 1 / v);
      }

      return result;
    }

    private Set<String> visited;

    private double dfs(String source, String target, Map<String, Map<String, Double>> graph) {
      if (graph.containsKey(source)) {
        visited.add(source);
        for (Map.Entry<String, Double> entry : graph.get(source).entrySet()) {
          if (entry.getKey().equals(target)) return entry.getValue();
          else {
            if (!visited.contains(entry.getKey())) {
              double maybeTarget = dfs(entry.getKey(), target, graph);
              if (maybeTarget == -1) {
                return -1;
              } else {
                return entry.getValue() * maybeTarget;
              }
            }
          }
        }
      }
      return -1;
    }

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
      double[] result = new double[queries.size()];
      Map<String, Map<String, Double>> graph = toGraph(equations, values);
      int count = 0;
      for (List<String> query : queries) {
        visited = new HashSet<>();
        result[count++] = dfs(query.get(0), query.get(1), graph);
      }

      return result;
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

    equations = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
    values = new double[] {1.5, 2.5, 5.0};
    queries =
        List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc"));
    System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));

    equations = List.of(List.of("a", "b"));
    values = new double[] {0.5};
    queries = List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y"));
    System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
  }
}
