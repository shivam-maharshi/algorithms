package data.structures;

/**
 * Min heap.
 * 
 * @author shivam.maharshi
 */
public class MinHeap<T extends Comparable<T>> {

	T[] a;
	int size;

	@SuppressWarnings("unchecked")
	public MinHeap(int capacity) {
		// Start index with 1.
		this.a = (T[]) new Object[capacity + 1];
	}

	public void add(T n) {
		if (size == a.length - 1) {
			throw new RuntimeException("Heap Full.");
		}
		a[++size] = n;
		siftUp(size); // To maintain heap property.
		// Parent must be smaller than or equals to both kids.
	}

	private void siftUp(int index) {
		if (index > 1) {
			if (a[index / 2].compareTo(a[index]) == 1) {
				T temp = a[index];
				a[index] = a[index / 2];
				a[index / 2] = temp;
				siftUp(index / 2);
			}
		}
	}

	public T extractMin() {
		if (size == 1) {
			throw new RuntimeException("Heap Empty.");
		}
		T res = a[1];
		a[1] = a[size];
		size--;
		buildHeap();
		return res;
	}

	// Satisfy the heap property for all the nodes. Complexity is n(log(n)).
	private void buildHeap() {
		for (int i = size / 2; i >= 1; i--) {
			minHeapify(i); // Complexity is log(n).
		}
	}

	private void minHeapify(int i) {
		int min = i;
		// Left
		if (a[2 * i].compareTo(a[i]) == -1) {
			min = 2 * i;
		}
		// Right
		if (a[2 * i + 1].compareTo(a[i]) == -1) {
			min = 2 * i + 1;
		}
		if (min != i) {
			T temp = a[min];
			a[min] = a[i];
			a[i] = temp;
			// This is like sifting down.
			minHeapify(min);
		}
	}

}
