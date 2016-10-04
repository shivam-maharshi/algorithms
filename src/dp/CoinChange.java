package dp;

/**
 * Find the number of ways a sum can be reached from unlimited changes.
 * 
 * Link: http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * @author shivam.maharshi
 */
public class CoinChange {

  public static int cc(int[] coins, int n) {
    int[][] dp = new int[coins.length][n + 1];
    for (int i = 0; i < dp.length; i++)
      dp[i][0] = 1; // One way to achieve sum 0.
    
    // Iterate through different coins.
    for (int i = 0; i < dp.length; i++) {
      // Iterate through the amount.
      for (int j = 1; j <= n; j++) {
        int takeThisCoin =  (j >= coins[i]) ? dp[i][j - coins[i]] : 0;
        int leaveThisCoin = (i>=1) ? dp[i-1][j] : 0;
        dp[i][j] = takeThisCoin + leaveThisCoin;
      }
    }
    return dp[coins.length-1][n];
  }

  public static void main(String[] args) {
    int[] coins = { 1, 2, 3 };
    int n = 4;
    System.out.println(cc(coins, n));
    
    int[][] dp = new int[coins.length][n + 1];
    for (int i = 0; i < dp.length; i++)
      for (int j = 0; j <= n; j++)
        dp[i][j] = -1;
    System.out.println(cc(coins, n, 0, dp));
  }

  // Either select a coin or don't. This is memoization of recursive approach.
  public static int cc(int[] coins, int n, int cur, int[][] dp) {
    if (n == 0)
      return 1;
    if (cur >= coins.length)
      return 0;

    if (dp[cur][n] != -1)
      return dp[cur][n];

    if (n >= coins[cur]) {
      // Select the coin or don't.
      dp[cur][n] = cc(coins, n - coins[cur], cur, dp) + cc(coins, n, cur + 1, dp);
    } else {
      // Can't select the coin.
      dp[cur][n] = cc(coins, n, cur + 1, dp);
    }
    return dp[cur][n];
  }

}
