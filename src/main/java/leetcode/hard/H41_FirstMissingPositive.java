package leetcode.hard;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/first-missing-positive
 * 
 * @author shivam.maharshi
 */
public class H41_FirstMissingPositive extends TestCase {

  @Test
  public void test() {
    assertEquals(3, firstMissingPositive(new int[] { 1, 2, 0 }));
    assertEquals(2, firstMissingPositive(new int[] { 3, 4, -1, 1 }));
    assertEquals(6, firstMissingPositive(new int[] { 1, 3, 4, -1, 1, 5, 2 }));
    assertEquals(8, firstMissingPositive(new int[] { 1, 2, 3, 5, 4, 6, 7 }));
  }

  public static int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0)
      return 1;
    for (int i = 0; i < nums.length; i++)
      while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
        int temp = nums[i];
        nums[i] = nums[nums[i] - 1];
        nums[temp - 1] = temp;
      }
    for (int i = 0; i < nums.length; i++)
      if (nums[i] != i + 1)
        return i + 1;
    return nums.length + 1;
  }

}
