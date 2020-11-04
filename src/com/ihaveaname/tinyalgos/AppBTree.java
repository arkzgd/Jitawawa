package com.ihaveaname.tinyalgos;

import java.util.Arrays;

public class AppBTree {
    public static void main(String[] args) {
        BTree<Integer> iBTree = new BTree<>();

        Integer nodes[] = {3, 4, null, null, 20, 15, 7};
        BTree.BTreeNode<Integer> tree = iBTree.buildBTree(nodes);

        Object traversed[] = iBTree.traverse_pre_order(tree);
        System.out.println(Arrays.toString(traversed));

        Object dfsed[] = iBTree.dfs(tree);
        System.out.println(Arrays.toString(dfsed));

        Object dfsed_non_recursive[] = iBTree.dfs_non_recursive(tree);
        System.out.println(Arrays.toString(dfsed_non_recursive));

        int h = iBTree.height_dfs(tree);
        System.out.println("tree has height: " + h);

        h = iBTree.height_dfs_non_recursive(tree);
        System.out.println("tree has height: " + h);
    }
}
