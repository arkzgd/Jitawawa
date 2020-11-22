package com.ihaveaname.java.playground;

public class PlayHashMap {

  /** The default initial capacity - MUST be a power of two. */
  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

  /**
   * The maximum capacity, used if a higher value is implicitly specified by either of the
   * constructors with arguments. MUST be a power of two <= 1<<30.
   */
  static final int MAXIMUM_CAPACITY = 1 << 30;

  /** The load factor used when none specified in constructor. */
  static final float DEFAULT_LOAD_FACTOR = 0.75f;

  static final int tableSizeFor(int cap) {
    int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
    System.out.printf("cap (%d) -> %d ", cap, n);
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 31; i++)
      System.out.printf("table size for capacity %d is %d\n", 1 << i, tableSizeFor(1 << i));

    int j = 0xffffffff;
    System.out.println(j);
    for (int i=0;i<32;i++)
      System.out.printf("arithmetic (%d) vs. ordinary (%d)\n", j >>> i, j >> i);
  }
}
