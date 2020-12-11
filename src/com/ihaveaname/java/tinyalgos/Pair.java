package com.ihaveaname.java.tinyalgos;

public class Pair<U, V> {
  public final U u;
  public final V v;

  public Pair(U u, V v) {
    this.u = u;
    this.v = v;
  }

  public String toString() {
    return "[" + u + ", " + v + "]";
  }
}
