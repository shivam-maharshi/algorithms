package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/the-skyline-problem/
 * 
 * @author shivam.maharshi
 */
public class SkylineProblem {

  public static void main(String[] args) {
    int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };

    // int[][] buildings = { { 2, 9, 10 }, { 3, 12, 10 } };

    // List<int[]> sl = getSkyline(buildings);
    List<int[]> sl = new SkylineProblem().getLine(buildings);
    for (int[] a : sl)
      System.out.print("[" + a[0] + " " + a[1] + "], ");
  }

  /*
   * The idea of this solution is correct but it will fail for corner cases. Need to fix it.
   */
  public List<int[]> getLine(int[][] buildings) {
    List<int[]> res = new ArrayList<>();
    List<Pair> in = new ArrayList<>();
    for (int i = 0; i < buildings.length; i++) {
      in.add(new Pair(buildings[i][0], buildings[i][2], 0, i));
      in.add(new Pair(buildings[i][1], buildings[i][2], 1, i));
    }
    Collections.sort(in, new Pair());
    Queue<Pair> q = new PriorityQueue<>();
    Pair p = null;
    for (int i = 0; i < in.size(); i++) {
      p = in.get(i);
      if (p.cls == 0) {
        if ((q.isEmpty() && p.h != 0) || (p.h >= q.peek().h)) {
          // System.out.println("Added : " + p);
          res.add(new int[] { p.l, p.h });
        }
        q.add(p);
      } else {
        if (!q.isEmpty() && p.h == q.peek().h) {
          q.poll();
          // System.out.println("Removed : " + p);
          while (q.peek() != null && buildings[q.peek().index][1] <= p.l) {
            q.poll(); // Remove till next big that is further to cur.
          }
          res.add(new int[] { p.l, q.isEmpty() ? 0 : q.peek().h });
        }
      }
    }

    int h = 0;
    for (int i = 0; i < res.size(); i++) {
      if (res.get(i)[1] == h) {
        res.remove(i);
        i--;
      } else {
        h = res.get(i)[1];
      }
    }

    return res;
  }

  class Pair implements Comparator<Pair>, Comparable<Pair> {
    int l;
    int h;
    int cls;
    int index;

    public Pair() {
    }

    public Pair(int l, int h, int cls, int index) {
      this.l = l;
      this.h = h;
      this.cls = cls;
      this.index = index;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
      if (o1.l < o2.l) {
        return -1;
      } else if (o1.l == o2.l) {
        if (o1.h > o2.h) {
          return -1;
        } else if (o1.h == o2.h) {
          return o1.cls == 0 ? -1 : 1;
        } else {
          return 1;
        }
      } else {
        return 1;
      }
    }

    @Override
    public String toString() {
      return "Pair [l=" + l + ", h=" + h + ", cls=" + cls + ", index=" + index + "]";
    }

    @Override
    public int compareTo(Pair o) {
      if (this.h == o.h)
        return this.cls < o.cls ? -1 : 1;
      return this.h > o.h ? -1 : 1;
    }

  }

  /*
   * This is a O(n2) solution and not a simplified version. A better version
   * should be coded.
   */
  public static List<int[]> getSkyline(int[][] buildings) {
    Stack<Integer> st = new Stack<>();
    List<int[]> res = new ArrayList<int[]>();
    for (int i = 0; i < buildings.length; i++) {
      if (st.isEmpty()) {
        st.push(i);
        res.add(new int[] { buildings[i][0], buildings[i][2] });
      } else {
        if (buildings[st.peek()][1] >= buildings[i][0]) { // Top overlaps with
                                                          // current.
          if (buildings[st.peek()][2] > buildings[i][2]) { // Top taller than
                                                           // current.
            if (buildings[st.peek()][1] >= buildings[i][1]) { // Top extends
                                                              // further than
                                                              // current.
              continue; // Skip this.
            } else { // Top ends within current.
              int top = st.pop();
              if (st.isEmpty() || buildings[st.peek()][2] < buildings[i][2]) { // Next
                                                                               // highest
                                                                               // at
                                                                               // top
                                                                               // end
                                                                               // is
                                                                               // current.
                st.push(i);
                res.add(new int[] { buildings[top][1], buildings[i][2] });
              } else { // Next highest at top end is next stack element.
                res.add(new int[] { buildings[top][1], buildings[st.peek()][2] });
                pushCurrent(st, buildings, i);
              }
            }
          } else if (buildings[st.peek()][2] < buildings[i][2]) { // Top smaller
                                                                  // than
                                                                  // current.
            st.push(i);
            res.add(new int[] { buildings[i][0], buildings[i][2] });
          } else { // Top same as current.
            if (buildings[st.peek()][1] < buildings[i][1]) { // Top extends less
                                                             // than current.
              st.push(i);
            }
          }
        } else { // Top doesn't overlaps.
          Integer top = st.pop(); // Remove the top till you find next height
                                  // extending further than top.
          while (!st.isEmpty() && buildings[top][1] >= buildings[st.peek()][1]) {
            st.pop();
          }
          if (!st.isEmpty()) {
            res.add(new int[] { buildings[top][1], buildings[st.peek()][2] });
          } else {
            res.add(new int[] { buildings[top][1], 0 });
          }
          i--;
          continue;
        }
      }
    }

    while (!st.isEmpty()) {
      Integer top = st.pop(); // Remove the top till you find next height
                              // extending further than top.
      if (!st.isEmpty()) {
        while (buildings[top][1] >= buildings[st.peek()][1]) {
          st.pop();
        }
        if (!st.isEmpty()) {
          res.add(new int[] { buildings[top][1], buildings[st.peek()][2] });
          top = st.peek();
          st.pop();
        } else {
          res.add(new int[] { buildings[top][1], 0 });
        }
      } else {
        res.add(new int[] { buildings[top][1], 0 });
      }
    }

    return res;
  }

  public static void pushCurrent(Stack<Integer> st, int[][] buildings, int cur) {
    Stack<Integer> temp = new Stack<Integer>();
    boolean addCur = true;
    while (!st.isEmpty() && buildings[st.peek()][2] >= buildings[cur][2]) { // Stack
                                                                            // is
                                                                            // not
                                                                            // empty
                                                                            // and
                                                                            // top
                                                                            // is
                                                                            // taller
                                                                            // or
                                                                            // equal
                                                                            // to
                                                                            // cur.
      if (buildings[st.peek()][2] == buildings[cur][2]) { // Top equal to
                                                          // current.
        if (buildings[st.peek()][1] >= buildings[cur][1]) // Top reaches farther
                                                          // or equal to
                                                          // current.
          addCur = false;
        break;
      } else {
        temp.push(st.pop());
      }
    }

    if (addCur)
      st.push(cur);

    while (!temp.isEmpty()) {
      st.push(temp.pop());
    }

  }

}
