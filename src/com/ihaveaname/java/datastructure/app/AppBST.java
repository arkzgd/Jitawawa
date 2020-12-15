package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.BST;
import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppBST {
  public static void main(String[] args) {
    final int numOfElements = 100000;
    BST<Integer> bst = new BST<>(Integer::compareTo);

    List<Integer> input = new ArrayList<>(numOfElements);
    for (int i = 1; i <= numOfElements; i++) input.add(i);
    Collections.shuffle(input);

    for (int e: input) bst.insert(e);
    assert bst.isBST();

    for (int i = 1; i <= numOfElements; i++) assert bst.contains(i);

    assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);

    Collections.shuffle(input);
    for (int i : input) {
      bst.remove(i);
      assert bst.isBST();
      assert bst.contains(i) == false;
      assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);
    }
  }
}
