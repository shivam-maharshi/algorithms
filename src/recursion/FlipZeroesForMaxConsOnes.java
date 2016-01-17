package recursion;

/**
 * Flip zeroes in the given array for the maximum no. of consecutive number of
 * ones. The maximum flips allowed are given as m.
 * 
 * Link:http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of
 * -consecutive-1s-is-maximized/
 * 
 * @author shivam.maharshi
 */
public class FlipZeroesForMaxConsOnes {

	public static int printIndexes(int[] a, int m) {
		// To hold number of zeroes from start index to end index.
		// Start index = row, end index = column.
		int n = a.length;
		int[][] dp = new int[n][n];
		int row = 0, col = n - 1;
		int zeroes = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				zeroes++;
			}
			dp[0][i] = zeroes;
		}

		while (row < n && row >= 0) {
			while (col > 0 && col < n) {
				if (a[row] == 0) {
					dp[row + 1][col] = dp[row][col] - 1;
				} else {
					dp[row + 1][col] = dp[row][col];
				}
				if (a[col] == 0) {
					dp[row][col - 1] = dp[row][col] - 1;
				} else {
					dp[row][col - 1] = dp[row][col];
				}
				col--;
			}
			row++;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] <= m && Math.abs(j - i) > max) {
					max = Math.abs(j - i);
				}
			}
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
		FlipZeroesForMaxConsOnes.printIndexes(a, 2);
	}

}
