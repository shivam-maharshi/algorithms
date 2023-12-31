package leetcode.hard;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/patching-array
 * 
 * @author shivam.maharshi
 */
public class H330_PatchingArray extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, minPatches(new int[] { 1, 3 }, 6));
    assertEquals(2, minPatches(new int[] { 1, 5, 10 }, 20));
  }

  public static int minPatches(int[] nums, int n) {
    int r = 0, i = 0;
    long miss = 1;
    while (miss <= n) {
      if (i < nums.length && nums[i] <= miss) {
        miss += nums[i];
        i++;
      } else {
        miss += miss;
        r++;
      }
    }
    return r;
  }

}
