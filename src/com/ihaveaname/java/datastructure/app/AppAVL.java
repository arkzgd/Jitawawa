package com.ihaveaname.java.datastructure.app;

import com.ihaveaname.java.datastructure.tree.AVL;

public class AppAVL {

  public static void main(String[] args) {

    AVL<Integer> avl = new AVL<Integer>(Integer::compareTo);

    for (int i = 1; i <= 10; i++) {
      avl.insert(i);
    }
  }
}
