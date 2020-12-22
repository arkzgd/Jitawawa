package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.tree.AVL;
import com.ihaveaname.java.datastructure.tree.BST;
import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AppAVL {

  public static void main(String[] args) {

    AVL<Integer> avl = new AVL<>(Integer::compareTo);

    final int numOfElements = 65535;
    List<Integer> input = new ArrayList<>(numOfElements);
    for (int i = 1; i <= numOfElements; i++) input.add(i);
    Collections.shuffle(input);

    for (Integer e : input) {
      assert avl.isAVL();
      avl.insert(e);
      assert avl.isAVL();
    }

    List<Integer> traversed =
        avl.traverse_in_order().stream().map(e -> e.v).collect(Collectors.toList());
    assert Utils.checkAscendingOrder(traversed, Integer::compareTo);
    System.out.println("AVL Traversed in-order: \n" + traversed);
    System.out.println("Tree Height: " + avl.avlHeight());

    BST<Integer> bst = avl.toBST();
    assert bst.isBST();
    assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);

    Collections.shuffle(input);
    for (Integer e : input) {
      assert avl.isAVL();
      avl.remove(e);
      assert avl.isAVL();
      bst = avl.toBST();
      assert bst.isBST();
      assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);
    }

    System.out.println("AVL validations passed.");
  }
}
