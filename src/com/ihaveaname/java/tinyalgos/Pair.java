package com.ihaveaname.java.tinyalgos;

public class Pair<U, V> {
    private U u;
    private V v;

    public Pair(U u, V v) {
        this.u = u;
        this.v = v;
    }

    public String toString() {
        return "["+u+", "+v+"]";
    }
}
