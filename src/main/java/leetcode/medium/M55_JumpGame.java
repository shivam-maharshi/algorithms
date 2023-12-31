package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/jump-game
 * 
 * @author shivam.maharshi
 */
public class M55_JumpGame extends TestCase {

  @Test
  public void test() {
    assertEquals(true, canJump(new int[]{2}));
    assertEquals(true, canJump(new int[]{2,3}));
    assertEquals(false, canJump(new int[]{0,1}));
    assertEquals(true, canJump(new int[]{2,3,1,1,4}));
    assertEquals(false, canJump(new int[]{3,2,1,0,4}));
  }

  public static boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1)
      return true;
    int last = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--)
      if (i + nums[i] >= last)
        last = i;
    return last == 0;
  }

}
