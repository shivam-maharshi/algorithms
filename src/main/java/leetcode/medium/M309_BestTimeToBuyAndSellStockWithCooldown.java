package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 
 * @author shivam.maharshi
 */
public class M309_BestTimeToBuyAndSellStockWithCooldown extends TestCase {

  @Test
  public static void test() {
    assertEquals(3, maxProfit(new int[] { 1, 2, 3, 0, 2 }));
  }

  public static int maxProfit(int[] prices) {
    return maxProfit(prices, 0);
  }

  public static int maxProfitDP(int[] prices, int index) {
    int[] dp = new int[prices.length];
    dp[0] = 0;
    dp[1] = Math.max(0, dp[1] - dp[0]);
    for (int i = 2; i < prices.length; i++) {
      for (int j = 0; j < i-1; j++) {
        
      }
    }
    return dp[prices.length - 1];
  }

  public static int maxProfit(int[] prices, int index) {
    if (index >= prices.length)
      return 0;

    int p = 0;

    for (int i = index + 1; i < prices.length; i++)
      p = Math.max(p, Math.max(prices[i] - prices[index] + maxProfit(prices, i + 2), maxProfit(prices, i + 1)));

    return p;
  }

}
