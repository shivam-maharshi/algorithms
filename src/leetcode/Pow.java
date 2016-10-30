package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/powx-n/
 * 
 * @author shivam.maharshi
 */
public class Pow extends TestCase {

  @Test
  public static void test() {
    assertEquals(-64.0, myPow(-4, 3));
    assertEquals(0.0, myPow(0, 1));
    assertEquals(64.0, myPow(4, 3));
    assertEquals(1.0, myPow(-4, 0));
    assertEquals(0.04, myPow(-5, -2));
  }

  public static double myPow(double x, int n) {
    return n >= 0 ? pow(x, n) : 1 / pow(x, n);
  }

  public static double pow(double x, int n) {
    if (n == 0)
      return 1;

    if (n == 1)
      return x;

    if (n % 2 == 0) {
      return pow(x * x, n / 2);
    } else {
      return pow(x * x, n / 2) * x;
    }

  }

}
