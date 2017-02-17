package interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 * 
 * @author shivam.maharshi
 */
public class IntersectionOfSortedArrays extends TestCase {

  @Test
  public static void test() {
    assertEquals(4, intersect(Arrays.asList(new Integer[]{1,2,3,3,4,5,6}), Arrays.asList(new Integer[] {0,1,3,4,5})).size());
    assertEquals(1, intersect(Arrays.asList(new Integer[]{10000000}), Arrays.asList(new Integer[] {10000000})).size());
  }
  
  public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
    ArrayList<Integer> r = new ArrayList<>();
    if (a == null || a.size() == 0 || b == null || b.size() == 0)
      return r;
    int i =0, j =0;
    while (i < a.size() && j < b.size()) {
      if (a.get(i).intValue() == b.get(j).intValue()) {
        r.add(a.get(i));
        i ++;
        j ++;
      } else if (a.get(i) < b.get(j))
        i++;
      else
        j++;
    }
    return r;
  }

}
