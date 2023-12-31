package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 
 * @author shivam.maharshi
 */
public class M395_LongestSubstringWithAtLeastKRepeatingCharacters extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, longestSubstring("", 1));
    assertEquals(0, longestSubstring("", 7));
    assertEquals(8, longestSubstring("abcdabcd", 1));
    assertEquals(8, longestSubstring("abcdabcd", 2));
    assertEquals(0, longestSubstring("abcdabcd", 3));
    assertEquals(0, longestSubstring("abcdeabcd", 2));
    assertEquals(3, longestSubstring("aaabb", 3));
    assertEquals(5, longestSubstring("ababbc", 2));
    assertEquals(3, longestSubstring("bbaaacbd", 3));
  }

  public static int longestSubstring(String s, int k) {
    Map<Character, Integer> m = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (m.containsKey(c))
        m.put(c, m.get(c) + 1);
      else
        m.put(c, 1);
    }

    Set<Character> set = new HashSet<>();
    Set<Entry<Character, Integer>> enties = m.entrySet();
    for (Entry<Character, Integer> e : enties)
      if (e.getValue() > 0 && e.getValue() < k)
        set.add(e.getKey());

    if (set.isEmpty())
      return s.length();

    int max = 0, i = 0, j = 0;
    while (j <= s.length() && i < s.length()) {
      if (j==s.length() || set.contains(s.charAt(j))) {
        max = Math.max(max, longestSubstring(s.substring(i, j), k));
        i = j + 1;
      }
      j++;
    }
    
    return max;
  }

}
