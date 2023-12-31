package leetcode.medium;

import java.util.Arrays;

/**
 * Link: https://leetcode.com/problems/coin-change
 * 
 * @author shivam.maharshi
 */
public class M322_CoinChange {

  public static int coinChange(int[] coins, int amount) {
    if(coins.length==0)
      return -1;
    int[] cc = new int[amount + 1];
    Arrays.fill(cc, Integer.MAX_VALUE - 1);
    cc[0] = 0;
    for ( int j=0; j <coins.length; j++) {
      for ( int i=1; i<=amount; i++) {
        if ((i >=  coins[j] )) {
          cc[i] = Math.min(cc[i], 1 + cc[i - coins[j]]);
        }
      }
    }
    return cc[amount] == Integer.MAX_VALUE - 1 ? -1 : cc[amount];
  }

  public static void main(String[] args) {
    int[] a = { 186, 419, 83, 408 };
    System.out.println(coinChange(a, 6249));
  }

}
