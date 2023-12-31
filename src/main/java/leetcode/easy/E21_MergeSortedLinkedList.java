package leetcode.easy;

import leetcode.ListNode;

/**
 * Link: https://leetcode.com/problems/merge-two-sorted-lists
 * 
 * @author shivam.maharshi
 */
public class E21_MergeSortedLinkedList {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
      return null;
    else if (l1 == null)
      return l2;
    else if (l2 == null)
      return l1;
    else {
      ListNode head = null;
      if (l1.val < l2.val) {
        head = l1;
        l1 = l1.next;
      } else {
        head = l2;
        l2 = l2.next;
      }
      ListNode temp = head;
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          temp.next = l1;
          l1 = l1.next;
        } else {
          temp.next = l2;
          l2=l2.next;
        }
        temp = temp.next;
      }
      while(l1!=null) {
        temp.next = l1;
        l1 = l1.next;
        temp = temp.next;
      }
      while(l2!=null) {
        temp.next = l2;
        l2 = l2.next;
        temp = temp.next;
      }
      return head;
    }
  }

}
