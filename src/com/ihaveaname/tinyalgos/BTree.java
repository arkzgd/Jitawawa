package com.ihaveaname.tinyalgos;

import java.util.*;

public class BTree<V> {

    public static class BTreeNode<V> {
        V v;
        BTreeNode<V> leftTree;
        BTreeNode<V> rightTree;

        public BTreeNode(BTreeNode<V> left, V v, BTreeNode<V> right) {
            this.v = v;
            this.leftTree = left;
            this.rightTree = right;
        }
    }

    private boolean isOddValue(int value) {
        return (value % 2) == 1;
    }

    private V[] getLeftSubTreeNodes(V[] nodes) {
        List<V> result = new ArrayList<>();

        if (!isOddValue(nodes.length))
            return (V[]) result.toArray();
        else {
            if (nodes.length == 1)
                return (V[]) result.toArray();
            int len = (nodes.length - 1) >> 1;
            return Arrays.copyOfRange(nodes, 1, len+1);
        }
    }

    private V[] getRightSubTreeNodes(V[] nodes) {
        List<V> result = new ArrayList<>();

        if (!isOddValue(nodes.length))
            return (V[]) result.toArray();
        else {
            if (nodes.length == 1)
                return (V[]) result.toArray();
            int len = (nodes.length - 1) >> 1;
            return Arrays.copyOfRange(nodes, len+1, nodes.length);
        }
    }

    public BTreeNode<V> buildBTree(V[] nodes) {
        if (nodes.length == 0)
            return null;

        if (nodes[0] == null)
            return null;

        V[] l = getLeftSubTreeNodes(nodes);
        V[] r = getRightSubTreeNodes(nodes);
        return new BTreeNode<>(buildBTree(l), nodes[0], buildBTree(r));
    }

    public V[] traverse_pre_order(BTreeNode<V> tree) {
        List<V> result = new ArrayList<>();

        if (tree != null) {
            result.add(tree.v);

            Collections.addAll(result, traverse_pre_order(tree.leftTree));
            Collections.addAll(result, traverse_pre_order(tree.rightTree));
        }

        return (V[]) result.toArray();
    }

    public V[] dfs(BTreeNode<V> tree) {
        List<V> result = new ArrayList<>();

        if (tree == null)
            return (V[]) result.toArray();
        else
            result.add(tree.v);

        Collections.addAll(result, dfs(tree.leftTree));
        Collections.addAll(result, dfs(tree.rightTree));

        return (V[]) result.toArray();
    }

    public V[] dfs_non_recursive(BTreeNode<V> tree) {
        List<V> result = new ArrayList<>();
        Stack<BTreeNode<V>> stack = new Stack<>();

        if (tree == null)
            return (V[]) result.toArray();

        stack.push(tree);

        while (!stack.empty()) {
            BTreeNode<V> current = stack.pop();
            if (current != null) {
                result.add(current.v);
                stack.push(current.rightTree);
                stack.push(current.leftTree);
            }
        }

        return (V[]) result.toArray();
    }
}
