package interview.google;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author shivam.maharshi
 */
public class RemoveDuplicatesFromSortedArray extends TestCase {

  @Test
  public void test() {
    ArrayList<Integer> l = new ArrayList<>();
    l.add(1);
    l.add(1);
    l.add(1);
    l.add(2);
    l.add(2);
    l.add(3);
    l.add(4);
    l.add(4);
    l.add(10);
    l.add(15);
    assertEquals(6, removeDuplicates(l));
  }

  public static int removeDuplicates(ArrayList<Integer> a) {
    if (a == null || a.size() == 0)
      return 0;
    int i = 0, j = 1;
    while (j < a.size()) {
      if (a.get(i).intValue() != a.get(j).intValue())
        a.set(++i, a.get(j).intValue());
      j++;
    }
    return i + 1;
  }

  /*
   * This is O(n^2) solution because it.remove is O(n).
   */
  public static int removeDuplicatesIt(ArrayList<Integer> a) {
    if (a == null || a.size() == 0)
      return 0;
    Iterator<Integer> it = a.iterator();
    int c = it.next().intValue();
    while (it.hasNext()) {
      int n = it.next().intValue();
      if (n != c)
        c = n;
      else
        it.remove();
    }
    return a.size();
  }

}
