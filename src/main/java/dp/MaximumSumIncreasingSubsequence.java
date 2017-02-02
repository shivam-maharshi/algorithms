package dp;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * 
 * @author shivam.maharshi
 */
public class MaximumSumIncreasingSubsequence extends TestCase {

  @Test
  public static void test() {
    assertEquals(106, maxSumSub(new int[] { 1, 101, 2, 3, 100, 4, 5 }));
    assertEquals(306, maxSumSub(new int[] { 1, 105, 2, 3, 200, 4, 5 }));
  }

  public static int maxSumSub(int[] a) {
    if (a == null || a.length == 0)
      return 0;
    int[] dp = new int[a.length];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = a[0];
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < a.length; i++)
      for (int j = 0; j < i; j++)
        if (a[i] > a[j]) {
          dp[i] = Math.max(dp[i], dp[j] + a[i]);
          max = Math.max(max, dp[i]);
        }
    return max;
  }

}
