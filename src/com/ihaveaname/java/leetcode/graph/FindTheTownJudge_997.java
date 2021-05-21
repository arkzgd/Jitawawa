package com.ihaveaname.java.leetcode.graph;

public class FindTheTownJudge_997 {
  class Solution {
    public int findJudge(int n, int[][] trust) {
      int[][] degrees = new int[n + 1][2];
      for (int[] edge : trust) {
        degrees[edge[0]][0]++;
        degrees[edge[1]][1]++;
      }

      int judge = -1;
      for (int i = 1; i < degrees.length; i++) {
        if (degrees[i][1] == n - 1 && degrees[i][0] == 0) {
          judge = i;
        }
      }

      return judge;
    }
  }

  public static void main(String[] args) {
    FindTheTownJudge_997 findTheTownJudge_997 = new FindTheTownJudge_997();
    Solution solution = findTheTownJudge_997.new Solution();

    int n = 2;
    int[][] trust = new int[][] {{1, 2}};
    System.out.println(solution.findJudge(n, trust));

    n = 3;
    trust = new int[][] {{1, 3}, {2, 3}};
    System.out.println(solution.findJudge(n, trust));

    n = 3;
    trust = new int[][] {{1, 3}, {2, 3}, {3, 1}};
    System.out.println(solution.findJudge(n, trust));

    n = 3;
    trust = new int[][] {{1, 2}, {2, 3}};
    System.out.println(solution.findJudge(n, trust));

    n = 4;
    trust = new int[][] {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
    System.out.println(solution.findJudge(n, trust));
  }
}
