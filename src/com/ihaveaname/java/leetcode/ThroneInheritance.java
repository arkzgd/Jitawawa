package com.ihaveaname.java.leetcode;

import java.util.ArrayList;
import java.util.List;

class ThroneInheritance {
  class Person {
    String name;
    boolean alive;
    Person parent;
    ArrayList<Person> children;

    Person(String name) {
      this.name = name;
      alive = true;
      parent = null;
      children = new ArrayList<>();
    }

    void childBirth(Person child) {
      child.parent = this;
      children.add(child);
    }

    void dead() {
      alive = false;
    }
  }

  Person throne;

  public ThroneInheritance(String kingName) {
    throne = new Person(kingName);
  }

  private void birth(Person person, String parentName, String childName) {
    if (person.name.equals(parentName)) person.childBirth(new Person(childName));
    else for (Person p : person.children) birth(p, parentName, childName);
  }

  public void birth(String parentName, String childName) {
    birth(throne, parentName, childName);
  }

  private void death(Person person, String name) {
    if (person.name.equals(name)) person.dead();
    else for (Person p : person.children) death(p, name);
  }

  public void death(String name) {
    death(throne, name);
  }

  private Person successor(Person x, List<String> currOrder) {
    if (x.children.size() == 0
        || x.children.stream().filter(c -> currOrder.contains(c.name)).count()
            == x.children.size()) {
      if (x.name.equals(throne.name)) {
        return null;
      } else {
        return successor(x.parent, currOrder);
      }
    } else {
      for (Person c : x.children) {
        if (currOrder.contains(c.name)) continue;
        else return c;
      }
    }

    return null;
  }

  public List<String> getInheritanceOrder() {
    List<String> currOrder = new ArrayList<>();
    List<String> result = new ArrayList<>();
    if (throne.alive) result.add(throne.name);
    Person yier = throne;

    while ((yier = successor(yier, currOrder)) != null) {
      currOrder.add(yier.name);
      if (yier.alive) result.add(yier.name);
    }

    return result;
  }

  public static void main(String[] args) {
    ThroneInheritance t = new ThroneInheritance("king");
    t.birth("king", "andy");
    t.birth("king", "bob");
    t.birth("king", "catherine");
    t.birth("andy", "matthew");
    t.birth("bob", "alex");
    t.birth("bob", "asha");
    System.out.println(t.getInheritanceOrder());
    t.death("bob");
    System.out.println(t.getInheritanceOrder());
  }
}
