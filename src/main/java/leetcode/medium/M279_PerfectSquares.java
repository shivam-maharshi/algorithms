package leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/perfect-squares
 * 
 * @author shivam.maharshi
 */
public class M279_PerfectSquares extends TestCase {

  @Test
  public void test() {
    assertEquals(1, numSquares(1));
    assertEquals(2, numSquares(2));
    assertEquals(3, numSquares(3));
    assertEquals(1, numSquares(4));
    assertEquals(2, numSquares(5));
    assertEquals(3, numSquares(6));
    assertEquals(4, numSquares(7));
    assertEquals(2, numSquares(8));
    assertEquals(1, numSquares(9));
    assertEquals(2, numSquares(10));
    assertEquals(3, numSquares(11));
    assertEquals(3, numSquares(12));
    assertEquals(2, numSquares(13));
    assertEquals(3, numSquares(14));
    assertEquals(4, numSquares(15));
    assertEquals(1, numSquares(16));
  }

  // Bottom up DP
  public static int numSquares(int n) {
    if (n==0 || n==1)
      return n;
    int[] s = new int[(int) Math.sqrt(n)];
    for (int i = 0; i < s.length; i++)
      s[i] = (i + 1) * (i + 1);
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++)
      for (int j = 0; j < (int)Math.sqrt(i); j++)
        dp[i] = Math.min(dp[i], dp[i - s[j]] + 1);
    return dp[n];
  }

}
