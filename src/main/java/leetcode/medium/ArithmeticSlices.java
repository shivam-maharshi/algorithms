package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/arithmetic-slices/
 * 
 * @author shivam.maharshi
 */
public class ArithmeticSlices extends TestCase {

  @Test
  public static void test() {
    assertEquals(3, numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    assertEquals(9, numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 8, 10, 7, 4, 1}));
    assertEquals(0, numberOfArithmeticSlices(new int[]{1, 2}));
    assertEquals(0, numberOfArithmeticSlices(new int[]{1}));
    assertEquals(0, numberOfArithmeticSlices(new int[]{}));
    assertEquals(0, numberOfArithmeticSlices(new int[]{1, 2, 4, 7}));
    assertEquals(1, numberOfArithmeticSlices(new int[]{1, 3, 4, 6, 8}));
  }

  public static int numberOfArithmeticSlices(int[] a) {
    if (a == null || a.length <= 2)
      return 0;
    int r = 0, l = 0, h = 1, diff = a[h] - a[l];
    for (int i = 2; i < a.length; i++) {
      if (diff != a[i] - a[i - 1]) {
        r += getCount(l, h);
        diff = a[i] - a[i - 1];
        l = i - 1;
        h = i;
      } else {
        h = i;
      }
    }
    return r + getCount(l, h);
  }

  // Get slices of 3 or more consecutive.
  public static int getCount(int l, int h) {
    if (h - l < 2)
      return 0;

    int r = 0;
    for (int i = 3; i <= h - l + 1; i++)
      r += h - l + 1 - i + 1;

    return r;
  }

}
