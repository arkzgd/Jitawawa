package com.ihaveaname.java.leetcode;

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
    ListNode fast = head != null && head.next != null ? head.next.next : null;

    while (fast != null && slow != null) {
      if (slow == fast) return true;
      fast = (fast.next != null) ? fast.next.next : null;
      slow = slow.next;
    }

    return false;
  }

  public static void main(String[] args) {
    LinkedListCycle llc = new LinkedListCycle();
    ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, null))));
    System.out.println(llc.hasCycle(head));

    head = new ListNode(1, null);
    System.out.println(llc.hasCycle(head));

    ListNode node3 = new ListNode(3, null);
    ListNode node2 = new ListNode(2, null);
    ListNode node0 = new ListNode(0, null);
    ListNode nodeMinus4 = new ListNode(-4, null);

    node3.next = node2;
    node2.next = node0;
    node0.next = nodeMinus4;
    nodeMinus4.next = node2;
    head = node3;
    System.out.println(llc.hasCycle(head));

    ListNode node1 = new ListNode(1, null);
    node2 = new ListNode(2, null);
    node1.next = node2;
    node2.next = node1;
    head = node1;
    System.out.println(llc.hasCycle(head));

    head = new ListNode(1, null);
    head.next = head;
    System.out.println(llc.hasCycle(head));

    head = null;
    System.out.println(llc.hasCycle(head));
  }
}
