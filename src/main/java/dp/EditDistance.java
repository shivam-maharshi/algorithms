package dp;

/**
 * Link:
 * http://www.geeksforgeeks.org/fundamentals-of-algorithms/#DynamicProgramming
 * 
 * Leetcode: https://leetcode.com/problems/edit-distance/
 * 
 * @author shivam.maharshi
 */
public class EditDistance {

  public static void main(String[] args) {
    System.out.println(minDistance("maharshi", "hijab"));
  }

  public static int minDistance(String word1, String word2) {
    if (word1.isEmpty() || word2.isEmpty())
      return word1.isEmpty() ? word2.length() : word1.length();
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        
        if(i==0) {
          dp[i][j] = j;
        } else if (j==0) {
          dp[i][j] = i;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(1 + dp[i - 1][j], Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j - 1]));
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }

}
