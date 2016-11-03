package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/unique-paths-ii/
 * 
 * @author shivam.maharshi
 */
public class UniquePathsII extends TestCase {

  @Test
  public static void test() {
    int[][] a = new int[][] { { 0, 0 }, { 1, 0 } };
    assertEquals(1, uniquePathsWithObstacles(a));
    int[][] b = new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 } };
    assertEquals(2, uniquePathsWithObstacles(b));
    int[][] c = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 } };
    assertEquals(1, uniquePathsWithObstacles(c));
    int[][] d = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    assertEquals(6, uniquePathsWithObstacles(d));
  }

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
      return 1;

    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    dp[0][0] = obstacleGrid[0][0]==1 ? 0 : 1;
    for (int i = 1; i < m; i++)
      dp[i][0] = (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) ? 0 : 1;

    for (int i = 1; i < n; i++)
      dp[0][i] = (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) ? 0 : 1;

    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];

    return dp[m - 1][n - 1];
  }

}
