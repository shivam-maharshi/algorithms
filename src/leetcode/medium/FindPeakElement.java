package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/find-peak-element/
 * 
 * @author shivam.maharshi
 */
public class FindPeakElement extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, findPeakElement(new int[] { 1 }));
    assertEquals(2, findPeakElement(new int[] { 1, 2, 3, 1 }));
    assertEquals(3, findPeakElement(new int[] { 1, 2, 3, 4 }));
    assertEquals(0, findPeakElement(new int[] { 4, 3, 2, 1 }));
    assertEquals(8, findPeakElement(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1 }));
  }

  // O(log(n)): https://www.youtube.com/watch?v=a7D77DdhlFc
  public static int findPeakElement(int[] nums) {
    if (nums.length == 1)
      return 0;
    int l = 0, h = nums.length - 1;
    while (l <= h) {
      int m = (h - l) / 2 + l;
      if (isPeak(nums, m))
        return m;
      else if (nums[m] < nums[m + 1])
        l = m + 1;
      else
        h = m - 1;
    }
    return -1;
  }

  public static boolean isPeak(int[] n, int i) {
    return (i == 0 && n[0] > n[1]) || (i == n.length - 1 && n[i - 1] < n[i]) || (n[i] > n[i + 1] && n[i] > n[i - 1]);
  }

}
