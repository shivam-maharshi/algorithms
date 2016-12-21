package dp;

/**
 * Find the longest palindromic subsequence.
 * 
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * 
 * @author shivam.maharshi
 */
public class LongestPalindromicSubsequence {
  
  public static void main(String[] args) {
    System.out.println(lps("bbabcbcab")); // babcbab
  }

  public static int lps(String s) {
    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++)
      dp[i][i] = 1;

    for (int len = 1; len < s.length(); len++) {
      for (int i = 0; i + len < s.length(); i++) {
        dp[i][i + len] = Math.max(dp[i + 1][i + len], dp[i][i + len - 1]);
        if (s.charAt(i) == s.charAt(i + len))
          dp[i][i + len] = Math.max(dp[i][i + len], 2 + dp[i + 1][i + len - 1]);
      }
    }

    return dp[0][s.length() - 1];
  }

}
