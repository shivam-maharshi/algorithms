package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 * 
 * @author shivam.maharshi
 */
public class M80_RemoveDuplicatesFromSortedArrayII extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, removeDuplicates(new int[] {}));
    assertEquals(2, removeDuplicates(new int[] { 1, 1 }));
    assertEquals(2, removeDuplicates(new int[] { 1, 2 }));
    assertEquals(2, removeDuplicates(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
    assertEquals(7, removeDuplicates(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
    assertEquals(6, removeDuplicates(new int[] { 1, 1, 2, 2, 3, 3 }));
    assertEquals(5, removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
  }

  public static int removeDuplicates(int[] nums) {
    if (nums == null)
      return 0;
    if (nums.length == 0 || nums.length == 1)
      return nums.length;

    int r = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[r - 1] != nums[i] || (nums[r - 1] == nums[i] && nums[r - 2] != nums[i])) {
        nums[r] = nums[i];
        r++;
      }
    }
    return r;
  }

}
