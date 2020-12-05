package com.ihaveaname.java.tinyalgos.app;

import com.ihaveaname.java.tinyalgos.Cyclic;

public class AppCyclic {
    public static void main(String[] args) {
        Cyclic cyclic = new Cyclic(10);
        for (int i = 0; i < 19; i++)
            System.out.print(cyclic.for_two_n_1(4, i));

        System.out.println();
    }
}
