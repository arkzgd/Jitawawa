package com.ihaveaname.java.datastructure.app;

import java.util.PriorityQueue;
import java.util.Queue;

public class AppPriorityQueue {
  public static void main(String[] args) {
    Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    int numElements = 10;
    for (int i = 1; i <= numElements; i++) for (int j = i; j <= numElements; j++) queue.offer(j);

    while (!queue.isEmpty()) {
      System.out.print(queue.poll() + " ");
    }

    numElements = 500000;
    for (int i = 1; i <= numElements; i++)
      queue.offer(i);

    while (!queue.isEmpty()) {
      System.out.print(queue.poll() + " ");
    }
  }
}
