package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BST;
import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppBST {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>(Integer::compareTo);

    List<Integer> input = new ArrayList<>(10);
    for (int i = 1; i <= 10; i++) input.add(i);
    Collections.shuffle(input);

    for (int e: input) bst.insert(e);
    assert bst.isBST();

    for (int i = 1; i <= 10; i++) assert bst.contains(i);

    assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);
    System.out.println(bst.traverse_in_order());

    bst.remove(10);
    assert bst.contains(10) == false;
    assert bst.isBST();
    assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);
    System.out.println(bst.traverse_in_order());

    bst.remove(4);
    assert bst.contains(4) == false;
    assert bst.isBST();
    assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);
    System.out.println(bst.traverse_in_order());
  }
}
