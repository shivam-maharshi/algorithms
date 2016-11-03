package hackerrank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.hackerrank.com/contests/w25/challenges/between-two-sets
 * 
 * @author shivam.maharshi
 */
public class BetweenTwoSets extends TestCase {

  @Test
  public static void test() {
    int[] a = new int[] { 2, 4 };
    int[] b = new int[] { 16, 32, 96 };
    assertEquals(3, get(a, b));
  }

  public static int get(int[] a, int[] b) {
    List<Integer> n = new ArrayList<>();
    for (int i = 1; i <= 100; i++) {
      for (int j = 0; j < a.length; j++) {
        if (i % a[j] == 0 && j == a.length - 1) {
          n.add(i);
        } else if (i % a[j] != 0) {
          break;
        }
      }
    }

    for (int i = 0; i < n.size(); i++) {
      for (int j = 0; j < b.length; j++) {
        if ((b[j] % n.get(i)) != 0) {
          n.remove(i);
          i--;
          break;
        }
      }
    }

    return n.size();
  }

}
