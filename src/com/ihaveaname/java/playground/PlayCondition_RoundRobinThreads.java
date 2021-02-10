package com.ihaveaname.java.playground;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PlayCondition_RoundRobinThreads {

  static Integer counter = Integer.valueOf(0);

  static class Tapper implements Runnable {
    private final Lock lock;
    private final Condition cond;
    private final int numberOfTappers;
    private final int order;

    public Tapper(Lock lock, Condition cond, int numberOfTappers, int order) {
      this.lock = lock;
      this.cond = cond;
      this.numberOfTappers = numberOfTappers;
      this.order = order;
    }

    @Override
    public void run() {
      while (true) {
        lock.lock();
        try {
          while (counter % numberOfTappers != order) cond.await();
          System.out.println(Thread.currentThread().getName() + ": " + counter);
          counter++;
          Thread.sleep(500);
          cond.signalAll();
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    }
  }

  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();
    int number = 10;

    for (int i = 0; i < number; i++) {
      Tapper tapper = new Tapper(lock, cond, number, i);
      new Thread(tapper, "Worker-" + i).start();
    }
  }
}
