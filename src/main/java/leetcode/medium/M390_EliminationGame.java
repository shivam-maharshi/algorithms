package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/elimination-game
 * 
 * @author shivam.maharshi
 */
public class M390_EliminationGame extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, lastRemaining(1));
    assertEquals(2, lastRemaining(2));
    assertEquals(2, lastRemaining(3));
    assertEquals(2, lastRemaining(4));
    assertEquals(2, lastRemaining(5));
    assertEquals(4, lastRemaining(6));
    assertEquals(4, lastRemaining(7));
    assertEquals(6, lastRemaining(8));
    assertEquals(6, lastRemaining(9));
  }

  public static int lastRemaining(int n) {
    int s = 1, c = 1, size = n;
    boolean toRight = true;
    while (size > 1) {
      if (toRight) {
        s += c;
      } else {
        if (size % 2 == 1)
          s += c;
      }
      size /= 2;
      c *= 2;
      toRight = !toRight;
    }
    return s;
  }

}
