package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/integer-break/
 * 
 * @author shivam.maharshi
 */
public class IntegerBreak extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, integerBreak(2));
    assertEquals(2, integerBreak(3));
    assertEquals(4, integerBreak(4));
    assertEquals(6, integerBreak(5));
    assertEquals(9, integerBreak(6));
    assertEquals(12, integerBreak(7));
    assertEquals(18, integerBreak(8));
  }

  public static int integerBreak(int n) {
    if (n == 2)
      return 1;
    if (n == 3)
      return 2;
    if (n == 4)
      return 4;

    if (n % 3 == 2) {
      return (int) Math.pow(3, n / 3) * 2;
    } else if (n % 3 == 1) {
      return (int) Math.pow(3, n / 3 - 1) * 4;
    } else {
      return (int) Math.pow(3, n / 3);
    }
  }

}
