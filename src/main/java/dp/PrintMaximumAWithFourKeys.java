package dp;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
 * 
 * @author shivam.maharshi
 */
public class PrintMaximumAWithFourKeys extends TestCase {

  @Test
  public static void test() {
    assertEquals(3, max(3));
    assertEquals(9, max(7));
  }

  public static int max(int n) {
    int[] dp = new int[n], cp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    dp[2] = 3;
    cp[2] = 1;
    for (int i = 3; i < n; i++) {
      cp[i] = dp[i - 2];
      dp[i] = Math.max(i + 1, Math.max(2 * dp[i - 3], dp[i - 3] + cp[i - 1]));
    }
    return dp[n - 1];
  }

}
