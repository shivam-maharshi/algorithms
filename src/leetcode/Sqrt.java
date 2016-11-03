package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/sqrtx/
 * 
 * @author shivam.maharshi
 */
public class Sqrt extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, mySqrt(0));
    assertEquals(1, mySqrt(1));
    assertEquals(1, mySqrt(2));
    assertEquals(2, mySqrt(4));
    assertEquals(2, mySqrt(8));
    assertEquals(5, mySqrt(25));
    assertEquals((int)Math.sqrt(Integer.MAX_VALUE), mySqrt(Integer.MAX_VALUE));
    assertEquals((int)Math.sqrt(2147395599), mySqrt(2147395599));
  }

  public static int mySqrt(int x) {
    if (x < 1)
      return 0;

    double a = x, b = 1;
    // Tests will fail if not precise results.
    while (a - b > 0.0000000000000001) {
      a = b + (a - b) / 2;
      b = x / a;
    }
    return (int) a;
  }

}
