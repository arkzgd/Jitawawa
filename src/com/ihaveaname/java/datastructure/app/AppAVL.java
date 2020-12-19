package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.tree.AVL;
import com.ihaveaname.java.datastructure.tree.AVLNode;
import com.ihaveaname.java.datastructure.tree.BST;

import java.util.List;

public class AppAVL {

  public static void main(String[] args) {

    AVL<Integer> avl = new AVL<Integer>(Integer::compareTo);

    for (int i = 1; i <= 20; i++) {
      avl.insert(i);
    }

    assert avl.isAVL();

    List<AVLNode<Integer>> result = avl.traverse_in_order();
    for (AVLNode<Integer> e : result) {
      System.out.print(e.v + " @ " + e.height + "; ");
    }

    BST<Integer> bst = avl.toBST();
    assert bst.isBST();
  }
}
