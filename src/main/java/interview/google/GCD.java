package interview.google;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/greatest-common-divisor/
 * 
 * @author shivam.maharshi
 */
public class GCD extends TestCase {

  @Test
  public void test() {
    assertEquals(0, gcd(2, 0));
    assertEquals(2, gcd(2, 2));
    assertEquals(2, gcd(2, 4));
    assertEquals(4, gcd(4, 8));
    assertEquals(3, gcd(6, 9));
  }

  public static int gcd(int a, int b) {
    int max = Math.max(a, b), min = Math.min(a, b);
    if (min == 0)
      return max;
    while (max % min != 0) {
      max = max - min;
      if (max < min) {
        int t = min;
        min = max;
        max = t;
      }
    }
    return min;
  }

}
