package interview.google;

/**
 * Given a sorted array of size N of int32, find an element that repeats >
 * ceil(N / 2) times. Your algo may assume that there will be always such
 * element. Space/time O(1). Follow up question: Now element repeats > ceil(N /
 * 4) times. Space/time O(1)
 * 
 * Link: http://www.careercup.com/question?id=5647871593414656
 * 
 * @author shivam.maharshi
 */
public class FindNumRepeatsMoreThanInSortedArr {

	// For ceil(n/2)
	public static int getNby2(int[] a) {
		return a[a.length / 2];
	}

	// For ceil(n/4)
	public static int getNby4(int[] a) {
		for (int i = 1; i < 3; i++) {
			if (a[(a.length * i) / 4] == a[(a.length * (i + 1)) / 4]) {
				return a[(a.length * i) / 4];
			}
		}
		return 0; // Should never reach.
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 2, 2, 2, 2, 2, 5, 5 };
		System.out.println(getNby2(a));
		System.out.println(getNby4(a));
	}

}
