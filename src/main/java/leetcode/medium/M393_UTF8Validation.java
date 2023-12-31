package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/utf-8-validation
 * 
 * @author shivam.maharshi
 */
public class M393_UTF8Validation extends TestCase {

  @Test
  public void test() {
    assertEquals(true, validUtf8(new int[]{197, 130, 1}));
    assertEquals(false, validUtf8(new int[]{235, 140, 4}));
    assertEquals(false, validUtf8(new int[]{235}));
    assertEquals(false, validUtf8(new int[]{235, 140, 63, 4}));
    assertEquals(true, validUtf8(new int[]{235, 128, 128, 4}));
    assertEquals(true, validUtf8(new int[]{15 << 4, 128, 128, 128, 4}));
    assertEquals(5, getBytes(31 << 3));
    assertEquals(4, getBytes(15 << 4));
    assertEquals(3, getBytes(7 << 5));
    assertEquals(2, getBytes(3 << 6));
    assertEquals(1, getBytes(1 << 7));
    assertEquals(true, has10Prefix(1 << 7));
    assertEquals(true, isOneByte(64));
    assertEquals(true, isOneByte(63));
    assertEquals(true, isOneByte(127));
    assertEquals(false, isOneByte(128));
    assertEquals(false, isOneByte(129));
    assertEquals(false, isOneByte(255));
  }

  public static boolean validUtf8(int[] data) {
    int i = 0, l = data.length;
    while (i < l) {
      int n = data[i];
      if (!isValid(n))
        return false;
      if (!isOneByte(n)) {
        int b = getBytes(n);
        if (i + b > l)
          return false;
        for (int j = 1; j < b; j++)
          if (!has10Prefix(data[i + j]))
            return false;
        i += b;
      } else
        i++;
    }
    return true;
  }

  public static boolean has10Prefix(int n) {
    return (n & (1 << 7)) == (1<<7) && (n & (1 << 6)) == 0;
  }

  public static boolean isValid(int n) {
    return isOneByte(n) || (getBytes(n) < 5 && getBytes(n) > 1);
  }

  public static int getBytes(int n) {
    int c = 0;
    while ((n & (1 << 7)) != 0) {
      c++;
      n = n << 1;
    }
    return c;
  }

  public static boolean isOneByte(int n) {
    return (n & (1 << 7)) == 0;
  }

}
