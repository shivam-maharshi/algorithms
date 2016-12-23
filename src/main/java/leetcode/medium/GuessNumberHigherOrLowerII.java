package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * 
 * @author shivam.maharshi
 */
public class GuessNumberHigherOrLowerII extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, getMoneyAmount(1));
    assertEquals(1, getMoneyAmount(2));
    assertEquals(2, getMoneyAmount(3));
    assertEquals(4, getMoneyAmount(4));
    assertEquals(6, getMoneyAmount(5));
    assertEquals(8, getMoneyAmount(6));
  }

  public static int getMoneyAmount(int n) {
    return get(new int[n + 1][n + 1], 1, n);
  }

  // Top Down DP
  public static int get(int[][] dp, int s, int e) {
    if (s >= e)
      return 0;
    if (dp[s][e] != 0)
      return dp[s][e];
    int r = Integer.MAX_VALUE;
    for (int i = s; i <= e; i++)
      r = Math.min(r, i + Math.max(get(dp, s, i - 1), get(dp, i + 1, e)));
    dp[s][e] = r;
    return r;
  }

}
