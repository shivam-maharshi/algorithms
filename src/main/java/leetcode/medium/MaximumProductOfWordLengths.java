package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/maximum-product-of-word-lengths/
 * 
 * @author shivam.maharshi
 */
public class MaximumProductOfWordLengths extends TestCase {

  @Test
  public static void test() {
    assertEquals(16, maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
    assertEquals(0, maxProduct(new String[] {"a", "aa", "aaa", "aaaa"}));
  }

  public static int maxProduct(String[] words) {
    int[] a = new int[words.length];
    // Setting j'th bit as 1.
    for (int i = 0; i < words.length; i++)
      for (int j = 0; j < words[i].length(); j++)
        a[i] |= 1 << (words[i].charAt(j) - 'a');
    
    int r = 0;
    for (int i = 0; i < words.length; i++)
      for (int j = i + 1; j < words.length; j++)
        r = (a[i] & a[j]) == 0 ? Math.max(words[i].length() * words[j].length(), r) : r;
    
    return r;
  }

}
