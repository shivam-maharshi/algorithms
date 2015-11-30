package math;

/**
 * Find the length of the longest increasing sub sequence.
 *
 * @author shivam.maharshi
 */
public class LongestIncreasingSubsequence {

	// Find out the longest common subsequence in an int array.

	public static int longIncreasingSequence(int[] arr) {
		int len = arr.length;
		int[] dp = new int[len];
		int maxSubLen = 0;
		for (int i = 0; i < len; i++) {
			int subLen = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					subLen = Math.max(subLen, dp[j] + 1);
				}
			}
			dp[i] = subLen;
		}
		for (int i = 0; i < len; i++) {
			maxSubLen = Math.max(maxSubLen, dp[i]);
		}
		return maxSubLen;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 6, 3, 4, 1, 2, 9, 5, 8 };
		System.out.println(LongestIncreasingSubsequence.longIncreasingSequence(arr));
	}

}
