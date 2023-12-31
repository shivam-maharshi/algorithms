package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/lru-cache
 * 
 * @author shivam.maharshi
 */
public class M146_LRUCache {
  
  public static void main(String[] args) {
    M146_LRUCache c = new M146_LRUCache(2);
    System.out.println(c.get(1));
    c.set(1, 10);
    System.out.println(c.get(1));
    c.set(2, 20);
    System.out.println(c.get(2));
    System.out.println(c.get(1));
    c.set(3, 30);
    System.out.println(c.get(3));
    System.out.println(c.get(2));
    System.out.println(c.get(1));
    c.set(2, 20);
    System.out.println(c.get(3));
    System.out.println(c.get(2));
    System.out.println(c.get(1));
    
  }

  Map<Integer, Node> m;
  Node head, last;
  int capacity;

  public M146_LRUCache(int capacity) {
    this.m = new HashMap<>();
    // Sentinel node.
    this.head = new Node(null, -1, null);
    this.last = new Node(null, -1, head);
    head.next = last;
    this.capacity = capacity;
  }

  public int get(int key) {
    if (capacity == 0)
      return -1;

    Node n = m.get(key);
    if (n == null)
      return -1;
    else {
      updateNodePosition(n);
      return n.val;
    }
  }

  public void set(int key, int value) {
    if (capacity == 0)
      return;
    
    if (m.size() == capacity) {
      m.remove(last.prev.key);
      last.prev.prev.next = last;
      last.prev = last.prev.prev;
    }
    
    Node n = m.get(key);
    if (n == null) {
      n = new Node(key, value, null);
      Node temp = head.next;
      head.next = n;
      n.prev = head;
      n.next = temp;
      temp.prev = n;
      m.put(key, n);
    } else {
      n.val = value;
      updateNodePosition(n);
    }
  }

  public void updateNodePosition(Node n) {
    if (head.next != n) {
      if (n.next == last) {
        // Last node.
        n.prev.next = last;
        last.prev = n.prev;
      } else {
        // Mid node.
        n.prev.next = n.next;
        n.next.prev = n.prev;
      }
      Node temp = head.next;
      head.next = n;
      n.prev = head;
      n.next = temp;
      temp.prev = n;
    }
  }

  private class Node {

    Node prev;
    Node next;
    int val;
    Integer key;

    public Node(Integer key, int val, Node prev) {
      this.key = key;
      this.val = val;
      this.next = null;
      this.prev = prev;
    }

  }

}
