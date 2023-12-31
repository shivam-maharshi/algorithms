package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/non-overlapping-intervals
 * 
 * @author shivam.maharshi
 */
public class M435_NonOverlappingIntervals extends TestCase {

  @Test
  public static void test () {
    assertEquals(1, eraseOverlapIntervals(new Interval[] {new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,3)}));
    assertEquals(3, eraseOverlapIntervals(new Interval[] {new Interval(1,2), new Interval(1,2), new Interval(1,2), new Interval(1,2)}));
    assertEquals(3, eraseOverlapIntervals(new Interval[] {new Interval(1,2), new Interval(1,2), new Interval(1,4), new Interval(1,4)}));
  }

  public static int eraseOverlapIntervals(Interval[] intervals) {
    int c = 0, last = Integer.MIN_VALUE;
    Arrays.sort(intervals, new Comp());
    for (int i = 0; i < intervals.length; i++) {
      if (last > intervals[i].start)
        c++;
      else
        last = intervals[i].end;
    }
    return c;
  }

  private static class Comp implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
      return o1.end < o2.end ? -1 : 1;
    }
  }

  private static class Interval {
    int start;
    int end;

    @SuppressWarnings("unused")
    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

}
