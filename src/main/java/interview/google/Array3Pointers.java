package interview.google;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/array-3-pointers/
 * 
 * @author shivam.maharshi
 */
public class Array3Pointers extends TestCase {

  @Test
  public static void test() {
    assertEquals(5, minimize(Arrays.asList(new Integer[] { 1, 4, 10 }), Arrays.asList(new Integer[] { 2, 15, 20 }),
        Arrays.asList(new Integer[] { 10, 12 })));
  }

  public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
    int r = Integer.MAX_VALUE, i = 0, j = 0, k = 0, as = a.size(), bs = b.size(), cs = c.size(),
        min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    while (i < as && j < bs && k < cs) {
      min = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
      max = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));
      r = Math.min(r, max - min);
      if (r == 0)
        break;
      else if (min == a.get(i))
        i++;
      else if (min == b.get(j))
        j++;
      else
        k++;
    }
    return r;
  }

}
