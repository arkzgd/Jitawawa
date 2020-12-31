package com.ihaveaname.java.leetcode;

import java.util.HashSet;
import java.util.Set;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x, ListNode n) {
    val = x;
    next = n;
  }
}

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && slow != null) {
      if (fast.next != null && slow.next != null && slow.next == fast.next.next) return true;
      fast = (fast.next != null) ? fast.next.next : null;
      slow = slow.next;
    }

    return false;
  }

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && slow != null) {
      if (fast.next != null && slow.next != null && slow.next == fast.next.next) {
        slow = head;
        fast = fast.next.next;
        while (slow != fast) {
          fast = fast.next;
          slow = slow.next;
        }
        return slow;
      };
      fast = (fast.next != null) ? fast.next.next : null;
      slow = slow.next;
    }

    return null;
  }

  public static void main(String[] args) {
    LinkedListCycle llc = new LinkedListCycle();
    ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, null))));
    assert llc.hasCycle(head) == false;
    assert llc.detectCycle(head) == null;

    head = new ListNode(1, null);
    assert llc.hasCycle(head) == false;
    assert llc.detectCycle(head) == null;

    ListNode node3 = new ListNode(3, null);
    ListNode node2 = new ListNode(2, null);
    ListNode node0 = new ListNode(0, null);
    ListNode nodeMinus4 = new ListNode(-4, null);

    node3.next = node2;
    node2.next = node0;
    node0.next = nodeMinus4;
    nodeMinus4.next = node2;
    head = node3;
    assert llc.hasCycle(head) == true;
    assert llc.detectCycle(head) == node2;

    ListNode node1 = new ListNode(1, null);
    node2 = new ListNode(2, null);
    node1.next = node2;
    node2.next = node1;
    head = node1;
    assert llc.hasCycle(head) == true;
    assert llc.detectCycle(head) == node1;

    head = new ListNode(1, null);
    head.next = head;
    assert llc.hasCycle(head) == true;
    assert llc.detectCycle(head) == head;

    head = null;
    assert llc.hasCycle(head) == false;
    assert llc.detectCycle(head) == null;
  }
}
