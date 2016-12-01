package interviews;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class SumPairs extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, count(new int[] {}, 6));
    assertEquals(2, count(new int[] { 1, 2, 3, 4, 5, 6 }, 6));
    assertEquals(1, count(new int[] { 1, 2, 3, 4, 5, 5 }, 10));
  }

  public static int count(int[] a, int t) {
    int c = 0;
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      if (m.containsKey(t - a[i]))
        m.put(t - a[i], a[i]);
      else
        m.put(a[i], null);
    }

    for (Integer k : m.keySet())
      if (m.get(k) != null)
        c++;

    return c;
  }

}
