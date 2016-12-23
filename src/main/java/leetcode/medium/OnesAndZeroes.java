package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/ones-and-zeroes/
 * 
 * @author shivam.maharshi
 */
public class OnesAndZeroes extends TestCase {

  @Test
  public static void test() {
    assertEquals(4, findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
    assertEquals(2, findMaxForm(new String[] { "10", "1", "0" }, 1, 1));
    assertEquals(3, findMaxForm(new String[] { "11", "1", "1", "0" }, 1, 2));
  }

  // Awesome Bottom Up DP backwards.
  public static int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String s : strs) {
      int[] c = count(s);
      for (int i = m; i >= c[0]; i--)
        for (int j = n; j >= c[1]; j--)
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i - c[0]][j - c[1]]);
    }
    return dp[m][n];
  }

  public static int[] count(String s) {
    int[] r = new int[2];
    for (char c : s.toCharArray())
      r[c - '0']++;
    return r;
  }

}
