package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/wiggle-subsequence
 * 
 * @author shivam.maharshi
 */
public class M376_WiggleSubsequence extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, wiggleMaxLength(null));
    assertEquals(0, wiggleMaxLength(new int[] {}));
    assertEquals(1, wiggleMaxLength(new int[] { 0 }));
    assertEquals(1, wiggleMaxLength(new int[] { 0, 0 }));
    assertEquals(6, wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
    assertEquals(7, wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
    assertEquals(2, wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  // O(n)
  public static int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    return Math.max(getMax(nums, true), getMax(nums, false));
  }

  public static int getMax(int[] nums, boolean h) {
    List<Integer> l = new ArrayList<>();
    l.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if ((h && nums[i] > l.get(l.size() - 1)) || (!h && nums[i] < l.get(l.size() - 1))) {
        l.add(nums[i]);
        h = !h;
      } else
        l.set(l.size() - 1, nums[i]);
    }
    return l.size();
  }

  // Bottom UP DP - O(n^2)
  public static int wiggleMaxLength1(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int[] dp = new int[nums.length];
    dp[0] = 1;
    Boolean[] h = new Boolean[nums.length];
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if ((nums[i] > nums[j] && (h[j] == null || h[j] == false))
            || (nums[i] < nums[j] && (h[j] == null || h[j] == true))) {
          if (dp[i] == dp[j] + 1 && h[i] == h[j])
            h[i] = null;
          else if (dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
            h[i] = nums[i] > nums[j];
          }
        }
      }
    }
    int r = 0;
    for (int n : dp)
      r = Math.max(r, n);
    return r;
  }

}
