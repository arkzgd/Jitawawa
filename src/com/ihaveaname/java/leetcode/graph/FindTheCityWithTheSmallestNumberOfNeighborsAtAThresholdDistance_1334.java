package com.ihaveaname.java.leetcode.graph;

import java.util.*;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334 {
  class Solution {
    private int ans;
    private int shortest;

    private class Vertex {
      List<Integer[]> adj = new ArrayList<>();
      boolean known;
      int dist;
      Vertex path;
    }

    private ArrayList<Vertex> toGraph(int n, int[][] edges) {
      ArrayList<Vertex> result = new ArrayList<>();
      for (int i = 0; i < n; i++) result.add(new Vertex());

      for (int[] e : edges) {
        result.get(e[0]).adj.add(new Integer[] {e[1], e[2]});
        result.get(e[1]).adj.add(new Integer[] {e[0], e[2]});
      }

      return result;
    }

    private void dijkstra(Vertex s, ArrayList<Vertex> graph) {
      for (Vertex v : graph) {
        v.dist = Integer.MAX_VALUE;
        v.known = false;
        v.path = null;
      }

      PriorityQueue<Vertex> queue =
          new PriorityQueue<>(
              new Comparator<Vertex>() {
                @Override
                public int compare(Vertex o1, Vertex o2) {
                  return o1.dist - o2.dist;
                }
              });
      s.dist = 0;
      queue.offer(s);

      while (!queue.isEmpty()) {
        Vertex v = queue.poll();
        v.known = true;
        for (Integer[] neighbor : v.adj) {
          Vertex w = graph.get(neighbor[0]);
          if (!w.known) {
            if (v.dist + neighbor[1] < w.dist) {
              w.dist = v.dist + neighbor[1];
              w.path = v;
              queue.offer(w);
            }
          }
        }
      }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      ArrayList<Vertex> graph = toGraph(n, edges);
      ans = -1;
      shortest = Integer.MAX_VALUE;

      for (int i = 0; i < n; i++) {
        dijkstra(graph.get(i), graph);
        int count = 0;
        for (int j = 0; j < n; j++) {
          if (graph.get(j).dist > 0 && graph.get(j).dist <= distanceThreshold) count++;
        }
        if (count <= shortest) {
          shortest = count;
          ans = i;
        }
      }

      return ans;
    }
  }

  public static void main(String[] args) {
    FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334
        findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334 =
            new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334();
    Solution solution =
        findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance_1334.new Solution();

    int n = 4;
    int[][] edges = new int[][] {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
    int distanceThreshold = 4;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));

    n = 5;
    edges = new int[][] {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
    distanceThreshold = 2;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));

    n = 6;
    edges = new int[][] {{0, 1, 10}, {0, 2, 1}, {2, 3, 1}, {1, 3, 1}, {1, 4, 1}, {4, 5, 10}};
    distanceThreshold = 20;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));

    n = 6;
    edges = new int[][] {{0, 3, 7}, {2, 4, 1}, {0, 1, 5}, {2, 3, 10}, {1, 3, 6}, {1, 2, 1}};
    distanceThreshold = 417;
    System.out.println(solution.findTheCity(n, edges, distanceThreshold));
  }
}
