package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/super-ugly-number
 * 
 * @author shivam.maharshi
 */
public class M313_SuperUglyNumber extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, nthSuperUglyNumber(1, new int[] { 2, 7, 13, 19 }));
    assertEquals(8, nthSuperUglyNumber(4, new int[] { 2 }));
    assertEquals(7, nthSuperUglyNumber(4, new int[] { 2, 7, 13, 19 }));
  }

  public static int nthSuperUglyNumber(int n, int[] primes) {
    int[] r = new int[n];
    int[] times = new int[primes.length];
    r[0] = 1;
    for (int i = 1; i < n; i++) {
      r[i] = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++)
        r[i] = Math.min(r[i], primes[j] * r[times[j]]);
      for (int j = 0; j < primes.length; j++)
        if ((primes[j] * r[times[j]]) == r[i])
          times[j]++;
    }
    return r[n - 1];
  }

}
