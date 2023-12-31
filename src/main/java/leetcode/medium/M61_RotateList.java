package leetcode.medium;

import leetcode.ListNode;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/rotate-list
 * 
 * @author shivam.maharshi
 */
public class M61_RotateList extends TestCase {

  @Test
  public void test() {
    ListNode o = new ListNode(1);
    ListNode t = new ListNode(2);
    ListNode th = new ListNode(3);
    ListNode f = new ListNode(4);
    ListNode fi = new ListNode(5);
    o.next = t;
    t.next = th;
    th.next = f;
    f.next = fi;

    // assertEquals(f, rotateRight(o, 2));
    assertEquals(f, rotateRight(o, 7));
  }

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null)
      return head;

    int l = 0;
    ListNode n = head;
    while (n != null) {
      n = n.next;
      l++;
    }

    if (k % l == 0)
      return head;

    k = l - (k % l);
    ListNode first = head;
    ListNode last = null;

    while (k > 0) {
      last = first;
      first = first.next;
      k--;
    }

    ListNode t = first;
    while (t.next != null) {
      t = t.next;
    }

    t.next = head;
    last.next = null;
    return first;
  }

}