package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/implement-strstr
 * 
 * @author shivam.maharshi
 */
public class E28_ImplementStr extends TestCase {

  public int strStr(String haystack, String needle) {
    if (needle == null || haystack == null || needle.length() > haystack.length())
      return -1;
    if(needle.length()==0)
      return 0;
    // int[] lps = getLongestProperPrefixWhichIsAlsoASuffix(needle);
    int j = 0, i = 0, start = 0;
    while (start <= haystack.length() - needle.length()) {
      if (haystack.charAt(start + i) == needle.charAt(j)) {
        i++;
        j++;
        if (j == needle.length())
          return start;
      } else {
        i = 0;
        j = 0;
        start++;
      }
    }
    return -1;
  }

  public int[] getLongestProperPrefixWhichIsAlsoASuffix(String s) {
    int[] lps = new int[s.length()];
    int len = 0;
    int i = 1;
    while (i < s.length()) {
      if (s.charAt(i) == s.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }

  @Test
  public void test() {
    E28_ImplementStr s = new E28_ImplementStr();
    assertEquals(0, s.strStr("asdasda", "asd"));
  }

}
