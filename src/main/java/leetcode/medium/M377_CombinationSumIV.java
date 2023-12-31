package leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/combination-sum-iv
 * 
 * @author shivam.maharshi
 */
public class M377_CombinationSumIV extends TestCase {

  @Test
  public static void test() {
    assertEquals(7, combinationSum4(new int[] { 1, 2, 3 }, 4));
    assertEquals(0, combinationSum4(new int[] { 10, 20, 30 }, 4));
    assertEquals(1, combinationSum4(new int[] { 4 }, 4));
    assertEquals(1, combinationSum4(new int[] { 4 }, 4));
    assertEquals(181997601, combinationSum4(new int[] { 1, 2, 3 }, 32));
  }

  public static int combinationSum4(int[] nums, int target) {
    if(nums.length==0)
      return 0;
    Arrays.sort(nums);
    int[][] dp = new int[nums.length][target + 1];
    for (int[] d : dp)
      Arrays.fill(d, -1);
    return count(nums, 0, target, dp);
  }

  private static int count(int[] nums, int i, int t, int[][] dp) {
    if (t == 0)
      return 1;
    if (dp[i][t] != -1)
      return dp[i][t];
    int r = 0;
    for (int j = i; j < nums.length; j++) {
      if (nums[j] <= t)
        r += count(nums, i, t - nums[j], dp);
      else
        break;
    }
    dp[i][t] = r;
    return r;
  }

}
