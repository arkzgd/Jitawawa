package com.ihaveaname.java.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue<V> implements Stack<V> {
    private Queue<V> queue = new LinkedList<>();

    @Override
    public void push(V v) {
        queue.offer(v);
        while (queue.peek() != v) {
            queue.offer(queue.poll());
        }
    }

    @Override
    public V pop() {
        return queue.poll();
    }

    @Override
    public V peek() {
        return queue.peek();
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> wstack = new StackByQueue<>();

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
