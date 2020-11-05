package com.ihaveaname.playground;

public class PlayFinally {
    static int mayThrowException1() {
        int i = 100;
        try {
            return i;
        } finally {
            ++i;
        }
    }

    static int mayThrowException2() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    static void mayThrowException3() {
        int a1 = 0;
        try {
            a1 = 1;
            // finally a1 = 3
        } catch (Exception e) {
            a1 = 2;
            // finally a1 = 3
        } finally {
            a1 = 3;
        }
        System.out.println(a1);
    }

    public static void main(String[] args) {
        System.out.println(mayThrowException1()); // 100

        System.out.println(mayThrowException2()); // 2

        mayThrowException3(); // 3
    }
}
