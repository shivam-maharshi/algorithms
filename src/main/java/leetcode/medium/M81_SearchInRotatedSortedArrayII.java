package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 * 
 * @author shivam.maharshi
 */
public class M81_SearchInRotatedSortedArrayII extends TestCase {

  @Test
  public void test() {
    assertEquals(false, search(null, 1));
    assertEquals(false, search(new int[] {}, 1));
    assertEquals(false, search(new int[] { 1 }, 2));
    assertEquals(true, search(new int[] { 1 }, 1));
    assertEquals(false, search(new int[] { 1, 2 }, 3));
    assertEquals(true, search(new int[] { 1, 2 }, 1));
    assertEquals(true, search(new int[] { 1, 2 }, 2));
    assertEquals(false, search(new int[] { 2, 1 }, 3));
    assertEquals(true, search(new int[] { 2, 1 }, 1));
    assertEquals(true, search(new int[] { 2, 1 }, 2));
    assertEquals(false, search(new int[] { 3, 1, 2 }, 4));
    assertEquals(true, search(new int[] { 3, 1, 2 }, 1));
    assertEquals(true, search(new int[] { 3, 1, 2 }, 2));
    assertEquals(true, search(new int[] { 3, 1, 2 }, 3));
    assertEquals(false, search(new int[] { 2, 3, 4, 1 }, 0));
    assertEquals(true, search(new int[] { 2, 3, 4, 1 }, 1));
    assertEquals(true, search(new int[] { 2, 3, 4, 1 }, 2));
    assertEquals(true, search(new int[] { 2, 3, 4, 1 }, 3));
    assertEquals(true, search(new int[] { 2, 3, 4, 1 }, 4));
    assertEquals(false, search(new int[] { 1, 2, 3, 4 }, 0));
    assertEquals(true, search(new int[] { 1, 2, 3, 4 }, 1));
    assertEquals(true, search(new int[] { 1, 2, 3, 4 }, 2));
    assertEquals(true, search(new int[] { 1, 2, 3, 4 }, 3));
    assertEquals(true, search(new int[] { 1, 2, 3, 4 }, 4));
    assertEquals(true, search(new int[] { 1, 1, 1, 1 }, 1));
    assertEquals(true, search(new int[] { 0, 0, 1, 1 }, 1));
    assertEquals(true, search(new int[] { 1, 1, 0, 0 }, 1));
    assertEquals(false, search(new int[] { 0, 0, 0, 0 }, 1));
    assertEquals(false, search(new int[] { 1, 1, 0, 0 }, 2));
    assertEquals(true, search(new int[] { 3, 1, 1 }, 3));
    assertEquals(true, search(new int[] { 3, 5, 3 }, 3));
  }

  public static boolean search(int[] nums, int target) {
    return nums == null || nums.length == 0 ? false : bs(nums, target, 0, nums.length - 1);
  }

  public static boolean bs(int[] a, int n, int l, int h) {
    if (l > h)
      return false;
    int m = ((h - l) / 2) + l;
    if (a[m] == n)
      return true;
    if (a[m] < a[h]) {
      // Right series is strictly increasing or same.
      if (n > a[m]) {
        if (n <= a[h])
          return bs(a, n, m + 1, h);
        else
          return bs(a, n, l, m - 1);
      } else
        return bs(a, n, l, m - 1);
    } else if (a[m] > a[h]) {
      // Left series is strictly increasing.
      if (n < a[m]) {
        if (n >= a[l])
          return bs(a, n, l, m - 1);
        else
          return bs(a, n, m + 1, h);
      } else
        return bs(a, n, m + 1, h);
    } else
      return bs(a, n, l, m - 1) || bs(a, n, m + 1, h);
  }

}
