package dp;

/**
 * Calculate binomial co-effcient.
 * 
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * 
 * @author shivam.maharshi
 */
public class BinomialCoefficient {
  
  public static void main(String[] args) {
    int n = 5;
    int k = 2;
    System.out.println(get(n, k, new int[n + 1][k + 1]));
    System.out.println(val(n, k, new int[n + 1][k + 1]));
  }
  
  public static int val(int n, int k, int[][] dp) {
    for(int i=0; i<dp.length; i++) {
      dp[i][0] = 1;
      dp[i][Math.min(i, k)] = 1;
    }
    
    for (int i=1; i<=n; i++) {
      for (int j=1; j <= Math.min(i, k); j++) {
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
      }
    }
    
    return dp[n][k];
  }

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

}
