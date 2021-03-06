package com.ihaveaname.java.leetcode;

import java.util.*;

class ThroneInheritance {
  class Person {
    String name;
    boolean alive;
    List<Person> children = new ArrayList<>();

    Person(String name) {
      this.name = name;
      alive = true;
    }

    void addChild(Person child) {
      children.add(child);
    }
  }

  Person throne;
  HashMap<String, Person> families = new HashMap<>();

  public ThroneInheritance(String kingName) {
    throne = new Person(kingName);
    families.put(kingName, throne);
  }

  public void birth(String parentName, String childName) {
    Person child = new Person(childName);
    families.get(parentName).addChild(child);
    families.put(childName, child);
  }

  public void death(String name) {
    families.get(name).alive = false;
  }

  private void helper(Person person, List<String> result) {
    if (person != null) {
      if (person.alive) result.add(person.name);
      for (Person c : person.children) helper(families.get(c.name), result);
    }
  }

  public List<String> getInheritanceOrder() {
    List<String> result = new ArrayList<>();
    helper(throne, result);

    return result;
  }

  public static void main(String[] args) {
    ThroneInheritance t = new ThroneInheritance("king");
    System.out.println(t.getInheritanceOrder());
    t.birth("king", "andy");
    System.out.println(t.getInheritanceOrder());
    t.birth("king", "bob");
    System.out.println(t.getInheritanceOrder());
    t.birth("king", "catherine");
    System.out.println(t.getInheritanceOrder());
    t.birth("andy", "matthew");
    System.out.println(t.getInheritanceOrder());
    t.birth("bob", "alex");
    System.out.println(t.getInheritanceOrder());
    t.birth("bob", "asha");
    System.out.println(t.getInheritanceOrder());
    t.death("bob");
    System.out.println(t.getInheritanceOrder());
    t.death("catherine");
    System.out.println(t.getInheritanceOrder());
    t.death("king");
    System.out.println(t.getInheritanceOrder());
    t.death("alex");
    System.out.println(t.getInheritanceOrder());
    t.death("andy");
    System.out.println(t.getInheritanceOrder());
    t.death("matthew");
    System.out.println(t.getInheritanceOrder());
    t.death("asha");
    System.out.println(t.getInheritanceOrder());

    ThroneInheritance t2 = new ThroneInheritance("king");
    t2.birth("king", "clyde");
    System.out.println(t2.getInheritanceOrder());
    t2.death("clyde");
    System.out.println(t2.getInheritanceOrder());
    t2.birth("king", "shannon");
    System.out.println(t2.getInheritanceOrder());
  }
}
