package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * @author shivam.maharshi
 */
public class LongestRepeatingCharacterReplacement extends TestCase {

  @Test
  public static void test() {
    assertEquals(4, characterReplacement("ABAB", 2));
    assertEquals(4, characterReplacement("AABABBA", 1));
    assertEquals(1, characterReplacement("A", 0));
    assertEquals(1, characterReplacement("A", 100));
    assertEquals(2, characterReplacement("AABCDEFGHI", 0));
    assertEquals(3, characterReplacement("AABCDEFGHI", 1));
    assertEquals(8, characterReplacement("AABBCABA", 4));
    assertEquals(6, characterReplacement("AABCBABB", 2));
    assertEquals(0, characterReplacement("", 2));
  }

  // Apply the sliding window logic.
  public static int characterReplacement(String s, int k) {
    int[] c = new int[26];
    for (int i = 'A'; i <= 'Z'; i++) {
      int l = 0, h = 0, count = 0;
      while (h < s.length()) {
        if(s.charAt(h)!=i)
          count++;
        
        while (count > k) {
          if (s.charAt(l)!=i)
            count--;
          l++;
        }
        c[i - 'A'] = Math.max(c[i - 'A'], h - l + 1);
        h++;
      }
    }
    return max(c);
  }

  public static int max(int[] c) {
    int r = Integer.MIN_VALUE;
    for (int cc : c)
      r = Math.max(r, cc);
    return r;
  }

}
