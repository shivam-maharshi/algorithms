package interview.amazon;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Given an array of coins of same weight, find the single heavier coin.
 * 
 * @author shivam.maharshi
 */
public class FindHeavyCoin extends TestCase {

  @Test
  public void test() {
    assertEquals(1, find(new int[] { 5, 8 }));
    assertEquals(0, find(new int[] { 8, 5 }));
    assertEquals(0, find(new int[] { 8, 5, 5 }));
    assertEquals(1, find(new int[] { 5, 8, 5 }));
    assertEquals(2, find(new int[] { 5, 5, 8 }));
    assertEquals(3, find(new int[] { 5, 5, 5, 8 }));
    assertEquals(2, find(new int[] { 5, 5, 8, 5 }));
    assertEquals(1, find(new int[] { 5, 8, 5, 5 }));
    assertEquals(0, find(new int[] { 8, 5, 5, 5 }));
    assertEquals(2, find(new int[] { 5, 5, 8, 5, 5, 5, 5, 5, 5, 5, 5 }));
    assertEquals(0, find(new int[] { 8, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
    assertEquals(10, find(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 8 }));
    assertEquals(2, find(new int[] { 5, 5, 8, 5, 5, 5, 5, 5, 5, 5 }));
    assertEquals(0, find(new int[] { 8, 5, 5, 5, 5, 5, 5, 5, 5, 5 }));
    assertEquals(9, find(new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 8 }));
  }

  public static int find(int[] a) {
    if (a == null || a.length == 0 || a.length == 1)
      return -1;
    int l = 0, h = a.length - 1;
    while (h > l) {
      if (h - l == 1)
        return a[l] > a[h] ? l : h;
      int m = ((h - l) / 2) + l, ls = 0, hs = 0;
      ls = (h - l + 1) % 2 == 1 ? getSum(a, l, m - 1) : getSum(a, l, m);
      hs = getSum(a, m + 1, h);
      if (ls == hs)
        return m;
      if (ls < hs)
        l = m + 1;
      else
        h = (h - l + 1) % 2 == 1 ? m - 1 : m;
    }
    return l;
  }

  public static int getSum(int[] a, int l, int h) {
    int r = 0;
    for (int i = l; i <= h; i++)
      r += a[i];
    return r;
  }

}
