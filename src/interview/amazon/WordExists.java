package interview.amazon;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Given a 2-D character array find if the given word can be formed by moving
 * up, down, right or left in the matrix.
 * 
 * @author shivam.maharshi
 */
public class WordExists extends TestCase {

  @Test
  public static void test() {
    assertEquals(false, exists(new char[0][0], "bake"));
    char[][] c = {{'a', 'b', 'c', 'd'}, {'k', 'a', 'g', 'h'}, {'e', 'f', 'g', 'h'}};
    assertEquals(true, exists(c, "bake"));
    assertEquals(false, exists(c, "cake"));
  }

  public static boolean exists(char[][] c, String s) {
    if (c == null || c.length == 0)
      return false;
    boolean[][] v = new boolean[c.length][c[0].length];
    for (int i = 0; i < c.length; i++) {
      for (int j = 0; j < c[0].length; j++) {
        if (exists(c, s, 0, v, i, j))
          return true;
      }
    }
    return false;
  }

  public static boolean exists(char[][] a, String s, int index, boolean[][] v, int r, int c) {
    if (!isValid(a, r, c) || v[r][c] || a[r][c] != s.charAt(index))
      return false;

    if (a[r][c] == s.charAt(index) && index == s.length() - 1)
      return true;

    v[r][c] = true;

    if (exists(a, s, index + 1, v, r + 1, c) || exists(a, s, index + 1, v, r - 1, c)
        || exists(a, s, index + 1, v, r, c + 1) || exists(a, s, index + 1, v, r, c - 1))
      return true;

    v[r][c] = false;
    return false;
  }

  public static boolean isValid(char[][] a, int r, int c) {
    return r >= 0 && r < a.length && c >= 0 && c < a[0].length;
  }

}
