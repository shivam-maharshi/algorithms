package hackerrank;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

/**
 * Given a string calculate the maximum number of distinct palindromes that can
 * be formed from it.
 * 
 * @author shivam.maharshi
 *
 */
public class DistinctSubPalindrome extends TestCase {

  public static void test() {
    assertEquals(5, palindrome("aabaa"));
    assertEquals(1, palindrome("a"));
    assertEquals(0, palindrome(""));
  }

  public static int palindrome(String str) {
    Set<String> r = new HashSet<>();

    for (int i = 0; i < str.length(); i++) {
      String s = "" + str.charAt(i);
      r.add(s);

      int l = i - 1, h = i + 1;

      while (l >= 0 && h < str.length()) {
        if (str.charAt(l) == str.charAt(h)) {
          s = str.charAt(l) + s + str.charAt(h);
          r.add(s);
          l--;
          h++;
        } else {
          break;
        }
      }

      s = "";
      l = i;
      h = i + 1;
      while (l >= 0 && h < str.length()) {
        if (str.charAt(l) == str.charAt(h)) {
          s = str.charAt(l) + s + str.charAt(h);
          r.add(s);
          l--;
          h++;
        } else {
          break;
        }
      }

    }

    return r.size();
  }

}
