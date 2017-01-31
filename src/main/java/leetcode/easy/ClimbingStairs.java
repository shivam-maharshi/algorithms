package leetcode.easy;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/climbing-stairs/
 * 
 * @author shivam.maharshi
 */
public class ClimbingStairs extends TestCase {

  @Test
  public static void test() {
    assertEquals(3, climbStairs(3));
  }

  public static int climbStairs(int n) {
    if (n==0 || n==1 || n==2)
      return n;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n - 1];
  }

}
