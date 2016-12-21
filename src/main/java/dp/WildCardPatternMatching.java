package dp;

/**
 * Wildcard pattern matching.
 * 
 * Link: http://www.geeksforgeeks.org/wildcard-pattern-matching/
 * 
 * @author shivam.maharshi
 */
public class WildCardPatternMatching {
  
  public static void main(String[] args) {
    System.out.println(match("abc" , "a*?*b?"));
  }

  public static boolean match(String s, String p) {
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    populate(s, p, dp);
    return dp[s.length()][p.length()];
  }

  // Stores if a substring of s from 0-i matches that of p 0-j.
  public static void populate(String s, String p, boolean[][] dp) {
    dp[0][0] = true;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == '*')
          dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
        else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
          dp[i + 1][j + 1] = dp[i][j];
      }
    }
  }

}
