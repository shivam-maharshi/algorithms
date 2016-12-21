package sorting;

import java.util.Arrays;

/**
 * Sort numbers using Bucket Sort.
 * 
 * Link: http://www.geeksforgeeks.org/bucket-sort-2/
 * 
 * @author shivam.maharshi
 */
public class BucketSort {

	public static void sort(int[] a, int maxVal) {
		int[] bucket = new int[maxVal + 1];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}

		for (int i = 0; i < a.length; i++) {
			bucket[a[i]]++;
		}

		int outPos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				a[outPos++] = i;
			}
		}
	}

	public static void main(String[] args) {
		int maxVal = 15;
		int[] data = { 5, 3, 0, 2, 4, 1, 0, 15, 2, 3, 1, 14 };

		System.out.println("Before: " + Arrays.toString(data));
		sort(data, maxVal);
		System.out.println("After:  " + Arrays.toString(data));
	}
}
