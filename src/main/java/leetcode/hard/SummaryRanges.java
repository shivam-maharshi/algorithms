package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * 
 * @author shivam.maharshi
 */
public class SummaryRanges {

  public static void main(String[] args) {
    SummaryRanges s = new SummaryRanges();
    s.addNum(1);
    s.print();
    s.addNum(3);
    s.print();
    s.addNum(7);
    s.print();
    s.addNum(2);
    s.print();
    s.addNum(6);
  }

  List<Interval> list;

  public SummaryRanges() {
    this.list = new ArrayList<>();
  }

  public void addNum(int val) {
    if (list.isEmpty()) {
      list.add(new Interval(val, val));
      return;
    }

    int i = search(val);
    if (val == (list.get(i).start - 1)) {
      if (i > 0 && val == list.get(i - 1).end + 1) {
        Interval in = new Interval(list.get(i - 1).start, list.get(i).end);
        list.remove(i);
        list.set(i - 1, in);
      } else {
        list.set(i, new Interval(val, list.get(i).end));
      }
    } else if (i > 0 && val == list.get(i - 1).end + 1) {
      list.set(i - 1, new Interval(list.get(i - 1).start, val));
    } else {
      list.add(0, new Interval(val, val));
    }
  }

  public List<Interval> getIntervals() {
    return list;
  }

  private int search(int n) {
    int l = 0, h = this.list.size() - 1, m = 0;
    while (l <= h) {
      m = l + (h - l) / 2;
      if (n == list.get(m).start)
        return m;
      else if (n < list.get(m).start) {
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return m;
  }

  public void print() {
    for (Interval it : list)
      System.out.print("[" + it.start + " - " + it.end + "]");

    System.out.println();
  }

  private class Interval {
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
