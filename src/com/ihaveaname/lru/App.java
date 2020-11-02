package com.ihaveaname.lru;

import java.util.List;

public class App {
    public static void main(String[] args) {
        MyLRUCache<String, Integer> nameToAge = new MyLRUCache<>(4);
        nameToAge.put("Hui ZHANG", 43);
        nameToAge.put("Xin LIANG", 41);
        nameToAge.put("Zhetao ZHANG", 3);
        nameToAge.put("Yuntong ZHANG", 10);

        List<Integer> ages = nameToAge.getValues();
        System.out.println(ages);

        System.out.println("Hui ZHANG: " + nameToAge.get("Hui ZHANG"));
        System.out.println("Zhetao ZHANG: " + nameToAge.get("Zhetao ZHANG"));

        System.out.println(nameToAge.getValues());

        nameToAge.put("Rongpin Ma", 65);

        System.out.println(nameToAge.getValues());
    }
}
