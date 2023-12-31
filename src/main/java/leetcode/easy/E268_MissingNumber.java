package leetcode.easy;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/missing-number
 * 
 * @author shivam.maharshi
 */
public class E268_MissingNumber extends TestCase {
  
  @Test
  public void test() {
    assertEquals(2, missingNumber(new int[]{0,1,3}));
    assertEquals(0, missingNumber(new int[]{1,2,3}));
    assertEquals(7, missingNumber(new int[]{0,1,2,3,4,5,6,8,9}));
  }

  public static int missingNumber(int[] nums) {
    int r = 0;
    for(int i=0; i<nums.length; i++)
      r ^= nums[i] ^ i;
    return r ^ nums.length;
  }

}
