package math;

/**
 * Count the ways to reach Nth stair when a person can climb one or two steps.
 * 
 * Link: http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * 
 * @author shivam.maharshi
 */
public class ReachNthStair {

	public static int count(int n) {
		if (n <= 2)
			return n;
		return count(n - 1) + count(n - 2);
	}

	public static int countDp(int n, int[] dp) {
		if (n <= 2)
			return n;
		if (dp[n] != 0)
			return dp[n];
		else
			dp[n] = countDp(n, dp);
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(count(4));
	}

}
