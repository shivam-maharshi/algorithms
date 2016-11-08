package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 * 
 * @author shivam.maharshi
 */
public class MaximumProductSubarray extends TestCase {

  @Test
  public static void test() {
    assertEquals(6, maxProduct(new int[] { 2, 3, -2, 4 }));
    assertEquals(32, maxProduct(new int[] { -2, -2, -2, -4 }));
    assertEquals(32, maxProduct(new int[] { 2, -2, -2, 4 }));
    assertEquals(12, maxProduct(new int[] { 2, 2, -4, 3, 2, 2 }));
    assertEquals(24, maxProduct(new int[] { -2, 2, 1, 3, 2, 2 }));
    assertEquals(4, maxProduct(new int[] { -2, -2 }));
    assertEquals(2, maxProduct(new int[] { -2, 2 }));
    assertEquals(4, maxProduct(new int[] { -2, -2 }));
    assertEquals(-2, maxProduct(new int[] { -2 }));
    assertEquals(0, maxProduct(new int[] {}));
    assertEquals(2, maxProduct(new int[] { 0, 2 }));
    assertEquals(4, maxProduct(new int[] { -2, 0, 1, -3, 2, 2 }));
    assertEquals(24, maxProduct(new int[] { 0, -2, 1, 3, 2, -2 }));
    assertEquals(0, maxProduct(new int[] { 0 }));
    assertEquals(0, maxProduct(new int[] { -2, 0, -2 }));
    assertEquals(4, maxProduct(new int[] { -2, -2, 0, -2 }));
    assertEquals(4, maxProduct(new int[] { 2, 2, 1, -2 }));
    assertEquals(8, maxProduct(new int[] { 2, 0, 2, 1, 4, 0, 2, 1, -2, 0 }));
    assertEquals(8, maxProduct(new int[] { 2, 0, 2, -1, 4, -1, 0, 2, 1, -2, 0 }));
    assertEquals(16, maxProduct(new int[] { 2, 0, 2, -1, 4, -1, 0, 2, 8, -2, 0 }));
    assertEquals(16, maxProduct(new int[] { 2, 0, 2, -1, 4, -1, 0, 2, 4, -0, 16, -2, 0 }));
  }

  public static int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    if (nums.length == 1)
      return nums[0];

    int i = 0;

    while (nums[i] == 0)
      i++;

    int res = i == 0 ? Integer.MIN_VALUE : 0;

    for (int j = i; j < nums.length; j++) {
      if (nums[j] == 0) {
        res = Math.max(res, 0);
        res = Math.max(res, mp(nums, i, j - 1));
        i = j + 1;
      }
    }

    res = Math.max(res, mp(nums, i, nums.length - 1));

    return res;
  }

  public static int mp(int[] a, int l, int h) {
    if (h < l || l >= a.length)
      return Integer.MIN_VALUE;

    if (h == l)
      return a[h];

    int nc = 0, fn = Integer.MIN_VALUE, ln = Integer.MAX_VALUE;

    for (int i = l; i <= h; i++)
      if (a[i] < 0) {
        nc++;
        if (fn == Integer.MIN_VALUE)
          fn = i;
        else
          ln = i;
      }

    int r = Integer.MIN_VALUE;
    if (nc % 2 == 0) {
      int t = a[l];
      for (int i = l + 1; i <= h; i++)
        t *= a[i];
      r = Math.max(r, t);
    } else {

      if (ln == Integer.MAX_VALUE)
        ln = fn;

      int t = a[l];
      for (int i = l + 1; i < ln; i++)
        t *= a[i];

      r = Math.max(r, t);

      if (fn + 1 < a.length) {
        t = a[fn + 1];
        for (int i = fn + 2; i <= h; i++)
          t *= a[i];
        r = Math.max(r, t);

      }
    }
    return r;
  }

}
