package math;

/**
 * Find the lexicographic rank of a string in its permutation.
 *
 * Link: http://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
 * 
 * @author shivam.maharshi
 */
public class LexicographicalRankOfString {

	public static int getRank(String s) {
		char[] c = s.toCharArray();
		int r = 0;
		int[] a = new int[26];
		for (char cc : c) {
			a[cc - 97]++;
		}
		for (int i = 0; i < c.length; i++) {
			a[(int) c[i] - 97] = -1;
			int d = getSmallerChar(a, c[i]);
			r += d * fact(c.length - i - 1);
		}
		return r + 1;
	}

	private static int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fact(n - 1);
	}

	public static int getSmallerChar(int[] a, char c) {
		int count = 0;
		for (int i = 0; i < (int) c - 97; i++) {
			if (a[i] == 1) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(getRank("string"));
	}

}
