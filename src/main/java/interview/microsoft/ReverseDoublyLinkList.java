package interview.microsoft;

/**
 * Given a Doubly Linked List. Reverse it such that all the nodes are pointing
 * in the reverse direction. Can you do it in-place?
 * 
 * Link: https://leetcode.com/discuss/79766/reverse-a-doubly-link-list
 * 
 * @author shivam.maharshi
 */
public class ReverseDoublyLinkList {
	
	public static void reverse(DoublyLinkedList list) {
		Link curr = list.first;
		Link prev = curr.prev;
		Link next = curr.next;
		while(curr!=null) {
			curr.next = prev;
			curr.prev = next;
			curr = next;
			prev = curr.prev;
			next = curr.next;
		}
	}
	
	class DoublyLinkedList {
		private Link first;
	}
	
	public class Link {
		private Link prev;
		private Link next;
	}

}