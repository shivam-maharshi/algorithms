package interview.google;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3053
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1] - 1, nums[i]);
        }
        for (int i=0; i<nums.length-1; i++) {
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }

}
