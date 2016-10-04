package dp;

/**
 * Link: http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * 
 * @author shivam.maharshi
 */
public class Knapsack {
  
  // Top down Dynamic Programming - Memoization.
  public static int knapsack(int W, int[] w, int[] v, int i, int[][] dp) {
    if (W==0 || i < 0)
      return 0;
    
    if (dp[i][W]!=-1)
      return dp[i][W];
    
      if (W >= w[i]) {
        dp[i][W] = Math.max(v[i] + knapsack(W - w[i], w, v, i - 1, dp), knapsack(W, w, v, i-1, dp));
        return dp[i][W];
      } else {
        dp[i][W] = knapsack(W, w, v, i-1, dp);
        return dp[i][W];
      }
  }
  
  public static void main(String[] args) {
    int[] w = {10, 20, 30};
    int[] v = {60, 100, 120};
    int W = 50;
    int[][] dp = new int[w.length][W+1];
    for(int i=0; i<dp.length; i++)
      for(int j=0; j<dp[0].length; j++)
        dp[i][j] = -1;
    System.out.println(knapsack(W, w, v, w.length-1, dp));
  }

}
