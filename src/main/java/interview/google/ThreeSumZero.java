package interview.google;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/3-sum-zero/
 * 
 * @author shivam.maharshi
 */
public class ThreeSumZero extends TestCase {

  @Test
  public static void test() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(-1);
    a.add(-1);
    a.add(-1);
    a.add(1);
    a.add(0);
    a.add(1);
    a.add(2);
    a.add(-1);
    a.add(-4);
    assertEquals(2, threeSum(a).size());
  }

  /*
   * The important part is to always avoid duplicate by incrementing i and l
   * till you get a new value in their respective loops.
   */
  public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
    ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    if (a == null || a.size() < 3)
      return r;
    Collections.sort(a);
    int i = 0;
    while (i < a.size() - 2) {
      int l = i + 1, cur = a.get(i), h = a.size() - 1;
      while (h > l) {
        int low = a.get(l);
        if (cur + low + a.get(h) == 0) {
          ArrayList<Integer> t = new ArrayList<Integer>();
          t.add(cur);
          t.add(low);
          t.add(a.get(h));
          r.add(t);
          while (l < h && a.get(l) == low)
            l++;
          h--;
        } else if (a.get(i) + a.get(l) + a.get(h) > 0)
          h--;
        else
          l++;
      }
      while (i < h && a.get(i) == cur)
        i++;
    }
    return r;
  }

}
