package com.ihaveaname.java.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class WeirdStack<V> implements Stack<V> {
    private final Queue<V> queueA = new LinkedList<>();
    private final Queue<V> queueB = new LinkedList<>();
    private Queue<V> current = queueA;
    private Queue<V> next = queueB;

    private void switchCurrent() {
        if (current == queueA) {
            current = queueB;
            next = queueA;
        } else {
            current = queueA;
            next = queueB;
        }
    }

    @Override
    public void push(V v) {
        next.offer(v);
        while (!current.isEmpty()) {
            next.offer(current.poll());
        }

        switchCurrent();
    }

    @Override
    public V pop() {
        return current.poll();
    }

    @Override
    public V peek() {
        return current.peek();
    }

    @Override
    public boolean empty() {
        return current.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> wstack = new WeirdStack<>();

        System.out.println("Push something...");
        wstack.push(3);
        wstack.push(4);
        wstack.push(5);

        System.out.println("Pop 2 of them...");
        System.out.println(wstack.pop());
        System.out.println(wstack.pop());

        System.out.println("Peek the top...");
        System.out.println(wstack.peek());

        System.out.println("Push more...");
        wstack.push(6);
        wstack.push(7);
        wstack.push(8);

        System.out.println("Pop all of them...");
        while (!wstack.empty()) {
            System.out.println(wstack.pop());
        }
    }
}
