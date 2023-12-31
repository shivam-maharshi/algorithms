package leetcode.medium;

import leetcode.ListNode;

/**
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs
 * 
 * @author shivam.maharshi
 */
public class M24_SwapNodesInPairs {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;
    head = swap(head, head.next);
    ListNode start = head.next;
    while (start != null && start.next != null) {
      ListNode temp = swap(start.next, start.next.next);
      start.next = temp;
      start = temp.next;
    }
    return head;
  }

  public ListNode swap(ListNode f, ListNode s) {
    if (f != null && s == null)
      return f;
    else {
      ListNode temp = s.next;
      s.next = f;
      f.next = temp;
      return s;
    }
  }

}
