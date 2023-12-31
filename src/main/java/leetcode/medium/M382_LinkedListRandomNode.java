package leetcode.medium;

import leetcode.ListNode;

/**
 * Link: https://leetcode.com/problems/linked-list-random-node
 * 
 * @author shivam.maharshi
 */
public class M382_LinkedListRandomNode {

  public static void main(String[] args) {
    ListNode head = new ListNode(10);
    ListNode n2 = new ListNode(1);
    head.next = n2;
    ListNode n3 = new ListNode(10);
    n2.next = n3;
    ListNode n4 = new ListNode(100);
    n3.next = n4;
    ListNode n5 = new ListNode(20);
    n5.next = n4;

    M382_LinkedListRandomNode l = new M382_LinkedListRandomNode(head);
    System.out.println(l.getRandom());
  }

  ListNode head;
  ListNode r;

  /**
   * @param head
   *          The linked list's head. Note that the head is guaranteed to be not
   *          null, so it contains at least one node.
   */
  public M382_LinkedListRandomNode(ListNode head) {
    this.head = head;
    this.r = head;
  }

  /** Returns a random node's value. */
  public int getRandom() {
    // Reservoir sampling.
    int i = 0;
    ListNode cur = head;
    while (cur != null) {
      if ((int)((i + 1) * Math.random()) == 0)
        r = cur;
      i++;
      cur = cur.next;
    }
    return r.val;
  }

}
