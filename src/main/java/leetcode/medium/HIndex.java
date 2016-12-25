package leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/h-index/
 * 
 * @author shivam.maharshi
 */
public class HIndex extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, hIndex(new int[] {}));
    assertEquals(1, hIndex(new int[] { 1 }));
    assertEquals(1, hIndex(new int[] { 100 }));
    assertEquals(1, hIndex(new int[] { 0, 1 }));
    assertEquals(1, hIndex(new int[] { 1, 1 }));
    assertEquals(0, hIndex(new int[] { 0, 0, 0, 0, 0, 0, 0 }));
    assertEquals(1, hIndex(new int[] { 1, 1, 1, 1, 1, 1, 1 }));
    assertEquals(3, hIndex(new int[] { 3, 0, 6, 1, 5 }));
    assertEquals(4, hIndex(new int[] { 1, 1, 1, 1, 1, 9, 9, 9, 9 }));
    assertEquals(2, hIndex(new int[] { 1, 2, 3 }));
    assertEquals(9, hIndex(new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9 }));
  }

  public static int hIndex(int[] citations) {
    if (citations == null || citations.length == 0)
      return 0;
    Arrays.sort(citations);
    int i = bs(citations, 0, citations.length - 1);
    return citations.length - i;
  }

  public static int bs(int[] n, int l, int h) {
    if (l > h)
      return l;
    int m = ((h - l) / 2) + l;
    if (n[m] < n.length - m)
      return bs(n, m + 1, h);
    else
      return bs(n, l, m - 1);
  }

}
