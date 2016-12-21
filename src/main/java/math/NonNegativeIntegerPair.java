package math;

/**
 * Given a positive number n, count all distinct Non-Negative Integer pairs (x,
 * y) that satisfy the inequality x*x + y*y < n.
 * 
 * Link:
 * http://www.geeksforgeeks.org/count-distinct-non-negative-pairs-x-y-satisfy-
 * inequality-xx-yy-n-2/
 * 
 * @author shivam.maharshi
 */
public class NonNegativeIntegerPair {

	public static int count(int n) {
		int max = (int) Math.sqrt(n);
		if (n == max * max)
			max--;
		int equiMax = (int) Math.sqrt(n / 2);
		if (n / 2 == equiMax * equiMax)
			equiMax--;
		return count(n, max, equiMax);
	}

	private static int count(int n, int max, int equiMax) {
		int res = 0;
		int a = equiMax;
		int b = equiMax;
		while (a >= 0) {
			while (a * a + b * b < n) {
				b++;
			}
			b--;
			res += (b - a + 1);
			a--;
		}
		res = 2 * res - ( equiMax + 1);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(count(2));
	}

}
