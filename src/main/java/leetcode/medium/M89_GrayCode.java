package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/gray-code
 * 
 * @author shivam.maharshi
 */
public class M89_GrayCode extends TestCase {

  @Test
  public void test() {
    List<Integer> r = grayCode(3);
    for (int n : r)
      System.out.print(n + " ");
  }

  public static List<Integer> grayCode(int n) {
    List<Integer> r = new ArrayList<Integer>();
    if (n == 0)
      return r;
    Set<Integer> s = new HashSet<Integer>();
    int num = 0, c = 1 << n;
    while (c > 0) {
      num = getNext(num, s);
      s.add(num);
      r.add(num);
      c--;
    }
    return r;
  }

  public static Integer getNext(int num, Set<Integer> s) {
    int t = 0, invertBit = 1, i = 0;
    while (s.contains(t)) {
      t = num ^ (invertBit << i);
      i++;
    }
    return new Integer(t);
  }

}
