package leetcode.easy;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/search-insert-position
 * 
 * @author shivam.maharshi
 */
public class E35_SearchInsertPosition extends TestCase {
  
  public int searchInsert(int[] nums, int target) {
    int l = 0, h = nums.length - 1;
    while (h >= l) {
      int m = ((h - l)/2) + l;
      if (nums[m] == target) {
        return m;
      } else if (nums[m] > target) {
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    
    if (h == -1)
      return 0;
    else if (nums[h] < target)
      return h+1;
    else
      return h;
  }
  
  @Test
  public void test() {
    assertEquals(2, searchInsert(new int[]{1, 3, 5, 7, 9}, 4));
    assertEquals(3, searchInsert(new int[]{1, 2, 3, 4, 5, 7, 9}, 4));
    assertEquals(1, searchInsert(new int[]{1}, 4));
    assertEquals(0, searchInsert(new int[]{9}, 4));
    assertEquals(0, searchInsert(new int[]{}, 4));
    assertEquals(5, searchInsert(new int[]{1, 10, 100, 1000, 10000}, 10001));
  }

}
