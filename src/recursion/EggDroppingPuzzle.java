package recursion;

/**
 * You have n eggs and k floors, find the minimum number of trials to figure out
 * the egg breaking floor.
 * 
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * 
 * @author shivam.maharshi
 */
public class EggDroppingPuzzle {

  public static void main(String[] args) {
    int n = 2, k = 10;
    System.out.println(get(n, k));
    int[][] dp = new int[n+1][k+1];
    System.out.println(getDP(n, k, dp));
  }

  public static int get(int n, int k) {
    if (n == 1 || k == 0 || k == 1)
      return k;

    int res = Integer.MAX_VALUE;

    for (int i = 1; i <= k; i++) {
      res = Math.min(res, Math.max(get(n - 1, i - 1), get(n, k - i)));
    }

    return res + 1;
  }

  // Top down DP using internal recursive stacks.
  public static int getDP(int n, int k, int[][] dp) {
    if (n == 1 || k == 0 || k == 1)
      return k;

    if (dp[n][k] != 0)
      return dp[n][k];

    int res = Integer.MAX_VALUE;

    for (int i = 1; i <= k; i++) {
      res = Math.min(res, Math.max(get(n - 1, i - 1), get(n, k - i)));
    }

    dp[n][k] = res + 1;

    return dp[n][k];
  }

}
