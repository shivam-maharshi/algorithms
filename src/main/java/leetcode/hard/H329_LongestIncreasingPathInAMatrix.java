package leetcode.hard;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix
 * 
 * @author shivam.maharshi
 */
public class H329_LongestIncreasingPathInAMatrix extends TestCase {

  public static final int[][] p = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  @Test
  public void test() {
    assertEquals(4, longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
    assertEquals(4, longestIncreasingPath(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } }));
    assertEquals(7, longestIncreasingPath(new int[][] { { 9, 8, 4, 3, 2 }, { 6, 6, 8, 5, 1 }, { 2, 1, 1, 0, 0 } }));
  }

  public static int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int[][] dp = new int[matrix.length][matrix[0].length];
    int[] r = new int[1];
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        parse(matrix, dp, matrix.length, matrix[0].length, i, j, r);
    return r[0];
  }

  public static int parse(int[][] a, int[][] dp, int n, int m, int i, int j, int[] r) {
    if (dp[i][j] != 0)
      return dp[i][j];
    dp[i][j] = 1;
    for (int k = 0; k < p.length; k++) {
      int x = i + p[k][0], y = j + p[k][1];
      dp[i][j] = valid(n, m, x, y) && a[x][y] > a[i][j] ? Math.max(parse(a, dp, n, m, x, y, r) + 1, dp[i][j]) : dp[i][j];
    }
    r[0] = Math.max(dp[i][j], r[0]);
    return dp[i][j];
  }

  public static boolean valid(int n, int m, int i, int j) {
    return i > -1 && j > -1 && i < n && j < m;
  }

}
