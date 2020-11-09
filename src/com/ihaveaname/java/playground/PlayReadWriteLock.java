package com.ihaveaname.java.playground;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PlayReadWriteLock {
  public static void main(String[] args) {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock rl = lock.readLock();
    ReentrantReadWriteLock.WriteLock wl = lock.writeLock();

    System.out.println("First Read Lock");
    rl.lock();

    System.out.println("Second Read Lock");
    rl.lock();

    try {
      System.out.println("Simulating Working on something...");
      Thread.sleep(4000);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    } finally {
      System.out.println("First Read Unlock");
      rl.unlock();

      System.out.println("Second Read Unlock");
      rl.unlock();
    }

    while (!rl.tryLock()) {
      System.out.println("Tried and Failed Getting Read Lock");
      try {
        Thread.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Tried and Got Read Lock");
    rl.unlock();

    Thread thread =
        new Thread(
            () -> {
              wl.lock();
              try {
                System.out.println("Locker WriteLock");
                try {
                  Thread.sleep(6000);
                  System.out.println("Locker job done");
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              } finally {
                wl.unlock();
              }
            },
            "Locker");

    thread.start();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
