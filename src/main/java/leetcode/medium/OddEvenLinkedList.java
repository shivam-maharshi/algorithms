package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/odd-even-linked-list/
 * 
 * @author shivam.maharshi
 */
public class OddEvenLinkedList {

  public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode odd = head;
    ListNode feven = odd.next;
    ListNode even = odd.next;
    while (true) {
      if (even != null) {
        if (even.next == null) {
          odd.next = feven;
          break;
        } else {
          odd.next = even.next;
          odd = odd.next;
        }
      } else {
        odd.next = feven;
        break;
      }
      even.next = odd.next;
      even = even.next;
    }
    return head;
  }

}
