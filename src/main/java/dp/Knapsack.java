package dp;

/**
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * 
 * @author shivam.maharshi
 */
public class Knapsack {

  public static void main(String[] args) {
    int[] w = { 10, 20, 30 };
    int[] v = { 60, 100, 120 };
    int W = 50;
    int[][] dp = new int[w.length][W + 1];
    for (int i = 0; i < dp.length; i++)
      for (int j = 0; j < dp[0].length; j++)
        dp[i][j] = -1;
    System.out.println(knapsack(W, w, v, w.length - 1, dp));
    System.out.println(ks(W, w, v));
  }

  // Bottom up DP.
  public static int ks(int w, int[] a, int[] v) {
    int[][] dp = new int[a.length][w + 1];
    // Nothing can be reached with 0 weight.
    for (int i = 0; i < a.length; i++)
      dp[i][0] = 0;
    // Select first element when smaller than weight.
    for (int j = 0; j <= w; j++)
      if (a[0] <= j)
        dp[0][j] = v[0];

    for (int i = 1; i < a.length; i++) {
      for (int j = 1; j < w + 1; j++) {
        if (j >= a[i]) // Weight smaller.
          dp[i][j] = Math.max(v[i] + dp[i - 1][j - a[i]], dp[i - 1][j]);
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[a.length - 1][w];
  }

  // Top down Dynamic Programming - Memoization.
  public static int knapsack(int W, int[] w, int[] v, int i, int[][] dp) {
    if (W == 0 || i < 0)
      return 0;

    if (dp[i][W] != -1)
      return dp[i][W];

    if (W >= w[i]) {
      dp[i][W] = Math.max(v[i] + knapsack(W - w[i], w, v, i - 1, dp), knapsack(W, w, v, i - 1, dp));
      return dp[i][W];
    } else {
      dp[i][W] = knapsack(W, w, v, i - 1, dp);
      return dp[i][W];
    }
  }

}
