package com.ihaveaname.java.leetcode;

public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(new java.util.Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for (int s: stones) pq.offer(s);
    while (pq.size() >= 2) {
      int first = pq.remove();
      int second = pq.remove();
      int r = first - second;
      if (r > 0) pq.offer(r);
    }

    return (pq.size() == 1) ? pq.remove() : 0;
  }

  public static void main(String[] args) {
    LastStoneWeight lsw = new LastStoneWeight();
    int[] stones = {2, 7, 4, 1, 8, 1};
    System.out.println(lsw.lastStoneWeight(stones));
  }
}
