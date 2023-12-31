package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/unique-paths
 * 
 * @author shivam.maharshi
 */
public class M62_UniquePaths extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, uniquePaths(1, 1));
    assertEquals(1, uniquePaths(1, 2));
    assertEquals(1, uniquePaths(2, 1));
    assertEquals(2, uniquePaths(2, 2));
  }

  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++)
      dp[i][0] = 1;
    for (int i = 0; i < n; i++)
      dp[0][i] = 1;

    for (int i = 1; i < m; i++)
      for (int j = 1; j < n; j++)
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

    return dp[m-1][n-1];
  }

}
