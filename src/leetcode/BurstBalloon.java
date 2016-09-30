package leetcode;

/**
 * Link: https://leetcode.com/problems/burst-balloons/
 * 
 * @author shivam.maharshi
 */
public class BurstBalloon {

  public static void main(String[] args) {
    int[] a = {};
    System.out.println(maxCoins(a));
  }

  public static int maxCoins(int[] nums) {
    if (nums==null || nums.length==0)
      return 0;
    int[][] dp = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i][i] = prod(nums, i - 1, i, i + 1);
    }

    for (int sublen = 1; sublen < nums.length; sublen++) {
      int i = 0;
      while (i + sublen < nums.length) {
        dp[i][i + sublen] = maxCoins(nums, dp, i, i + sublen);
        i++;
      }
    }

    return dp[0][nums.length - 1];
  }

  public static int maxCoins(int[] a, int[][] dp, int l, int h) {
    int max = 0;
    for (int i = l; i <= h; i++) {
      int prod = prod(a, l - 1, i, h + 1);
      if (i == l)
        max = Math.max(max, prod + dp[l + 1][h]);
      else if (i == h)
        max = Math.max(max, prod + dp[l][h - 1]);
      else
        max = Math.max(max, prod + dp[l][i - 1] + dp[i + 1][h]);
    }
    return max;
  }

  public static int prod(int[] a, int l, int i, int h) {
    int p = 1;
    if (l >= 0 && l < a.length)
      p *= a[l];
    if (h >= 0 && h < a.length)
      p *= a[h];
    if (i >= 0 && i < a.length)
      p *= a[i];

    return p;
  }

}
