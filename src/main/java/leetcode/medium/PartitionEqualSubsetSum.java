package leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * @author shivam.maharshi
 */
public class PartitionEqualSubsetSum extends TestCase {

  @Test
  public static void test() {
    // assertEquals(false, canPartition(null));
    // assertEquals(false, canPartition(new int[] {}));
    // assertEquals(false, canPartition(new int[] { 1 }));
    // assertEquals(true, canPartition(new int[] { 1, 5, 5, 11 }));
    // assertEquals(false, canPartition(new int[] { 1, 2, 3, 5 }));
    // assertEquals(true, canPartition(new int[] { 1, 2, 3, 6 }));
    // assertEquals(true, canPartition(new int[] { 1, 7, 3, 5 }));
    // assertEquals(true, canPartition(new int[] { 3, 3, 3, 4, 5 }));
    // assertEquals(true,
    // canPartition(new int[] { 89, 49, 21, 31, 74, 56, 34, 23, 35, 15, 74, 59,
    // 75, 47, 16, 81, 1, 32, 42, 75, 4, 3,
    // 54, 55, 95, 65, 10, 90, 15, 23, 19, 30, 24, 91, 3, 84, 11, 76, 6, 96, 78,
    // 84, 58, 80, 28, 96, 11, 46, 36,
    // 84, 3, 14, 32, 86, 67, 8, 60, 70, 65, 57, 63, 15, 61, 79, 66, 55, 92, 44,
    // 62, 76, 19, 52, 59, 72, 2, 60, 75,
    // 52, 37, 100, 1, 92, 1, 40, 11, 68, 61, 22, 88, 70, 50, 82, 81, 39, 80,
    // 75, 67, 31, 3, 55 }));
    assertEquals(false, canPartition(new int[] { 1, 2, 5 }));
  }

  public static boolean canPartition(int[] nums) {
    if (nums == null || nums.length == 0)
      return false;
    int sum = 0;
    for (int n : nums)
      sum += n;
    if (sum % 2 == 1)
      return false;
    Arrays.sort(nums);
    return canSum(nums, sum / 2);
  }

  // Bottom Up DP
  public static boolean canSum(int[] n, int s) {
    Boolean[] dp = new Boolean[20001];
    dp[n[0]] = true;
    for (int i = 1; i < n.length; i++)
      for (int j = dp.length - 1; j > -1; j--)
        if (dp[j] != null && dp[j] == true && n[i] + j < dp.length)
          dp[n[i] + j] = true;
    return dp[s] != null && dp[s] == true;
  }

  // Top Down DP
  public static boolean canSum(int[] n, int s, int i, Boolean[][] dp) {
    if (i >= n.length)
      return false;
    if (n[i] == s)
      return true;
    if (dp[s][i] != null)
      return dp[s][i];
    else if (n[i] < s)
      dp[s][i] = canSum(n, s - n[i], i + 1, dp) || canSum(n, s, i + 1, dp);
    else
      dp[s][i] = canSum(n, s, i + 1, dp);
    return dp[s][i];
  }

}
