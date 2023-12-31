package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/divide-two-integers
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * @author shivam.maharshi
 */
public class M29_DivideTwoIntegers extends TestCase {

  public int divide(int dividend, int divisor) {
    Long res = new Long(0);
    int index = 0;
    Long a = new Long(dividend), b = new Long(divisor);
    boolean dividendNegative = false, divisorNegative = false;
    if (divisor == 0)
      return Integer.MAX_VALUE;
    if (dividend < 0) {
      dividendNegative = true;
      dividend = -1*dividend;
      a = -1*a;
    }
    if (divisor < 0) {
      divisorNegative = true;
      divisor = -1*divisor;
      b = -1*b;
    }

    List<Node> list = new ArrayList<Node>();
    list.add(0, new Node(b, 1));
    while (true) {
      if (a < b) {
        if (b == divisor)
          break;
        b = getHalfValue(list, index).value;
        --index;
      } else {
        a = a - b;
        Node cur = list.get(index);
        res += cur.factor;
        b = getDoubleValue(list, index).value;
        ++index;
      }
    }

    if ((dividendNegative && divisorNegative) || (!dividendNegative && !divisorNegative)) {
      // pass
    } else {
      res = -res;
    }

    if (res > Integer.MAX_VALUE)
      return Integer.MAX_VALUE;

    return res.intValue();
  }

  public Node getDoubleValue(List<Node> list, int index) {
    Node lastNode = list.get(index);
    list.add(new Node(lastNode.value + lastNode.value, lastNode.factor + lastNode.factor));
    return list.get(index + 1);
  }

  public Node getHalfValue(List<Node> list, int index) {
    return list.get(index - 1);
  }

  @Test
  public void test() {
    M29_DivideTwoIntegers d = new M29_DivideTwoIntegers();
    // assertEquals(Integer.MAX_VALUE, d.divide(1, 0));
    // assertEquals(0, d.divide(0, 5));
    // assertEquals(0, d.divide(1, 5));
    // assertEquals(20, d.divide(100, 5));
    // assertEquals(20, d.divide(103, 5));
    // assertEquals(20, d.divide(103, 5));
    // assertEquals(-20, d.divide(-103, 5));
    // assertEquals(-20, d.divide(103, -5));
    // assertEquals(20, d.divide(-103, -5));
    // assertEquals(2147483647, d.divide(-2147483648, -1));
   // assertEquals(-1, d.divide(1, -1));
    assertEquals(1, d.divide(-2147483648, -2147483648));
  }

}

class Node {
  public long value;
  public long factor;

  public Node(long value, long factor) {
    this.value = value;
    this.factor = factor;
  }
}