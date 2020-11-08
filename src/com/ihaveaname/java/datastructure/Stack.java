package com.ihaveaname.java.datastructure;

public interface Stack<V> {
    void push(V v);

    V pop();

    V peek();

    boolean empty();
}
