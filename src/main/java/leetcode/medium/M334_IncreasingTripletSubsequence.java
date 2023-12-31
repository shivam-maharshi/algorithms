package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/increasing-triplet-subsequence
 * 
 * @author shivam.maharshi
 */
public class M334_IncreasingTripletSubsequence extends TestCase {

  @Test
  public void test() {
    assertEquals(false, increasingTriplet(new int[]{0,4,2,1,0,-1,-3}));
    assertEquals(true, increasingTriplet(new int[]{1,2,3,4,5}));
    assertEquals(false, increasingTriplet(new int[]{5,4,3,2,1}));
    assertEquals(false, increasingTriplet(new int[]{9,10,4,5,1,2}));
    assertEquals(true, increasingTriplet(new int[]{9,10,4,5,1,2,11}));
    assertEquals(false, increasingTriplet(new int[]{}));
    assertEquals(false, increasingTriplet(new int[]{9}));
    assertEquals(false, increasingTriplet(new int[]{9,10}));
    assertEquals(false, increasingTriplet(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
  }

  public static boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length < 3)
      return false;
    int max1 = nums[0], max2 = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < max1)
        max1 = nums[i];
      else if (nums[i] > max1 && nums[i] <= max2) {
        max2 = nums[i];
      } else if (nums[i] > max2) {
        return true;
      }
    }
    return false;
  }

}
