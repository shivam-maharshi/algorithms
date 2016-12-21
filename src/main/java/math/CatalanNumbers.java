package math;

/**
 * Find the nth catalan number. They occur naturally in: 1. Count combination of
 * valid parenthesis. 2. Count possible BST with n keys. 3. Count possible full
 * Binary tree.
 * 
 * Link: http://www.geeksforgeeks.org/program-nth-catalan-number/
 * 
 * @author shivam.maharshi
 */
public class CatalanNumbers {

	// Time complexity O(n^2).
	public static int get(int n, int[] dp) {
		if (n <= 1)
			return 1;
		if (dp[n] != 0)
			return dp[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += get(i, dp) * get(n - i - 1, dp);
		}
		dp[n] = res;
		return res;
	}

	public static void main(String[] args) {
		int n = 10;
		int[] dp = new int[n + 1];
		System.out.println(get(n, dp));
	}

}
