package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array find any pair that sums up to the given target. Take care of
 * overflows.
 *
 * @author: shivam.maharshi
 */
public class Interview8 {

  public static int[] get(int[] a, int s) {
    if (a == null || a.length == 0)
      return new int[] { -1 };

    Map<Integer, Integer> m = new HashMap<>();

    for (int i = 0; i < a.length; i++) {
      if (m.containsKey(s - a[i]))
        return new int[] { i, m.get(s - a[i]) };
      else
        m.put(a[i], i);
    }

    return new int[] { -1 };
  }

}
