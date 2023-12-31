package interview.google;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 * 
 * @author shivam.maharshi
 */
public class KthRowOfPascalsTriangle extends TestCase {

  @Test
  public void test() {
    assertEquals(0, getRow(-1).size());
    assertEquals(1, getRow(0).size());
    assertEquals(2, getRow(1).size());
    assertEquals(3, getRow(2).size());
    assertEquals(4, getRow(3).size());
    assertEquals(5, getRow(4).size());
    assertEquals(6, getRow(5).size());
  }

  public static ArrayList<Integer> getRow(int a) {
    ArrayList<Integer> l = new ArrayList<>(), t = new ArrayList<>();
    if (a < 0)
      return l;
    int i = 1;
    t.add(1);
    while (i <= a) {
      l.add(1);
      for (int j = 0; j < i - 1; j++)
        l.add(t.get(j) + t.get(j + 1));
      l.add(1);
      t = l;
      l = new ArrayList<>();
      i++;
    }
    return t;
  }

}
