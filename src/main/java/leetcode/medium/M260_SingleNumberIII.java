package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/single-number-iii
 * 
 * @author shivam.maharshi
 */
public class M260_SingleNumberIII extends TestCase {

  @Test
  public void test() {
    assertEquals(5, singleNumber(new int[] { 3, 5 })[0]);
  }

  public static int[] singleNumber(int[] nums) {
    int x = 0, mask = 1;
    for (int i = 0; i < nums.length; i++)
      x ^= nums[i];

    // First 1 bit from right.
    while ((x & mask) == 0)
      mask = mask << 1;

    int n1 = 0, n2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & mask) == 0)
        n1 ^= nums[i];
      else
        n2 ^= nums[i];
    }

    return new int[] { n1, n2 };
  }

}
