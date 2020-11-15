package com.ihaveaname.java.playground;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PlayCondition_PoliteThreads {
  final Lock lock = new ReentrantLock();
  final Condition cond = lock.newCondition();

  final Thread thread1 =
      new Thread(
          () -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": " + "Gonna call await()");
            try {
              cond.await();
              System.out.println("Out of await.");
            } catch (InterruptedException e) {
              e.printStackTrace();
            } finally{
              lock.unlock();
            }
          },
          "Worker-1");

  final Thread thread2 =
      new Thread(
          () -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": " + "Gonna call await()");
            try {
              cond.await();
              System.out.println("Out of await.");
            } catch (InterruptedException e) {
              e.printStackTrace();
            } finally{
              lock.unlock();
            }
          },
          "Worker-2");

  public static void main(String[] args) throws InterruptedException {
    PlayCondition_PoliteThreads ply = new PlayCondition_PoliteThreads();

    ply.thread1.start();
    ply.thread2.start();

    int i = 5;
    while (i > 0) {
      Thread.sleep(1000);
      System.out.println("-------------------");
      System.out.println(ply.thread1.getName() + ": " + ply.thread1.getState());
      System.out.println(ply.thread2.getName() + ": " + ply.thread2.getState());
      i--;
    }

    // Release them
    ply.lock.lock();
    ply.cond.signalAll();
    ply.lock.unlock();
  }
}
