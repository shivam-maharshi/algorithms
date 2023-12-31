package interview.google;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/add-one-to-number/
 * 
 * @author shivam.maharshi
 */
public class AddOneToNumber extends TestCase {

  @Test
  public void test() {
    ArrayList<Integer> l = new ArrayList<>();
    l.add(1);
    l.add(2);
    l.add(3);
    assertEquals(3, plusOne(l).size());
    l.clear();
    l.add(9);
    l.add(9);
    l.add(9);
    assertEquals(4, plusOne(l).size());
  }

  public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
    if (a == null || a.isEmpty()) {
      ArrayList<Integer> l = new ArrayList<>();
      l.add(1);
      return l;
    }
    reverse(a);
    int n = 1;
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) + 1 < 10) {
        a.set(i, a.get(i) + 1);
        n = 0;
        break;
      } else
        a.set(i, 0);
    }
    if (n == 1)
      a.add(1);
    reverse(a);
    cleanZeroes(a);
    return a;
  }

  public static void reverse(ArrayList<Integer> ll) {
    int l = 0, h = ll.size() - 1;
    while (l < h) {
      int t = ll.get(l);
      ll.set(l, ll.get(h));
      ll.set(h, t);
      l++;
      h--;
    }
  }
  
  public static void cleanZeroes(ArrayList<Integer> a) {
    Iterator<Integer> it = a.iterator();
    while(it.hasNext() && it.next()==0)
      it.remove();
  }

}
