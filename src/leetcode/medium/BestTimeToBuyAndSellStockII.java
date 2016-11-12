package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author shivam.maharshi
 */
public class BestTimeToBuyAndSellStockII {

  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
      return 0;
    int r = 0;
    for (int i = 0; i < prices.length - 1; i++)
      r += prices[i + 1] - prices[i] > 0 ? prices[i + 1] - prices[i] : 0;  
    return r;
  }

}
