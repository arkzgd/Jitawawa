package com.ihaveaname.java.leetcode.graph;

import java.util.List;

public class CourseScheduleIV_1462 {
  class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
      return null;
    }
  }

  public static void main(String[] args) {
    CourseScheduleIV_1462 courseScheduleIV_1462 = new CourseScheduleIV_1462();
    Solution solution = courseScheduleIV_1462.new Solution();

    int numCourses = 2;
    int[][] prerequisites = new int[][] {{1, 0}};
    int[][] queries = new int[][] {{0, 1}, {1, 0}};
    System.out.println(solution.checkIfPrerequisite(numCourses, prerequisites, queries));
  }
}
