package sorting;

/**
 * Given a sorted array arr[] of n elements, write a function to search a given
 * element x in arr[].
 * 
 * Link: http://geeksquiz.com/binary-search/
 * 
 * @author shivam.maharshi
 */
public class BinarySearch {

	// Return index of n by binary search.
	public static int find(int[] a, int n) {
		int l = 0, h = a.length - 1;
		while (h >= l) {
			// (l+h)/2 can cause overflow.
			// http://www.geeksforgeeks.org/problem-binary-search-implementations/
			int mid = l + ((h - l) / 2);
			if (a[mid] == n)
				return mid;
			else if (a[mid] > n)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return -1; // Never reachable.
	}

}
