package math;

/**
 * Find the smallest twins, which are two prime numbers with a difference of two
 * between them. They should lie in the given range.
 * 
 * Link:
 * http://www.geeksforgeeks.org/find-the-smallest-twin-numbers-in-given-range/
 * 
 * @author shivam.maharshi
 *
 */
public class SmallestTwin {

	public static void get(int low, int high) {
		boolean[] a = new boolean[high + 1];
		a[1] = true;
		getArray(high + 1, a);
		for (int i = low; i < high - 1; i++) {
			if (!(a[i] || a[i + 2])) {
				System.out.println("a: " + i + ", b: " + (i + 2));
			}
		}
	}

	private static void getArray(int n, boolean[] a) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			for (int num = i; num <= n; num += i) {
				a[num] = true;
			}
		}
	}

	public static void main(String[] args) {
		SmallestTwin.get(50, 100);
	}

}
