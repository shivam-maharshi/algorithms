package interview.google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/merge-overlapping-intervals/
 * 
 * @author shivam.maharshi
 */
public class MergeOverlappingIntervals extends TestCase {

  @Test
  public static void test() {
    ArrayList<Interval> l = new ArrayList<>();
    l.add(new Interval(4, 4));
    l.add(new Interval(5, 27));
    l.add(new Interval(5, 31));
    l.add(new Interval(6, 20));
    assertEquals(3, merge(l).size());
  }

  public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    if (intervals == null || intervals.isEmpty())
      return intervals;
    intervals.sort(new IComp());
    Iterator<Interval> it = intervals.iterator();
    while (it.hasNext()) {
      Interval in = it.next();
      while (it.hasNext()) {
        Interval next = it.next();
        if (overlaps(in, next)) {
          in.end = Math.max(in.end, next.end);
          it.remove();
        } else
          in = next; // Must increment the cur pointer.
      }
    }
    return intervals;
  }

  static class IComp implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
      if (o1.start == o2.start)
        return o1.end < o2.end ? -1 : 1;
      return o1.start < o2.start ? -1 : 1;
    }

  }

  public static boolean overlaps(Interval i, Interval j) {
    return !(Math.min(i.end, j.end) < Math.max(i.start, j.start));
  }

  static class Interval {
    int start;
    int end;

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
