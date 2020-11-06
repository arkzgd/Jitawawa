package com.ihaveaname.lru;

import java.util.*;

public class MyLRUCache<K, V> {

    private static class Node<K, V> {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private HashMap<K, Node<K, V>> keys;
    private LinkedList<Node<K, V>> values;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        keys = new HashMap<K, Node<K, V>>(capacity);
        values = new LinkedList<Node<K, V>>();
    }

    private Boolean isFull() {
        return keys.size() == capacity;
    }

    public void put(K key, V value) {

        if (isFull()) {
            Node<K, V> n = values.poll();
            K k = n.key;
            if (keys.containsKey(k)) {
                keys.remove(k);
            }
        }

        Node n = new Node(key, value);

        if (values.offer(n)) keys.put(key, n);
    }

    private void adjustLRU(Node<K, V> n) {
        values.remove(n);
        values.offer(n);
    }

    public V get(K key) {
        if (keys.containsKey(key)) {
            Node<K, V> n = keys.get(key);
            adjustLRU(n);

            return n.value;
        } else
            return null;
    }

    public List<V> getValues() {
        List<V> result = new ArrayList<>();
        Iterator<Node<K, V>> i = values.iterator();

        for (; i.hasNext(); ) {
            result.add(i.next().value);
        }

        return result;
    }
}