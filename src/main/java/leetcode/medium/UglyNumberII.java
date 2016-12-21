package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/ugly-number-ii/
 * 
 * @author shivam.maharshi
 */
public class UglyNumberII extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, nthUglyNumber(1));
    assertEquals(2, nthUglyNumber(2));
    assertEquals(3, nthUglyNumber(3));
    assertEquals(4, nthUglyNumber(4));
    assertEquals(5, nthUglyNumber(5));
    assertEquals(6, nthUglyNumber(6));
    assertEquals(8, nthUglyNumber(7));
    assertEquals(9, nthUglyNumber(8));
    assertEquals(10, nthUglyNumber(9));
    assertEquals(12, nthUglyNumber(10));
  }

  public static int nthUglyNumber(int n) {
    int[] primes = { 2, 3, 5 };
    int[] times = new int[3];
    int[] r = new int[n];
    r[0] = 1;
    for (int i = 1; i < n; i++) {
      r[i] = Integer.MAX_VALUE;
      for (int j = 0; j < 3; j++)
        r[i] = Math.min(r[i], r[times[j]] * primes[j]);
      for (int j = 0; j < 3; j++)
        if (r[times[j]] * primes[j] == r[i])
          times[j]++;
    }
    return r[n - 1];
  }

}
