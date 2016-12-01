package interview.twitter;

/**
 * Find out all the ways to reach from top left corner to bottom right corner of
 * a matrix if we are allowed to move down, right and diagonally down.
 * 
 * @author shivam.maharshi
 */
public class Kraken {

  public static int krakenCount(int m, int n) {
    if (m == 0 && n == 0)
      return 0;

    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++)
      dp[i][0] = 1;
    for (int i = 0; i < n; i++)
      dp[0][i] = 1;

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1];
      }
    }

    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(krakenCount(2, 2));
  }

}
