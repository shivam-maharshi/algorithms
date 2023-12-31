package dp;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 * 
 * @author shivam.maharshi
 */
public class LongestBitonicSequence extends TestCase {

  @Test
  public void test() {
    assertEquals(6, get(new int[] { 1, 11, 2, 10, 4, 5, 2, 1 }));
    assertEquals(5, get(new int[] { 12, 11, 40, 5, 3, 1 }));
    assertEquals(5, get(new int[] { 80, 60, 30, 40, 20, 10 }));
  }

  public static int get(int[] a) {
    if (a == null || a.length == 0)
      return 0;
    int max = 0;
    // Longest increasing subsequence from left and right.
    int[] lis = new int[a.length], lisr = new int[a.length];
    lis[0] = 1;
    lisr[a.length - 1] = 1;
    for (int i = 1; i < a.length; i++)
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j])
          lis[i] = Math.max(lis[i], lis[j] + 1);
        if (a[a.length - i - 1] > a[a.length - j - 1])
          lisr[a.length - i - 1] = Math.max(lisr[a.length - i - 1], lisr[a.length - j - 1] + 1);
      }
    for (int i = 0; i < a.length; i++)
      max = Math.max(max, lis[i] + lisr[i] - 1);
    return max;
  }

}
