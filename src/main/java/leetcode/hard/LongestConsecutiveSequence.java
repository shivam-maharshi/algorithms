package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author shivam.maharshi
 */
public class LongestConsecutiveSequence extends TestCase {

  @Test
  public static void test() {
    //assertEquals(0, longestConsecutive(null));
    assertEquals(0, longestConsecutive(new int[] { }));
    assertEquals(1, longestConsecutive(new int[] { 100, 4, 200, 6}));
    assertEquals(6, longestConsecutive(new int[] { 6, 5, 4, 3, 2, 1}));
    assertEquals(3, longestConsecutive(new int[] { 6, 5, 4, -2, 2, 1, 0}));
    assertEquals(4, longestConsecutive(new int[] { -1, -2, -3, -4, 5}));
    assertEquals(1, longestConsecutive(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE}));
    assertEquals(4, longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
  }

  public static int longestConsecutive(int[] nums) {
    Map<Integer, Boolean> m= new HashMap<>();
    int r = 0;
    for (int n : nums)
      m.put(n, null);
    for (Integer k : m.keySet()) {
      int i = k, c = 0;
      while (m.containsKey(i) && m.get(i) == null) {
        if (i != Integer.MIN_VALUE)
          i--;
        else
          break;
      }
      if (!m.containsKey(i))
        i++;
      while (m.containsKey(i) && m.get(i) == null) {
        c++;
        m.put(i, true);
        if (i != Integer.MAX_VALUE)
          i++;
        else
          break;
      }
      r = Math.max(r, c);
    }
    return r;
  }

}
