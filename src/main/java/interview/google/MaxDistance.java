package interview.google;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/max-distance/
 * Link: http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * 
 * @author shivam.maharshi
 */
public class MaxDistance extends TestCase {

  @Test
  public static void test() {
    assertEquals(4, maximumGap(Arrays.asList(new Integer[] {10, 8, 12, 7, 5, 6, 4, 8})));
    assertEquals(6, maximumGap(Arrays.asList(new Integer[] {34, 8, 10, 3, 2, 80, 30, 33, 1})));
    assertEquals(8, maximumGap(Arrays.asList(new Integer[] {9, 2, 3, 4, 5, 6, 7, 8, 18, 0})));
    assertEquals(-1, maximumGap(Arrays.asList(new Integer[] {6, 5, 4, 3, 2, 1})));
  }

  public static int maximumGap(final List<Integer> a) {
    if (a == null || a.size() == 0)
      return -1;
    int[] lmin = new int[a.size()], rmax = new int[a.size()];
    lmin[0] = a.get(0);
    rmax[a.size() - 1] = a.get(a.size() - 1);
    for (int i = 1; i < a.size(); i++) {
      lmin[i] = Math.min(lmin[i - 1], a.get(i));
      rmax[a.size() - 1 - i] = Math.max(rmax[a.size() - i], a.get(a.size() - 1 - i));
    }
    int l = 0, h = 1, r = -1;
    while (h < a.size() && l < a.size()) {
      if (lmin[l] <= rmax[h]) {
        r = Math.max(r, h - l);
        h++;
      } else
        l++;
    }
    return r;
  }

}
