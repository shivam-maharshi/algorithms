package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/permutation-sequence/
 * 
 * @author shivam.maharshi
 */
public class PermutationSequence extends TestCase {

  @Test
  public static void test() {
    //assertEquals(getPermutation(3, 1), "123");
    assertEquals(getPermutation(3, 2), "132");
    //assertEquals(getPermutation(3, 3), "213");
    //assertEquals(getPermutation(3, 4), "231");
    //assertEquals(getPermutation(3, 5), "312");
    //assertEquals(getPermutation(3, 6), "321");
  }

  public static String getPermutation(int n, int k) {
    List<Integer> l = new ArrayList<>();
    l.add(0);

    for (int i = 1; i <= n; i++)
      l.add(i);

    int[] f = fact(n);

    return gp(n, k, "", l, f);
  }

  public static int[] fact(int n) {
    int[] f = new int[n + 1];
    f[0] = 1;
    for (int i = 1; i <= n; i++)
      f[i] = i * f[i - 1];

    return f;
  }

  public static String gp(int n, int k, String s, List<Integer> l, int[] f) {
    if (k == 1 || k == 0) {
      for (int i = 1; i < l.size(); i++)
        s += l.get(i);
      return s;
    }

    int i = 1;
    for (; i < l.size(); i++) {
      if (k >= f[i]) {
        break;
      }
    }

    int j = 1;
    for (; j <= i; j++) {
      if (k <= j * f[i]) {
        break;
      }
    }

    int t = l.get(j);
    l.remove(j);
    return gp(n, k - (f[i] * j), t + s, l, f);
  }

}
