package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/count-numbers-with-unique-digits
 *
 * @author shivam.maharshi
 */
public class M357_CountNumbersWithUniqueDigits extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, countNumbersWithUniqueDigits(0));
    assertEquals(10, countNumbersWithUniqueDigits(1));
    assertEquals(91, countNumbersWithUniqueDigits(2));
    assertEquals(739, countNumbersWithUniqueDigits(3));
  }

  public static int countNumbersWithUniqueDigits(int n) {
    int r = 1, p = 9, l = 9;
    for (int i = 0; i < n; i++) {
      r += p;
      p *= l;
      l--;
    }
    return r;
  }

}
