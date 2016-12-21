package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 
 * @author shivam.maharshi
 */
public class MaximumXOROfTwoNumbersInAnArray extends TestCase {

  @Test
  public static void test() {
    assertEquals(28, findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));
  }

  public static int findMaximumXOR(int[] nums) {
    int max = 0, mask = 0;
    for (int i = 31; i >= 0; i--) {
      mask = mask | (1 << i);
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        set.add(num & mask);
      }
      int tmp = max | (1 << i);
      for (int prefix : set) {
        if (set.contains(tmp ^ prefix)) {
          max = tmp;
          break;
        }
      }
    }
    return max;
  }

}
