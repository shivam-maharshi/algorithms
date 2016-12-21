package leetcode;

/**
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author shivam.maharshi
 */
public class RemoveNthNodeFromEndOfLinkedList {

  public LNode removeNthFromEnd(LNode head, int n) {
    LNode cur = head;
    LNode sec = head;

    while (n != 0) {
      cur = cur.next;
      n--;
    }

    if (cur == null)
      return head.next;

    while (cur.next != null) {
      cur = cur.next;
      sec = sec.next;
    }
    LNode temp = sec.next;
    sec.next = sec.next.next;
    temp.next = null;
    return head;
  }

}

class LNode {

  int val;
  LNode next;

  LNode(int x) {
    val = x;
  }
}
