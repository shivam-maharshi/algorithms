package sorting;

/**
 * Given a sorted array arr[] and a value X, find the k closest elements to X in
 * arr[].
 * 
 * Link: http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 * 
 * @author shivam.maharshi
 */
public class FindKClosestElement {

	public static void find(int[] a, int n, int k) {
		int index = getIndex(a, n);
		int[] res = new int[k];
		int i = index + 1, j = index - 1;
		int count = 0;
		while (count < k) {
			if (i >= a.length && j < 0) {
				break;
			} else if (i < a.length && j >= 0) {
				if (Math.abs(a[i] - n) <= Math.abs(a[j] - n)) {
					res[count] = a[i];
					i++;
				} else {
					res[count] = a[j];
					j--;
				}
			} else if (i < a.length) {
				res[count] = a[i];
				i++;
			} else {
				res[count] = a[j];
				j--;
			}
			count++;
		}
		for (int num : res)
			System.out.print(num + " ");
	}

	// Return index of n by binary search.
	private static int getIndex(int[] a, int n) {
		int l = 0, h = a.length - 1;
		while (h >= l) {
			int mid = ((l + h) / 2);
			if (a[mid] == n)
				return mid;
			else if (a[mid] > n)
				h = mid - 1;
			else
				l = mid + 1;
		}
		return -1; // Never reachable.
	}

	public static void main(String[] args) {
		int a[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		find(a, 35, 4);
	}

}
