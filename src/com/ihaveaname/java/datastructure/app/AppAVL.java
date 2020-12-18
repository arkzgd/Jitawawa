package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.tree.AVL;
import com.ihaveaname.java.datastructure.tree.AVLNode;

public class AppAVL {

  public static void main(String[] args) {

    AVL<Integer> avl = new AVL<Integer>((o1, o2) -> o1.v - o2.v);

    for (int i = 1; i <= 10; i++) {
      AVLNode<Integer> node = new AVLNode<>(i);
      avl.insert(node);
      assert avl.isBST();

      avl.updateBalanceFactor();
      avl.traverse_in_order().stream()
        .forEach(
          an -> System.out.print("node: " + an.v + " -> " + an.balanceFactor + " "));

      System.out.println();
    }
  }
}
