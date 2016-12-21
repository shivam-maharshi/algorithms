package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 * @author shivam.maharshi
 */
public class FindMinimumInRotatedSortedArray extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, findMin(new int[] { 0 }));
    assertEquals(0, findMin(new int[] { 0, 1 }));
    assertEquals(0, findMin(new int[] { 1, 0 }));
    assertEquals(0, findMin(new int[] { 0, 1, 2, 4, 5, 6, 7 }));
    assertEquals(0, findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
    assertEquals(0, findMin(new int[] { 1, 2, 4, 5, 6, 7, 0 }));
    assertEquals(0, findMin(new int[] { 7, 0, 1, 2, 4, 5, 6 }));
  }

  public static int findMin(int[] nums) {
    return findMin(nums, 0, nums.length - 1);
  }

  private static int findMin(int[] a, int l, int h) {
    if (l == h || h == l + 1)
      return Math.min(a[l], a[h]);
    int m = (h - l) / 2 + l;
    if (a[m] > a[m + 1])
      return a[m + 1];
    else
      return a[m] > a[h] ? findMin(a, m, h) : findMin(a, l, m);
  }

}
