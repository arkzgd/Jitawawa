package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {
  class Solution {
    private List<List<Integer>> result;

    private void helper(int[][] graph, int current, int target, LinkedList<Integer> soFar) {
      if (current != target) {
        soFar.add(current);
        for (int i : graph[current]) {
          helper(graph, i, target, soFar);
        }
        soFar.removeLast();
      } else {
        soFar.add(current);
        result.add(new ArrayList<>(soFar));
        soFar.removeLast();
      }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      result = new ArrayList<>();
      helper(graph, 0, graph.length - 1, new LinkedList<>());
      return result;
    }
  }

  public static void main(String[] args) {
    AllPathsFromSourceToTarget_797 allPathsFromSourceToTarget_797 =
        new AllPathsFromSourceToTarget_797();
    Solution solution = allPathsFromSourceToTarget_797.new Solution();

    int[][] graph = new int[][] {{1, 2}, {3}, {3}, {}};
    System.out.println(solution.allPathsSourceTarget(graph));

    graph = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
    System.out.println(solution.allPathsSourceTarget(graph));

    graph = new int[][] {{1}, {}};
    System.out.println(solution.allPathsSourceTarget(graph));

    graph = new int[][] {{1, 2, 3}, {2}, {3}, {}};
    System.out.println(solution.allPathsSourceTarget(graph));

    graph = new int[][] {{1, 3}, {2}, {3}, {}};
    System.out.println(solution.allPathsSourceTarget(graph));
  }
}
