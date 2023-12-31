package dp;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 * 
 * @author shivam.maharshi
 */
public class CuttingRod extends TestCase {

  @Test
  public void test() {
    assertEquals(22, max(new int[] { 1, 5, 8, 9, 10, 17, 17, 20 }, 8));
  }

  public static int max(int[] p, int n) {
    if (n <= 0)
      return 0;
    int[] dp = p.clone();
    for (int i = 1; i < n; i++)
      for (int j = 0; j < i; j++)
        dp[i] = Math.max(dp[i], dp[i - j - 1] + dp[j]);
    return dp[n - 1];
  }
}
