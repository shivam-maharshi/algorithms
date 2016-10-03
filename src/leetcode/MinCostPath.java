package leetcode;

/**
 * You can only move right, down or diagonal.
 * 
 * Leet Code: https://leetcode.com/problems/minimum-path-sum/
 * 
 * @author shivam.maharshi
 */
public class MinCostPath {

  // Bottom up dynamic approach.
  public static int minPathSum(int[][] grid) {
    int h = grid.length;
    int w = grid[0].length;
    int[][] dp = new int[h][w];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < h; i++)
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    for (int j = 1; j < w; j++)
      dp[0][j] = dp[0][j - 1] + grid[0][j];

    for (int i = 1; i < h; i++) {
      for (int j = 1; j < w; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
      }
    }
    return dp[h - 1][w - 1];
  }

}
