package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * @author shivam.maharshi
 */
public class UniqueBinarySearchTrees extends TestCase {

  @Test
  public static void test() {
    assertEquals(5, numTrees(3));
  }

  public static int numTrees(int n) {
    if (n == 0)
      return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++)
      for (int j = 0; j < i; j++)
        dp[i] += dp[j] * dp[i - j - 1];
    return dp[n];
  }

}
