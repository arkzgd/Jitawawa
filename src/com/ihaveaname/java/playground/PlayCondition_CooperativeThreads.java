package com.ihaveaname.java.playground;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PlayCondition_CooperativeThreads {
  private int counter = 0;

  final Lock lock = new ReentrantLock();
  final Condition cond = lock.newCondition();

  final Thread thread1 =
      new Thread(
          () -> {
            while (true) {
              lock.lock();
              try {
                while (counter % 2 != 0) cond.await();
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                Thread.sleep(1000);
                cond.signal();
              } catch (InterruptedException ex) {
                ex.printStackTrace();
              } finally {
                lock.unlock();
              }
            }
          },
          "Worker-1");

  final Thread thread2 =
      new Thread(
          () -> {
            while (true) {
              lock.lock();
              try {
                while (counter % 2 == 0) cond.await();
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                Thread.sleep(1000);
                cond.signal();
              } catch (InterruptedException ex) {
                ex.printStackTrace();
              } finally {
                lock.unlock();
              }
            }
          },
          "Worker-2");

  public static void main(String[] args) {
    PlayCondition_CooperativeThreads ply = new PlayCondition_CooperativeThreads();

    ply.thread1.start();
    ply.thread2.start();
  }
}
