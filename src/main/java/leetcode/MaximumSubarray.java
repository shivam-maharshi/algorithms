package leetcode;

/**
 * Link: https://leetcode.com/problems/maximum-subarray/
 * 
 * @author shivam.maharshi
 */
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int res = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      res = Math.max(res, sum);
      if (sum < 0)
        sum = 0;
    }
    return res;
  }

}
