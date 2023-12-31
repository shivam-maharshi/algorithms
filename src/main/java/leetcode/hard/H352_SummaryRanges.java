package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Link: https://leetcode.com/problems/data-stream-as-disjoint-intervals
 * 
 * @author shivam.maharshi
 */
public class H352_SummaryRanges {

  public static void main(String[] args) {
    leetcode.hard.H352_SummaryRanges s = new leetcode.hard.H352_SummaryRanges();
    s.addNum(1);
    s.print();
    s.addNum(3);
    s.print();
    s.addNum(7);
    s.print();
    s.addNum(2);
    s.print();
    s.addNum(6);
    s.print();
  }

  TreeMap<Integer, Interval> map;

  public H352_SummaryRanges() {
    this.map = new TreeMap<Integer, Interval>();
  }

  public void addNum(int val) {
    if (!map.containsKey(val)) {
      Integer l = map.lowerKey(val), h = map.higherKey(val);
      if (l != null && h != null && map.get(l).end == val - 1 && h == val + 1) {
        map.put(l, new Interval(l, map.get(h).end));
        map.remove(h);
      } else if (l != null && map.get(l).end >= val - 1) {
        map.put(l, new Interval(l, Math.max(map.get(l).end, val)));
      } else if (h != null && h == val + 1) {
        map.put(val, new Interval(val, map.get(h).end));
        map.remove(h);
      } else {
        map.put(val, new Interval(val, val));  
      }
    }
  }

  public List<Interval> getIntervals() {
    List<Interval> l = new ArrayList<>();
    for (Interval i : map.values())
      l.add(i);
    return l;
  }

  public void print() {
    for (Interval it : map.values())
      System.out.print("[" + it.start + " - " + it.end + "]");
    System.out.println();
  }

  private class Interval {
    int start;
    int end;

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

}
