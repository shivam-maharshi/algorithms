package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author shivam.maharshi
 */
public class StringToInteger extends TestCase {

  public int myAtoi(String str) {
    int res = 0;
    boolean isNeg = false;
    String input = str.trim();
    input = reverse(input);
    input.trim();
    input = reverse(input);
    if (input.length() > 0) {
      char fc = input.charAt(0);
      if (fc == '-') {
        isNeg = true;
      } else if (fc == '+') {
        // do nothing
      } else if (getValue(fc) == -1) {
        return 0;
      } else {
        res = getValue(fc);
      }
    }

    for (int i = 1; i < input.length(); i++) {
      char c = input.charAt(i);
      int cValue = getValue(c);
      if (cValue == -1) {
        break;
      } else {
        if (!isNeg) {
          if (isIntLessThanMax(res, cValue)) {
            res = res * 10 + cValue;
          } else {
            res = Integer.MAX_VALUE;
            break;
          }
        } else {
          if (isIntMoreThanMin(res, cValue)) {
            res = res * 10 + cValue;
          } else {
            res = Integer.MIN_VALUE;
            break;
          }
        }
      }
    }
    return isNeg && res > 0 ? -1 * res : res;
  }

  public boolean isIntLessThanMax(int res, int cValue) {
    if (res < Integer.MAX_VALUE/10)
      return true;
    else if (res == Integer.MAX_VALUE / 10) {
      if ( cValue == 9 || cValue==8 || cValue==7)
      return false;
      else 
        return true;
    }
    return false;
  }

  public boolean isIntMoreThanMin(int res, int cValue) {
    if (res < Integer.MAX_VALUE/10)
      return true;
    else if (res == Integer.MAX_VALUE / 10) {
      if ( cValue == 9 || cValue == 8)
      return false;
      else 
        return true;
    }
    return false;
  }

  public int getValue(char c) {
    int ascii = (int) c;
    if (ascii >= 48 && ascii <= 57) {
      return ascii - 48;
    }
    return -1;
  }

  public String reverse(String s) {
    String res = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      res += s.charAt(i);
    }
    return res;
  }

  @Test
  public void test() {
    StringToInteger s = new StringToInteger();
    assertEquals(s.myAtoi("   2147483647"), 2147483647);
    assertEquals(s.myAtoi("   +2147483647"), 2147483647);
    assertEquals(s.myAtoi("   2147483646"), 2147483646);
    assertEquals(s.myAtoi("   +2147483646"), 2147483646);
    assertEquals(s.myAtoi("   2147483648"), 2147483647);
    assertEquals(s.myAtoi("   +2147483648"), 2147483647);
    assertEquals(s.myAtoi("   2147483647000000000"), 2147483647);
    assertEquals(s.myAtoi("   +214748364700000000"), 2147483647);
    assertEquals(s.myAtoi("   2147483647asdas"), 2147483647);

    assertEquals(s.myAtoi("   -2147483648"), -2147483648);
    assertEquals(s.myAtoi("   -2147483647"), -2147483647);
    assertEquals(s.myAtoi("   -2147483649"), -2147483648);
    assertEquals(s.myAtoi("   -214748364800000000"), -2147483648);
    assertEquals(s.myAtoi("   -2147483648asads"), -2147483648);
  }

}
