package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.tree.AVL;
import com.ihaveaname.java.datastructure.tree.AVLNode;
import com.ihaveaname.java.datastructure.tree.BST;
import com.ihaveaname.java.tinyalgos.sorting.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppAVL {

  public static void main(String[] args) {

    AVL<Integer> avl = new AVL<>(Integer::compareTo);

    final int numOfElements = 20;
    List<Integer> input = new ArrayList<>(numOfElements);
    for (int i = 1; i <= numOfElements; i++) input.add(i);
    Collections.shuffle(input);

    for (Integer e : input) avl.insert(e);

    assert avl.isAVL();

    List<AVLNode<Integer>> result = avl.traverse_in_order();
    result.forEach(e -> System.out.print(e.v + " "));
    System.out.println();

    BST<Integer> bst = avl.toBST();
    assert bst.isBST();
    assert Utils.checkAscendingOrder(bst.traverse_in_order(), Integer::compareTo);
    System.out.println(bst.traverse_in_order());
  }
}
