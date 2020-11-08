package com.ihaveaname.java.cglib;

public class App {
    public static void main(String[] args) {
        Test test = new Test();
        Test factory = (Test) new CGFactory(test).getProxyInstance();
        String result = factory.test("Hello World");

        System.out.println(result);
    }
}
