package leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/jump-game-ii
 * 
 * @author shivam.maharshi
 */
public class M45_JumpGameII extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, jump(new int[] {}));
    assertEquals(2, jump(new int[] { 2, 3, 1, 1, 4 }));
    assertEquals(4, jump(new int[] { 1, 1, 1, 1, 1 }));
    assertEquals(2, jump(new int[] { 2, 1, 2, 1, 1 }));
    assertEquals(1, jump(new int[] { 4, 1, 1, 1, 1 }));
    assertEquals(4, jump(new int[] { 1, 1, 1, 1, 1 }));
  }

  // O(n^2)
  public static int jump(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 0; i < nums.length; i++)
      for (int j = 1; j <= nums[i] && i + j < dp.length; j++)
        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
    return dp[dp.length - 1];
  }

  /*
   * O(n). This idea is beautiful. At any point of time just maintain what is
   * the max you can go from your current range which was achievable in the cur
   * jumps. Once your've reached the max that you can go with the current jumps,
   * you now need to jump again to come in the new range which will end in the
   * current farthest that you can go.
   */
  public int j(int[] A) {
    int jumps = 0, currentFarthest = 0, currentEnd = 0;
    for (int i = 0; i < A.length - 1; i++) {
      currentFarthest = Math.max(currentFarthest, i + A[i]);
      if (i == currentEnd) {
        jumps++;
        currentEnd = currentFarthest;
      }
    }
    return jumps;
  }

}
