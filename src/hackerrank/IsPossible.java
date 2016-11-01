package hackerrank;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Given a number pair can 
 * @author shivam.maharshi
 *
 */
public class IsPossible extends TestCase {

  @Test
  public static void test() {
    assertEquals("Yes", isPossible(1, 4, 1, 4));
    assertEquals("Yes", isPossible(1, 4, 5, 9));
    assertEquals("No", isPossible(1, 4, 5, 10));
    assertEquals("No", isPossible(1, 4, 1, 2));
    assertEquals("No", isPossible(1, 4, 0, 4));
    assertEquals("No", isPossible(1, 4, 0, 3));
    assertEquals("No", isPossible(1, 1, 1000, 1000));
  }

  public static String isPossible(int a, int b, int c, int d) {
    return p(a, b, c, d, new Boolean[a + b + 1 + c][a + b + 1 + d]) ? "Yes" : "No";
  }

  public static boolean p(int a, int b, int c, int d, Boolean[][] dp) {
    if (a > c || b > d)
      return false;

    if (a == c && b == d)
      return true;

    if (dp[a][b] != null)
      return dp[a][b];

    dp[a][b] = p(a + b, b, c, d, dp) || p(a, a + b, c, d, dp);

    return dp[a][b];
  }

}
