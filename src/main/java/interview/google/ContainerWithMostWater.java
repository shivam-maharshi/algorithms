package interview.google;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/container-with-most-water/
 * 
 * @author shivam.maharshi
 */
public class ContainerWithMostWater extends TestCase {

  @Test
  public static void test() {
    ArrayList<Integer> l = new ArrayList<>();
    l.add(1);
    l.add(5);
    l.add(4);
    l.add(3);
    assertEquals(6, maxArea(l));
  }

  public static int maxArea(ArrayList<Integer> a) {
    if (a == null || a.size() == 0)
      return 0;
    int r = 0, x = 0, y = a.size() - 1;
    while (x < y) {
      r = Math.max(r, Math.min(a.get(y), a.get(x)) * (y - x));
      if (a.get(y) < a.get(x))
        y--;
      else
        x++;
    }
    return r;
  }

}
