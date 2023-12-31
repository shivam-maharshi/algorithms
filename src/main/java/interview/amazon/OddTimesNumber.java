package interview.amazon;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Find out the number present odd number of times in the given list.
 * 
 * @author shivam.maharshi
 */
public class OddTimesNumber extends TestCase {

  @Test
  public void test() {
    assertEquals(5, get(Arrays.asList(new Integer[] { 1, 4, 2, 2, 7, 5, 7, 4, 1 })).intValue());
  }

  public static Integer get(List<Integer> l) {
    if (l == null || l.isEmpty())
      return null;
    Integer r = l.get(0);
    for (int i = 1; i < l.size(); i++)
      r ^= l.get(i);
    return r;
  }

}
