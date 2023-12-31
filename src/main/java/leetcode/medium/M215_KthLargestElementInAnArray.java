package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array
 * 
 * @author shivam.maharshi
 */
public class M215_KthLargestElementInAnArray extends TestCase {

  @Test
  public static void test() {
    assertEquals(-1, findKthLargest(new int[] {}, 1));
    assertEquals(3, findKthLargest(new int[] { 3 }, 1));
    assertEquals(3, findKthLargest(new int[] { 3, 3 }, 1));
    assertEquals(5, findKthLargest(new int[] { 3, 1, 4, 2, 5 }, 1));
    assertEquals(4, findKthLargest(new int[] { 3, 1, 4, 2, 5 }, 2));
    assertEquals(3, findKthLargest(new int[] { 3, 1, 4, 2, 5 }, 3));
    assertEquals(2, findKthLargest(new int[] { 3, 1, 4, 2, 5 }, 4));
    assertEquals(1, findKthLargest(new int[] { 3, 1, 4, 2, 5 }, 5));
  }

  public static int findKthLargest(int[] nums, int k) {
    return nums == null || nums.length == 0 ? -1 : find(nums, 0, nums.length - 1, nums.length - k);
  }

  public static int find(int[] a, int l, int h, int k) {
    int p = quickSort(a, l, h);
    if (p == k)
      return a[p];
    else if (p < k)
      return find(a, p + 1, h, k);
    else
      return find(a, l, p - 1, k);
  }

  // Mid element as pivot
  private static int quickSort(int[] a, int l, int h) {
    int m = a[((h - l) / 2) + l], i = l, j = h;
    while (i < j) {
      if (a[i] < m)
        i++;
      else if (a[j] > m)
        j--;
      else {
        swap(a, i, j);
        i++;
        j--;
      }
    }
    return i;
  }

  private static void swap(int[] a, int l, int h) {
    int t = a[h];
    a[h] = a[l];
    a[l] = t;
  }

}
