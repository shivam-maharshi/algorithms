package interview.amazon;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.careercup.com/question?id=5652128598065152
 * 
 * @author shivam.maharshi
 */
public class AlphabetSeries extends TestCase {

  @Test
  public void test() {
    assertEquals(1, compute("a"));
    assertEquals(5, compute("ab"));
    assertEquals(1302061344, compute("l"));
    assertEquals("a", string(1));
    assertEquals("l", string(1302061344));
    assertEquals("kkkkkkkkkkkkbbaaa", string(1302061343));
  }

  public static int[] getValues() {
    int[] v = new int[12];
    v[0] = 1;
    for (int i = 1; i < 12; i++)
      v[i] = (v[i - 1] * (i + 1)) + i + 1;
    return v;
  }

  public static int compute(String s) {
    // Overflow after l
    int[] v = getValues();
    s = s.toLowerCase();
    int r = 0;
    for (char c : s.toCharArray())
      r += v[c - 'a'];
    return r;
  }

  public static String string(int n) {
    int[] v = getValues();
    return string(n, "", v, 11);
  }

  public static String string(int n, String s, int[] v, int i) {
    if (n == 0)
      return s;
    for (int j = i; j > -1; j--) {
      if (n >= v[j]) {
        String t = string(n - v[j], s + (char) (j + (int) 'a'), v, j);
        if (t != null)
          return t;
      }
    }
    return null;
  }

}
