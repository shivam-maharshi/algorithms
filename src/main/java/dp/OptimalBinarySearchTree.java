package dp;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 * 
 * @author shivam.maharshi
 */
public class OptimalBinarySearchTree extends TestCase {

  @Test
  public void test() {
    assertEquals(118, min(new int[] { 10, 12 }, new int[] { 34, 50 }));
    assertEquals(142, min(new int[] { 10, 12, 20 }, new int[] { 34, 8, 50 }));
  }

  public static int min(int[] v, int[] f) {
    if (v == null || v.length == 0)
      return 0;
    int len = v.length;
    int[][] dp = new int[len][len];
    for (int i = 0; i < len; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      dp[i][i] = f[i];
    }
    for (int k = 1; k < len; k++)
      for (int i = 0, j = k; j < len; i++, j++)
        for (int sep = 0; sep <= k; sep++) {
          // Precompute sum for O(n^3) complexity.
          int cur = sum(f, i, j);
          cur += i + sep > i ? dp[i][i + sep - 1] : 0;
          cur += i + sep + 1 <= j ? dp[i + sep + 1][j] : 0;
          dp[i][j] = Math.min(dp[i][j], cur);
        }
    
    return dp[0][len - 1];
  }

  // Naive recursive approach.
  public static int min_rec(int[] v, int[] f) {
    return min(v, f, 0, v.length - 1);
  }

  public static int min(int[] v, int[] f, int l, int h) {
    if (l > h)
      return 0;
    if (h == l)
      return f[l];
    int sum = sum(f, l, h);
    int min = Integer.MAX_VALUE;
    for (int i = l; i <= h; i++)
      min = Math.min(min, min(v, f, l, i - 1) + min(v, f, i + 1, h));
    return min + sum;
  }

  public static int sum(int[] v, int l, int h) {
    int s = 0;
    for (int i = l; i <= h; i++)
      s += v[i];
    return s;
  }

}
