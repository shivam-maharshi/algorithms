package hackerrank;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.hackerrank.com/contests/w25/challenges/append-and-delete
 * 
 * @author shivam.maharshi
 */
public class AppendAndDelete extends TestCase {

  @Test
  public static void test() {
    assertEquals("Yes", convert("hacker", "hackerrank", 4));
    assertEquals("No", convert("hacker", "hackerrank", 3));
    assertEquals("Yes", convert("hacker", "hackerrank", 6));
    assertEquals("No", convert("hacker", "hackerrank", 5));
    assertEquals("Yes", convert("", "hackerrank", 12));
    assertEquals("No", convert("", "hackerrank", 11));
    assertEquals("Yes", convert("hackerrank", "", 12));
    assertEquals("Yes", convert("hackerrank", "", 11));
    assertEquals("Yes", convert("hackerrank", "hackerrank", 4));
    assertEquals("No", convert("hackerrank", "hackerrank", 1));
    assertEquals("Yes", convert("", "", 4));
    assertEquals("Yes", convert("", "", 5));
    assertEquals("Yes", convert("abc", "abc", 6));
    assertEquals("Yes", convert("abc", "abc", 7));
  }

  public static String convert(String s, String t, int k) {
    if (t.equals("") && k >= s.length())
      return "Yes";

    if (s.equals(t) && (k % 2 == 0 || k >= 2 * s.length()))
      return "Yes";

    if (s.length() <= t.length())
      return isPoss(s, t, k);

    return isPoss(t, s, k);
  }

  public static String isPoss(String s, String t, int k) {
    int i = 0;

    for (; i < s.length(); i++)
      if (s.charAt(i) != t.charAt(i))
        break;

    int diff = t.length() - i;

    if ((k - diff) % 2 == 0)
      return "Yes";
    else
      return "No";
  }

}
