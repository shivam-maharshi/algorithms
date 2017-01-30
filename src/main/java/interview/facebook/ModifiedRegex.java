package interview.facebook;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Find if the given valid regex pattern is present in the input string where
 * '.' represents any character and '*' represents any occurrences. In a valid
 * regex two '*' cannot occur consecutively.
 * 
 * @author shivam.maharshi
 */
public class ModifiedRegex extends TestCase {

  @Test
  public static void test() {
    assertEquals(true, match("abccd", "a*.*d"));
    assertEquals(false, match("abccd", "a*.*c"));
    assertEquals(false, match("a", "*"));
    assertEquals(true, match("a", "a*"));
    assertEquals(true, match("a", "."));
    assertEquals(true, match("a", "a*"));
    assertEquals(false, match("", "a*"));
    assertEquals(true, match("", ""));
    assertEquals(true, match("abcde", ".*"));
    assertEquals(true, match("abcde", "..*.."));
    assertEquals(true, match("abcde", ".*.*."));
    assertEquals(true, match("abcde", "....."));
    assertEquals(true, match("abcde", "a*b*c*d*e*"));
    assertEquals(false, match("abcde", "a*b*d*e*"));
    assertEquals(false, match("abc", "abcd*"));
    assertEquals(false, match("abcde", "...."));
    assertEquals(true, match("abcde", "....*"));
    assertEquals(false, match("abcde", "....f"));
    assertEquals(true, match("abcdd", "....*"));
  }

  public static boolean match(String s, String p) {
    return match(s, p, 0, 0);
  }

  public static boolean match(String s, String p, int i, int j) {
    if (i == s.length() && j == p.length())
      return true;
    if (i >= s.length() || j >= p.length())
      return false;
    char sc = s.charAt(i), pc = p.charAt(j);
    if (j + 1 < p.length() && p.charAt(j + 1) == '*')
      return sc == pc || pc == '.' ? match(s, p, i + 1, j) || match(s, p, i + 1, j + 2) : false;
    return sc == pc || pc == '.' ? match(s, p, i + 1, j + 1) : false;
  }

}
