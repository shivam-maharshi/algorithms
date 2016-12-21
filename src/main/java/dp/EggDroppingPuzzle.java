package dp;

import java.util.Arrays;

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
    System.out.println(get(2, 10));
  }

  public static int get(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i < dp.length; i++)
      Arrays.fill(dp[i], Integer.MAX_VALUE);

    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = 0;
      dp[i][1] = 1;
    }

    for (int j = 1; j < k + 1; j++)
      dp[1][j] = j;

    for (int i = 2; i < n + 1; i++) {
      for (int j = 2; j < k + 1; j++) {
        for (int x = 1; x <= j; x++) {
          dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]));
        }
      }
    }

    return dp[n][k];
  }

}
