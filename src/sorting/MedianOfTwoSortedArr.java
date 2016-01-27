package sorting;

/**
 * Find the median of two sorted arrays in O(log(n)) complexity.
 * 
 * Link: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * 
 * @author shivam.maharshi
 */
public class MedianOfTwoSortedArr {

	public static int median(int[] a, int[] b) {
		return median(a, b, 0, a.length, 0, b.length);
	}

	public static int m(int[] a, int[] b) {
		int alen = a.length, blen = b.length;
		boolean even = false;
		if ((alen + blen) % 2 == 0) {
			even = true;
		}
		int al = 0, ah = a.length, bl = 0, bh = b.length;
		while (ah - al != 1 && bh - bl != 1) {
			int am = (ah + al) / 2;
			int bm = (bh + bl) / 2;
			if (a[am] < b[bm]) {
				al = am;
				bh = bm;
			} else if (a[am] > b[bm]) {
				ah = am;
				bl = bm;
			} else {
				break;
			}
		}

		if (even) {
			return (Math.max(a[al], b[bl]) + Math.min(a[al + 1], b[bl + 1])) / 2;
		} else {
			return Math.max(a[al], b[bl]);
		}
	}

	// Assuming even number of elements.
	private static int median(int[] a, int[] b, int al, int ah, int bl, int bh) {
		if ((ah - al) == 1 && (bh - bl) == 1)
			return (Math.max(a[al], b[bl]) + Math.min(a[al + 1], b[bl + 1])) / 2;
		int am = al + (ah - al) / 2;
		int bm = bl + (bh - bl) / 2;
		if (a[am] == b[bm])
			return a[am];
		if (a[am] < b[bm])
			return median(a, b, am, ah, bl, bm);
		else
			return median(a, b, al, am, bm, bh);
	}

	public static void main(String[] args) {
		int[] a = { 1, 12, 15, 26, 38 };
		int[] b = { 2, 13, 17, 30 };
		// System.out.println(median(a, b));
		System.out.println(m(a, b));
	}

}
