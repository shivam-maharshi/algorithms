package leetcode.easy;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/is-subsequence
 * 
 * @author shivam.maharshi
 */
public class E392_IsSubsequence extends TestCase {

  @Test
  public static void test() {
    assertEquals(true, isSubsequence("abc", "ahbgdc"));
    assertEquals(false, isSubsequence("axc", "ahbgdc"));
    assertEquals(true, isSubsequence("", ""));
    assertEquals(true, isSubsequence(null, null));
    assertEquals(true, isSubsequence("", "s"));
    assertEquals(true, isSubsequence(null, "s")); 
    assertEquals(true, isSubsequence("ahbgdc", "ahbgdc"));
  }

  public static boolean isSubsequence(String s, String t) {
    if (t == null && t == s || (t.length() == 0 && s.length() == 0))
      return true;
    else if (t == null || t.length() == 0)
      return false;
    if (s==null || s.length()==0)
      return true;

    int i = 0, j = 0;
    while (i < t.length()) {
      if (s.charAt(j) == t.charAt(i)) {
        i++;
        j++;
      } else {
        i++;
      }
      if (j == s.length())
        return true;
    }
    return false;
  }

}
