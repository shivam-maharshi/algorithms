package recursion;

/**
 * Find the minimum edit distance of one word from another.
 * 
 * Link: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * 
 * @author shivam.maharshi
 */
public class MinimumEditDistance {

	public static int get(String a, String b) {
		// return get(a, b, a.length(), b.length());
		return get(a, b, a.length(), b.length(), new int[a.length() + 1][b.length() + 1]);
	}

	// TimeComplexity of this solution is o(3^n). Use DP.
	private static int get(String a, String b, int m, int n) {
		if (a == null || m == 0)
			return n;
		if (b == null || n == 0)
			return m;
		if (a.charAt(m - 1) == b.charAt(n - 1))
			return get(a, b, m - 1, n - 1);
		else {
			return 1 + min(get(a, b, m - 1, n) /* remove from m */,
					get(a, b, m, n - 1)/* insert in m */,
					get(a, b, m - 1, n - 1)/* replace in m */);
		}
	}

	// Solution using DP. Time Complexity: O(n*m) max computations.
	private static int get(String a, String b, int m, int n, int[][] dp) {
		if (a == null || m == 0)
			return n;
		if (b == null || n == 0)
			return m;
		if (dp[m][n] != 0)
			return dp[m][n];
		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			dp[m][n] = get(a, b, m - 1, n - 1);
			return dp[m][n];
		} else {
			dp[m][n] = 1 + min(get(a, b, m - 1, n) /* remove from m */,
					get(a, b, m, n - 1)/* insert in m */,
					get(a, b, m - 1, n - 1)/* replace in m */);
			return dp[m][n];
		}
	}

	private static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	public static void main(String[] args) {
		System.out.println(get("abcdee", "efghef"));
	}

}
