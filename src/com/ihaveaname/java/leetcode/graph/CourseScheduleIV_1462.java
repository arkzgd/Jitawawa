package com.ihaveaname.java.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleIV_1462 {
  class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
      List<Boolean> result = new ArrayList<>();
      var graph = toGraph(numCourses, prerequisites);
      for (int i = 0; i < queries.length; i++) {
        result.add(prerequisite(queries[i], graph));
      }

      return result;
    }

    private ArrayList<Set<Integer>> toGraph(int numCourses, int[][] prerequisites) {
      ArrayList<Set<Integer>> result = new ArrayList<>(numCourses);
      for (int i = 0; i < numCourses; i++) result.add(new HashSet<>());
      for (int[] prerequisite : prerequisites) {
        int a = prerequisite[0];
        int b = prerequisite[1];
        result.get(b).add(a);
      }

      return result;
    }

    private boolean prerequisite(int[] query, ArrayList<Set<Integer>> graph) {
      if (graph.get(query[1]).contains(query[0])) return true;
      for (int p : graph.get(query[1])) {
        if (prerequisite(new int[] {query[0], p}, graph)) return true;
      }

      return false;
    }
  }

  public static void main(String[] args) {
    CourseScheduleIV_1462 courseScheduleIV_1462 = new CourseScheduleIV_1462();
    Solution solution = courseScheduleIV_1462.new Solution();

    int numCourses = 2;
    int[][] prerequisites = new int[][] {{1, 0}};
    int[][] queries = new int[][] {{0, 1}, {1, 0}};
    System.out.println(solution.checkIfPrerequisite(numCourses, prerequisites, queries));

    numCourses = 2;
    prerequisites = new int[][] {};
    queries = new int[][] {{0, 1}, {1, 0}};
    System.out.println(solution.checkIfPrerequisite(numCourses, prerequisites, queries));
  }
}
