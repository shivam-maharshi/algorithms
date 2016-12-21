package interview.microsoft;

/**
 * Design a Circular Buffer with push, pop, next, hasNext.
 * 
 * Link: https://leetcode.com/discuss/88912/design-a-circular-buffer
 * 
 * @author shivam.maharshi
 */
public class CircularBuffer<T> {

	private T[] store;
	// Always designates the start of CB.
	private int start;
	// Always designates the end of CB.
	private int end;
	// 0 indicates empty, initialCapacity is full.
	private int size;

	public CircularBuffer(int initialCapacity) {
		this.store = (T[]) new Object[initialCapacity];
	}
	
	public void push(T... vals) {
		for(int i=0;i<vals.length;i++)
			push(vals[i]);
	}

	// Inserts an item at the end.
	public void push(T val) {
		if (end == store.length)
			end = 0;
		store[end] = val;
		if (size < store.length)
			size++; // When CB has free space.
		else {
			// Means the CB is full.
			start++; // Value of start was overwritten.
			if (start == store.length)
				start = 0;
		}
		end++;
	}

	// Removes an item from start.
	public T pop() {
		if (size == 0)
			throw new RuntimeException("CircularBuffer is empty.");
		size--;
		T val = store[start];
		store[start] = null;
		start++;
		if (start == store.length)
			start = 0;
		return val;
	}

	// Reads the next item.
	public T next() {
		if (size == 0)
			throw new RuntimeException("CircularBuffer is empty.");
		return store[start];
	}

	// Returns true if not empty.
	public boolean hasNext() {
		return size > 0;
	}

	public void print() {
		for (int n = 0; n < store.length - 1; n++)
			System.out.print(store[n] + "->");
		System.out.println(store[store.length - 1]);
	}

	public static void main(String[] args) {
		CircularBuffer<Integer> cb = new CircularBuffer<>(5);
		cb.push(1,2,3,4,5);
		cb.print();
		cb.push(6);
		cb.print();
		for(int i=0;i<5;i++)
		System.out.println(cb.pop());
		// Completely empty.
		cb.print();
		// Is empty now, will throw exception.
		System.out.println(cb.pop());
	}

}
