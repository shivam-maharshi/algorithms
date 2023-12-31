package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/bitwise-and-of-numbers-range
 * 
 * @author shivam.maharshi
 */
public class M201_BitwiseAndOfNumbersRange extends TestCase {

  @Test
  public static void test() {
    assertEquals(5, rangeBitwiseAnd(5, 5));
    assertEquals(4, rangeBitwiseAnd(5, 7));
    assertEquals(10231880, rangeBitwiseAnd(10231881, 10231882));
  }

  public static int rangeBitwiseAnd(int m, int n) {
    int diff = m ^ n, maskBits = 0;
    while (diff > 0) {
      diff = diff>>1;
      maskBits++;
    }
    int mask = (Integer.MAX_VALUE >> maskBits) << maskBits;
    return n & mask;
  }

}
