package ds.java;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Play with the usage of the Java data structures. Examine behavior.
 * 
 * @author shivam.maharshi
 */
public class QueueApp {

	// Queue interface. LinkedList implementation.
	private static Queue<Integer> q = new LinkedList<Integer>();
	// Queue interface. PriorityQueue implementation.
	// If comparator not passed, nodes order will be natural.
	private static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new PriorityQueueComparator());
	// Queue super interface. Deque interface. ArrayDeque implementation.
	// Provides add and remove at both ends.
	// With this, stacks implemented will be faster than the ones using nodes.
	// Queue implemented will be faster than the ones using LinkedList.
	private static Deque<Integer> dq = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		// checkLinkedListQueue();
		// checkPriorityQueue();
		checkDeque();
	}

	public static void checkLinkedListQueue() {
		System.out.println("Linked List Queue Starts !! ");
		Queue<Integer> q = QueueApp.q;
		// Operations
		System.out.println(q.add(5));
		System.out.println(q.add(10));
		System.out.println(q.poll()); // Returns and removes head.
		System.out.println(q.remove()); // Same as poll but throws exception if
										// queue empty.
		System.out.println(q.peek()); // Returns head but doesn't remove it.
		System.out.println(q.element()); // Same as peek but throws exception if
											// queue empty.
	}

	public static void checkPriorityQueue() {
		System.out.println("Priority Queue Starts !! ");
		Queue<Integer> pq = QueueApp.pq;
		// Operations. No null allowed in queue.
		// 10 added before 5, still will be dequeued after 5 as its priorityQ.
		System.out.println(pq.add(10));
		System.out.println(pq.add(5));
		System.out.println(pq.poll()); // Returns and removes head.
		System.out.println(pq.remove()); // Same as poll but throws exception if
											// queue empty.
		System.out.println(pq.peek()); // Returns head but doesn't remove it.
		System.out.println(pq.element()); // Same as peek but throws exception
											// if queue empty.
	}

	public static void checkDeque() {
		System.out.println("Check Deque !!");
		Deque<Integer> dq = QueueApp.dq;
		// Operations.
		dq.addLast(10); // Adds to tail.
		dq.addFirst(5); // Adds to head.
		dq.add(20); // Adds to tail.
		dq.add(15); // Adds to tail.
		System.out.println(dq.pollFirst()); // Reads and removes from head.
		System.out.println(dq.pollLast()); // Reads and removes from tail.
		System.out.println(dq.peekFirst()); // Reads from head.
		System.out.println(dq.removeFirst()); // Like poll but throws exception.
		System.out.println(dq.element()); // No first or last here. Reads and
											// removes from head.
	}

}

class PriorityQueueComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2)
			return -1;
		if (o2 > o1)
			return 1;
		return 0;
	}

}
