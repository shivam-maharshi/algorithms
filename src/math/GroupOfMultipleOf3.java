package math;

/**
 * Count all possible groups of size 2 or 3 that have sum as multiple of 3
 * 
 * Link:
 * http://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/
 * 
 * @author shivam.maharshi
 */
public class GroupOfMultipleOf3 {

	public static int count(int[] a) {
		int res = 0;
		int[] r = new int[3];
		for (int i = 0; i < a.length; i++) {
			r[a[i] % 3]++;
		}
		// Pair of two.
		res += nC2(r[0]) + r[1] * r[2];
		// Pair of three.
		res += nC3(r[0]) + nC3(r[1]) + nC3(r[2]) + r[0] * r[1] * r[2];
		return res;
	}

	private static int nC2(int n) {
		return n * (n - 1) / 2;
	}

	private static int nC3(int n) {
		return n * (n - 1) * (n - 2) / 6;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 6, 7, 2, 9 };
		System.out.println(count(a));
	}

}
