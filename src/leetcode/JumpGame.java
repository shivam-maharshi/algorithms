package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/jump-game/
 * 
 * @author shivam.maharshi
 */
public class JumpGame extends TestCase {

  @Test
  public static void test() {
    assertEquals(true, canJump(new int[] { 2, 3, 1, 1, 4 }));
    assertEquals(false, canJump(new int[] { 3, 2, 1, 0, 4 }));
    assertEquals(true, canJump(new int[] {}));
    assertEquals(true, canJump(new int[] { 0 }));
    assertEquals(true, canJump(new int[] { 1, 0 }));
    assertEquals(true, canJump(new int[] { 3, 0, 0, 2, 0, 1, 0 }));
  }

  public static boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1)
      return true;

    boolean[] dp = new boolean[nums.length];
    dp[0] = true;

    // Must come back otherwise will TLE.
    for (int i = 0; i < nums.length; i++) {
      for (int j = Math.min(i + nums[i], dp.length - 1); j >= i + 1; j--) {
        if (dp[j] == true) {
          break;
        } else {
          dp[j] = true;
        }
      }
    }

    for (int i = 0; i < dp.length; i++)
      if (!dp[i])
        return false;

    return true;
  }

  public static boolean canJumpDp(int[] nums) {
    return cj(nums, 0, new Boolean[nums.length]);
  }

  // This DP will throw Stack Overflow in very big inputs.
  // Hence implement bottom up DP.
  public static boolean cj(int[] nums, int i, Boolean[] dp) {
    if (i >= nums.length - 1)
      return true;

    if (dp[i] != null)
      return dp[i];

    boolean r = false;
    for (int j = 1; j <= nums[i]; j++) {
      r = r || cj(nums, i + j, dp);
      if (r) {
        dp[i] = true;
        return dp[i];
      }
    }

    dp[i] = false;
    return dp[i];
  }

}
