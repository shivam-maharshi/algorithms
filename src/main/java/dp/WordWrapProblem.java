package dp;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * 
 * @author shivam.maharshi
 */
public class WordWrapProblem extends TestCase {

  @Test
  public void test() {
    assertEquals(13, get(new int[] { 5, 3, 5, 8, 4, 4, 7 }, 15));
  }

  /**
   * A pretty tricky question. The idea is to create a square matrix of length
   * equals to the numbers of input words. The store the minimal left space in
   * dp to where dp[i][j] signify the left spaces if word i to j belongs in a
   * line. Now with this dp, it is easy to calculate an arrangement such that
   * the total sum is of left over space is minimum.
   */
  public static int get(int[] w, int n) {
    if (w == null || w.length == 0)
      return 0;
    int l = w.length, index = l - 1, to = l - 1;
    int[][] dp = new int[l][l];
    for (int[] d : dp)
      Arrays.fill(d, Integer.MAX_VALUE);
    for (int i = 0; i < l; i++) {
      int t = w[i];
      dp[i][i] = (n - t) * (n - t);
      for (int j = i + 1; j < l; j++) {
        t += w[j] + 1;
        if (t <= n)
          dp[i][j] = (n - t) * (n - t);
        else
          break;
      }
    }
    int[] r = new int[l], arr = new int[l];
    Arrays.fill(r, Integer.MAX_VALUE);
    r[0] = dp[0][0];
    for (int i = 1; i < l; i++)
      for (int j = 0; j < i; j++)
        if (dp[j][i] != Integer.MAX_VALUE) {
          if (j == 0) {
            r[i] = Math.min(r[i], dp[j][i]);
            if (r[i] == dp[j][i])
              arr[i] = j;
          } else {
            r[i] = Math.min(r[i], r[j - 1] + dp[j][i]);
            if (r[i] == r[j - 1] + dp[j][i])
              arr[i] = j;
          }
        }

    while (index > 0) {
      System.out.println("From: " + arr[index] + " :: To: " + to);
      to = arr[index] - 1;
      index = arr[index] - 1;
    }

    return r[l - 1];
  }

}
