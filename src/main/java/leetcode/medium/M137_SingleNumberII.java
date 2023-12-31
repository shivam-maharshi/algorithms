package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/single-number-ii
 * 
 * @author shivam.maharshi
 */
public class M137_SingleNumberII extends TestCase {

  @Test
  public void test() {
    assertEquals(2, singleNumber(new int[] { 1, 2, 1, 1, 3, 3, 3 }));
    assertEquals(2, singleNumber(new int[] { 1, 2, 2, 1, 1, 3, 3, 3 }));
    assertEquals(9, singleNumber(new int[] { 6, 6, 6, 9, 3, 3, 3 }));
    assertEquals(9, singleNumber(new int[] { 6, 6, 6, 9, 9, 3, 3, 3 }));
    assertEquals(0, singleNumber(new int[] { 6, 0, 6, 3, 6, 3, 3 }));
    assertEquals(0, singleNumber(new int[] { 6, 0, 6, 3, 6, 3, 0, 3 }));
  }

  public static int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0)
      return -1;

    int r = 0;
    for (int i = 0; i < 32; i++) {
      int bitOneCount = 0;
      for (int j = 0; j < nums.length; j++) {
        if (((nums[j] >> i) & 1) == 1) {
          bitOneCount++;
          bitOneCount %= 3;
        }
      }

      if (bitOneCount != 0)
        r |= 1 << i;

    }
    return r;
  }

}
