package dp;

/**
 * Return the length of the longest common subsequence.
 * 
 * Link: http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-
 * subsequence/
 * 
 * @author shivam.maharshi
 */
public class LongestCommonSubsequence {
  
  public static int get(String a, String b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    for(int i=0; i < a.length(); i++) {
      for(int j=0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j))
          dp[i+1][j+1] = dp[i][j] + 1;
        else
          dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
      }
    }
    return dp[a.length()][b.length()];
  }
  
  public static void main(String[] args) {
    System.out.println(get("AGGTAB", "GXTXAYB"));
  }

}
