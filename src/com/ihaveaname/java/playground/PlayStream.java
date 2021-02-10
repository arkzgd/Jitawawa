package com.ihaveaname.java.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class PlayStream {
  public static void main(String[] args) {
    int parallism = ForkJoinPool.commonPool().getParallelism();

    List<String> tasks1 = new ArrayList<>();
    List<String> tasks2 = new ArrayList<>();

    for (int i = 0; i < parallism + 1; i++) tasks1.add("Tasks1-" + i);

    for (int i = 0; i < parallism; i++) tasks2.add("Tasks2-" + i);

    Thread thread1 =
        new Thread(
            () ->
                tasks1.parallelStream()
                    .forEach(
                        task -> {
                          System.out.println(Thread.currentThread().getName() + " executing " + task);
                          try {
                            Thread.sleep(6000);
                          } catch (InterruptedException ex) {
                            System.out.println(Thread.currentThread() + " is interrupted.");
                          } finally {
                            System.out.println(
                                Thread.currentThread().getName() + " finished " + task);
                          }
                        }),
            "Tasks1 Runner");
    thread1.start();

    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Thread thread2 =
        new Thread(
            () ->
                tasks2.parallelStream()
                    .forEach(
                        task -> {
                          System.out.println(Thread.currentThread().getName() + " executing " + task);
                          try {
                            Thread.sleep(60);
                          } catch (InterruptedException ex) {
                            System.out.println(Thread.currentThread() + " is interrupted.");
                          } finally {
                            System.out.println(
                                Thread.currentThread().getName() + " finished " + task);
                          }
                        }),
            "Tasks2 Runner");
    thread2.start();
  }
}
