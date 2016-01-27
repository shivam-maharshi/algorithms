package sorting;

import data.structures.MinHeap;

/**
 * Given an array of n elements, where each element is at most k away from its
 * target position, devise an algorithm that sorts in O(n log k) time.
 * 
 * Link: http://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * 
 * @author shivam.maharshi
 */
public class NearlyKSortedArrSorting {

	public static int[] sort(int[] a, int k) {
		int[] res = new int[a.length];

		MinHeap<Integer> heap = new MinHeap<>(Integer.class, k);

		for (int i = 0; i < k; i++) {
			heap.add(new Integer(a[i]));
		}

		for (int i = k; i < a.length; i++) {
			res[i - k] = heap.extractMin();
			heap.add(new Integer(a[i]));
		}

		for (int i = a.length - k; i < a.length; i++) {
			res[i] = heap.extractMin();
		}
		
		for (int n : res)
			System.out.print(n + " ");
		
		return res;
	}

	public static void main(String[] args) {
		int a[] = { 2, 6, 3, 12, 56, 8 };
		sort(a, 3);
	}

}
