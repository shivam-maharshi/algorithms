package leetcode.medium;

import leetcode.ListNode;

/**
 * Link: https://leetcode.com/problems/add-two-numbers
 * 
 * @author shivam.maharshi
 */
public class M2_AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null)
			return carry != 0 ? new ListNode(carry) : null;
		else {
			int sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (carry != 0)
				sum += carry;
			int c = sum / 10;
			ListNode node = new ListNode(sum % 10);
			node.next = addTwoNumbers(l1, l2, c);
			return node;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);
		ListNode l2 = new ListNode(0);
		new M2_AddTwoNumbers().addTwoNumbers(l1, l2);
	}

}
