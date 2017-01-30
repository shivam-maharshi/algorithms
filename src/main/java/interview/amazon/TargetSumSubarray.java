package interview.amazon;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Return the array that sums to the given target sum. Assume sum to be greater
 * than zero and array to contain only positive integers.
 * 
 * @author shivam.maharshi
 */
public class TargetSumSubarray extends TestCase {

  @Test
  public static void test() {
    assertEquals(null, getSum(null, 10));
    assertEquals(null, getSum(new int[] {}, 10));
    assertEquals(2, getSum(new int[] { 1, 1, 3, 4, 2 }, 6).size());
    assertEquals(2, getSum(new int[] { 2, 3, 4, 2 }, 5).size());
    assertEquals(null, getSum(new int[] { 1, 1, 3, 4, 2 }, 20));
    assertEquals(null, getSum(new int[] { 5, 5, 4, 4, 3 }, 2));
    assertEquals(5, getSum(new int[] { 1, 1, 1, 1, 1 }, 5).size());
    assertEquals(4, getSum(new int[] { 1, 1, 2, 1, 1 }, 5).size());
  }

  public static List<Integer> getSum(int[] a, int t) {
    if (a == null || a.length == 0)
      return null;
    List<Integer> r = new ArrayList<Integer>();
    r.add(a[0]);
    if (a.length == 1)
      return a[0] == t ? r : null;
    int h = 1, sum = a[0];
    while (h < a.length) {
      if (sum > t)
        sum -= r.remove(0);
      else {
        sum += a[h];
        r.add(a[h++]);
      }
      if (sum == t)
        return r;
    }
    return null;
  }

}
