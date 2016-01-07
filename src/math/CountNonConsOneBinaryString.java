package math;

/**
 * Given a positive integer N, count all possible distinct binary strings of
 * length N such that there are no consecutive 1’s.
 * 
 * Link:
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-
 * 1s/
 * 
 * @author shivam.maharshi
 */
public class CountNonConsOneBinaryString {

	public static int count(int n, boolean isPrevOne) {
		if (n == 0 || n == 1)
			return 1;
		int res = 0;
		res = count(n - 1, false);
		if (!isPrevOne) {
			// Adding one because one chain increased.
			res += 1 + count(n - 1, true);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(count(3, false));
	}

}
