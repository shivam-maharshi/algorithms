package leetcode.hard;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author shivam.maharshi
 */
public class SearchInRotatedSortedArray extends TestCase {

  @Test
  public static void test() {
    assertEquals(-1, search(null, 1));
    assertEquals(-1, search(new int[] {}, 1));
    assertEquals(-1, search(new int[] { 1 }, 2));
    assertEquals(0, search(new int[] { 1 }, 1));
    assertEquals(-1, search(new int[] { 1, 2 }, 3));
    assertEquals(0, search(new int[] { 1, 2 }, 1));
    assertEquals(1, search(new int[] { 1, 2 }, 2));
    assertEquals(-1, search(new int[] { 2, 1 }, 3));
    assertEquals(1, search(new int[] { 2, 1 }, 1));
    assertEquals(0, search(new int[] { 2, 1 }, 2));
    assertEquals(-1, search(new int[] { 3, 1, 2 }, 4));
    assertEquals(1, search(new int[] { 3, 1, 2 }, 1));
    assertEquals(2, search(new int[] { 3, 1, 2 }, 2));
    assertEquals(0, search(new int[] { 3, 1, 2 }, 3));
    assertEquals(-1, search(new int[] { 2, 3, 4, 1 }, 0));
    assertEquals(3, search(new int[] { 2, 3, 4, 1 }, 1));
    assertEquals(0, search(new int[] { 2, 3, 4, 1 }, 2));
    assertEquals(1, search(new int[] { 2, 3, 4, 1 }, 3));
    assertEquals(2, search(new int[] { 2, 3, 4, 1 }, 4));
    assertEquals(-1, search(new int[] { 1, 2, 3, 4 }, 0));
    assertEquals(0, search(new int[] { 1, 2, 3, 4 }, 1));
    assertEquals(1, search(new int[] { 1, 2, 3, 4 }, 2));
    assertEquals(2, search(new int[] { 1, 2, 3, 4 }, 3));
    assertEquals(3, search(new int[] { 1, 2, 3, 4 }, 4));
  }

  public static int search(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return -1;
    int i = bs(nums, target, 0, nums.length - 1);
    return nums[i] == target ? i : -1;
  }

  public static int bs(int[] a, int n, int l, int h) {
    if (l >= h)
      return l;
    int m = ((h - l) / 2) + l;
    if (a[m] == n)
      return m;

    if (a[m] < a[h]) {
      // Right series is strictly increasing.
      if (n > a[m]) {
        if (n <= a[h])
          return bs(a, n, m + 1, h);
        else
          return bs(a, n, l, m - 1);
      } else
        return bs(a, n, l, m - 1);
    } else {
      // Left series is strictly increasing.
      if (n < a[m]) {
        if (n >= a[l])
          return bs(a, n, l, m - 1);
        else
          return bs(a, n, m + 1, h);
      } else
        return bs(a, n, m + 1, h);
    }
  }

}
