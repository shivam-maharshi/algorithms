package data.structures;

@SuppressWarnings("unchecked")
public class MaxHeap<T extends Comparable<T>> {

	private T[] arr;
	private int size = 0;
	private static int DEFAULT_CAPACITY = 101;

	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	public MaxHeap(int capacity) {
		this.arr = (T[]) (new Object[capacity + 1]);
	}

	public int size() {
		return size;
	}

	public T getParent(int index) {
		validateIndex(index);
		return arr[index / 2];
	}

	public T getLeft(int index) {
		validateIndex(index);
		if (index * 2 > arr.length - 1) {
			return null;
		}
		return arr[2 * index];
	}

	public T getRight(int index) {
		validateIndex(index);
		if (index * 2 + 1 > arr.length - 1) {
			return null;
		}
		return arr[2 * index + 1];
	}

	public void insert(T value) {
		if (isFull()) {
			throw new RuntimeException("Can't insert in a full heap.");
		}
		size++;
		arr[size] = value;
		siftUp(size);
	}

	/**
	 * Checks the parent all the way up to the root for insertion.
	 * 
	 * @param index
	 */
	private void siftUp(int index) {
		if (index == 0)
			return;
		int p = parent(index);
		if (arr[index].compareTo(arr[p]) > 1) {
			swap(index, p);
			siftUp(p);
		}
	}

	public T extract() {
		if (isEmpty()) {
			throw new RuntimeException("Can't extract from empty heap.");
		}
		T result = arr[1];
		arr[1] = arr[size];
		size--;
		buildHeap();
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == arr.length;
	}

	private void validateIndex(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Index can't be negative.");
		}
		if (index > arr.length) {
			throw new IllegalArgumentException("Index can't exceed maximum size.");
		}
	}

	/**
	 * Restore the heap property for all nodes.
	 * 
	 * Complexity is O(n * log(n)).
	 */
	private void buildHeap() {
		for (int i = size / 2; i >= 1; i--) {
			heapify(i);
		}
	}

	/**
	 * This method is responsible for restoring the heap property for the
	 * element at the given index.
	 * 
	 * PreCondition: All the subtrees of the index satisfy heap property.
	 * 
	 * Post Condition: All the subtrees including the one at the index satisfy
	 * heap property.
	 * 
	 * Complexity is O(log(n)).
	 * 
	 * @param index
	 */
	private void heapify(int index) {
		int l = left(index);
		int r = right(index);
		int largest = index;
		if (l < size && arr[l].compareTo(arr[index]) > 0) {
			largest = l;
		}
		if (r < size && arr[r].compareTo(arr[largest]) > 0) {
			largest = r;
		}
		if (largest != index) {
			swap(index, largest);
			heapify(largest);
		}
	}

	private void swap(int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private int parent(int index) {
		return index / 2;
	}

	private int left(int index) {
		return index * 2;
	}

	private int right(int index) {
		return index * 2 + 1;
	}

}
