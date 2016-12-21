package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/valid-perfect-square/
 * 
 * @author shivam.maharshi
 */
public class ValidPerfectSquare extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, roundAroundMid(0.5));
    assertEquals(0, roundAroundMid(0.49));
    assertEquals(1, roundAroundMid(0.99));
    assertEquals(0, roundAroundMid(0.01));
    assertEquals(false, isPerfectSquare(-1));
    // Zero isn't considered a perfect square.
    assertEquals(false, isPerfectSquare(0));
    assertEquals(true, isPerfectSquare(1));
    assertEquals(false, isPerfectSquare(2));
    assertEquals(false, isPerfectSquare(3));
    assertEquals(true, isPerfectSquare(4));
    assertEquals(false, isPerfectSquare(5));
    assertEquals(false, isPerfectSquare(6));
    assertEquals(false, isPerfectSquare(7));
    assertEquals(false, isPerfectSquare(8));
    assertEquals(true, isPerfectSquare(9));
    assertEquals(false, isPerfectSquare(50));
    assertEquals(false, isPerfectSquare(99));
    assertEquals(true, isPerfectSquare(100));
  }

  public static boolean isPerfectSquare(int num) {
    if (num < 1)
      return false;
    double x = 0, y = num, m = (y - x) / 2 + x;
    while (Math.abs((m * m) - num) > 0.00001) {
      if (m * m > num)
        y = m;
      else
        x = m;
      m = (y - x) / 2 + x;
    }
    return roundAroundMid(m) * roundAroundMid(m) == num;
  }

  public static int roundAroundMid(double m) {
    return ((int) (m * 2 + 1) / 2);
  }

}
