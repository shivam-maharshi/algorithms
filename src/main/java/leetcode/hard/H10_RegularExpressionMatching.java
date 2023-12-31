package leetcode.hard;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/regular-expression-matching
 * 
 * @author shivam.maharshi
 */
public class H10_RegularExpressionMatching extends TestCase {

  @Test
  public void test() {
    assertEquals(true, isMatch("abccd", "a*.*d"));
    assertEquals(false, isMatch("abccd", "a*.*c"));
    assertEquals(true, isMatch("a", "a*"));
    assertEquals(true, isMatch("a", "."));
    assertEquals(true, isMatch("a", "a*"));
    //assertEquals(true, isMatch("", "a*"));
    assertEquals(true, isMatch("", ""));
    assertEquals(true, isMatch("abcde", ".*"));
    assertEquals(true, isMatch("abcde", "..*.."));
    assertEquals(true, isMatch("abcde", ".*.*."));
    assertEquals(true, isMatch("abcde", "....."));
    assertEquals(true, isMatch("abcde", "a*b*c*d*e*"));
    assertEquals(false, isMatch("abcde", "a*b*d*e*"));
    assertEquals(true, isMatch("abc", "abcd*"));
    assertEquals(false, isMatch("abcde", "...."));
    assertEquals(true, isMatch("abcde", "....*"));
    assertEquals(false, isMatch("abcde", "....f"));
    assertEquals(true, isMatch("abcdd", "....*"));
    assertEquals(true, isMatch("abcdd", "c*.*"));
  }

  // A valid pattern string cannot start with *.
  // 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
  // 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
  // 3, If p.charAt(j) == '*':
  // 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] - in this case, a* only counts as empty
  // 2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
  // 2.1 dp[i][j] = dp[i-1][j] - in this case, a* counts as multiple a 
  // 2.2 or dp[i][j] = dp[i][j-1] - in this case, a* counts as single a
  // 2.3 or dp[i][j] = dp[i][j-2] - in this case, a* counts as empty
                                 
//  public static boolean isMatch(String s, String p) {
//    if (s == null || p == null) {
//      return false;
//    }
//    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//    dp[0][0] = true;
//    for (int i = 0; i < p.length(); i++) {
//      if (p.charAt(i) == '*' && dp[0][i - 1]) {
//        dp[0][i + 1] = true;
//      }
//    }
//    for (int i = 0; i < s.length(); i++) {
//      for (int j = 0; j < p.length(); j++) {
//        if (p.charAt(j) == '.') {
//          dp[i + 1][j + 1] = dp[i][j];
//        }
//        if (p.charAt(j) == s.charAt(i)) {
//          dp[i + 1][j + 1] = dp[i][j];
//        }
//        if (p.charAt(j) == '*') {
//          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
//            dp[i + 1][j + 1] = dp[i + 1][j - 1];
//          } else {
//            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
//          }
//        }
//      }
//    }
//    return dp[s.length()][p.length()];
//  }
  
  public static boolean isMatch(String s, String p) {
    return isMatchRec(s, p, 0, 0);
  }

  public static boolean isMatchRec(String s, String p, int i, int j) {
    if (i >= s.length() && j >= p.length())
      return true;
    if (i == s.length() || j == p.length())
      return false;
    char sc = s.charAt(i), pc = p.charAt(j);
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      if (sc != pc && pc != '.' && isMatchRec(s, p, i, j + 2))
        return true;
      return sc == pc || pc == '.' ? (isMatchRec(s, p, i + 1, j) || isMatchRec(s, p, i + 1, j + 2) || isMatchRec(s, p, i + 1, j)) : false;
    }
    return sc == pc || pc == '.' ? isMatchRec(s, p, i + 1, j + 1) : false;
  }

}
