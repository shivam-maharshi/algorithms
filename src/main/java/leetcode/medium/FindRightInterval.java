package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/find-right-interval/
 * 
 * @author shivam.maharshi
 */
public class FindRightInterval extends TestCase {
  
  @Test
  public static void test() {
    int[] r = findRightInterval(new Interval[]{new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)});
    assertEquals(-1, r[0]);
    assertEquals(0, r[1]);
    assertEquals(1, r[2]);
  }

  public static int[] findRightInterval(Interval[] intervals) {
    int[] r = new int[intervals.length];
    Map<Interval, Integer> m = new HashMap<>();
    for (int i = 0; i < intervals.length; i++)
      m.put(intervals[i], i);
    Interval[] cp = Arrays.copyOf(intervals, intervals.length);
    Arrays.sort(intervals, new IComp());
    for (int i = 0; i < cp.length; i++) {
      Interval rr = bs(intervals, cp[i]);
      r[i] = rr == null ? -1 : m.get(rr);
    }
    return r;
  }

  private static Interval bs(Interval[] in, Interval i) {
    int l = 0, h = in.length - 1;
    Interval r = null;
    while (l <= h) {
      int m = l + (h - l) / 2;
      if (in[m].start == i.end) {
        return in[m];
      } else if (in[m].start > i.end) {
        r = in[m];
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return r;
  }

  private static class IComp implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
      return o1.start < o2.start ? -1 : 1;
    }
  }

  // O(n^2)
  public static int[] findRightIntervalOld(Interval[] intervals) {
    int[] r = new int[intervals.length];
    int[] v = new int[intervals.length];
    Arrays.fill(r, -1);
    Arrays.fill(v, Integer.MAX_VALUE);
    for (int i = 0; i < intervals.length; i++) {
      for (int j = 0; j < intervals.length; j++) {
        if (i != j && intervals[i].end <= intervals[j].start) {
          if (intervals[j].start < v[i]) {
            v[i] = intervals[j].start;
            r[i] = j;
          }
        }
      }
    }
    return r;
  }

  private static class Interval {
    int start;
    int end;

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

}
