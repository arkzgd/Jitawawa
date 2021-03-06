package com.ihaveaname.java.leetcode;

import java.util.*;

class ThroneInheritance {
  class Person {
    String name;
    HashMap<String, Person> children = new LinkedHashMap<>();

    Person(String name) {
      this.name = name;
    }

    void addChild(Person child) {
      children.put(child.name, child);
    }
  }

  Person throne;
  HashSet<String> deceased = new HashSet<>();

  public ThroneInheritance(String kingName) {
    throne = new Person(kingName);
  }

  private void birth(Person person, String parentName, String childName) {
    if (person != null) {
      if (person.name.equals(parentName)) {
        person.addChild(new Person(childName));
      } else {
        for (Person c : person.children.values()) {
          birth(c, parentName, childName);
        }
      }
    }
  }

  public void birth(String parentName, String childName) {
    birth(throne, parentName, childName);
  }

  public void death(String name) {
    deceased.add(name);
  }

  private void helper(Person person, List<String> result) {
    if (person != null) {
      if (!deceased.contains(person.name)) result.add(person.name);
      for (Person c : person.children.values()) {
        helper(c, result);
      }
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
