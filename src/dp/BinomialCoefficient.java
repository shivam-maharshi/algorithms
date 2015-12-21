package dp;

/**
 * Calculate binomial coeffcient.
 * 
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * 
 * @author shivam.maharshi
 */
public class BinomialCoefficient {

	// C(n, k) = C(n-1, k-1) + C(n-1, k)
	// Time : O(n*k)
	public static int get(int n, int k, int dp[][]) {
		if (k == 0 || k == n)
			return 1;
		if (dp[n][k] != 0)
			return dp[n][k];
		else {
			dp[n][k] = get(n-1, k - 1, dp) + get(n - 1, k, dp);
			return dp[n][k];
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		System.out.println(get(n, k, new int[n + 1][k + 1]));
	}

}
