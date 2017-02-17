package interview.google;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/grid-unique-paths/
 * 
 * @author shivam.maharshi
 */
public class GridUniquePaths extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, uniquePaths(1, 2));
    assertEquals(1, uniquePaths(2, 1));
    assertEquals(2, uniquePaths(2, 2));
  }

  public static int uniquePaths(int a, int b) {
    if (a <= 0 || b <= 0)
      return 0;
    int[][] dp = new int[a][b];
    for (int i = 0; i < a; i++)
      dp[i][0] = 1;
    for (int i = 0; i < b; i++)
      dp[0][i] = 1;
    for (int i = 1; i < a; i++)
      for (int j = 1; j < b; j++)
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
    return dp[a - 1][b - 1];
  }

}
