package com.ihaveaname.java.playground;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;

public class PlaySpliterator {
  static List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21);

  public static void main(String[] args) {
    Spliterator<Integer> spList = list.spliterator();
    Spliterator<Integer> splitted = spList.trySplit();
    if (splitted != null) {
      while (true) if (!splitted.tryAdvance((integer -> System.out.println(integer)))) break;
      spList.forEachRemaining(integer -> System.out.println(integer));
    }
  }
}
